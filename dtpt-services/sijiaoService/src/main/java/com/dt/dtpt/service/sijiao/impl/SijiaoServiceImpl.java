package com.dt.dtpt.service.sijiao.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.dt.dtpt.util.UUID;

import javax.ws.rs.PathParam;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dt.dtpt.mybatis.model.publicwx.WxPayConfig;
import com.dt.dtpt.mybatis.model.sijiao.EduCourse;
import com.dt.dtpt.mybatis.model.sijiao.EduCourseStudent;
import com.dt.dtpt.mybatis.model.sijiao.EduStudent;
import com.dt.dtpt.mybatis.model.sijiao.EduTeacher;
import com.dt.dtpt.service.impl.EduCourseService;
import com.dt.dtpt.service.impl.EduCourseStudentService;
import com.dt.dtpt.service.impl.EduStudentService;
import com.dt.dtpt.service.impl.EduTeacherService;
import com.dt.dtpt.service.publicwx.PublicwxService;
import com.dt.dtpt.service.sijiao.SijiaoService;
import com.dt.dtpt.util.Result;
import com.dt.dtpt.util.wx.WxPay;
import com.dt.dtpt.vo.EduCourseStudentView;

@Service
@Transactional(readOnly = true)
public class SijiaoServiceImpl implements SijiaoService {

	protected transient final Log log = LogFactory.getLog(SijiaoServiceImpl.class);
	public static Map<String, LinkedList<EduCourse>> shCourses = new HashMap<String, LinkedList<EduCourse>>();
	
	public static Map<String, Long> sysnTimes = new HashMap<String, Long>();
	
	public static final Long sysnTime = 5 * 60 * 1000l;
	
	@Autowired
	EduCourseService eduCourseService;
	
	@Autowired
	EduTeacherService eduTeacherService;
	
	@Autowired
	EduStudentService eduStudentService;
	
	@Autowired
	EduCourseStudentService eduCourseStudentService;
	
	@Autowired
	PublicwxService publicwxService;
	
	private void reloadShCourses(String shId){
		if(shCourses.containsKey(shId)) shCourses.remove(shId);
		if(sysnTimes.containsKey(shId)) sysnTimes.remove(shId);
		this.sysnShCourses(shId);
	}
	
	private void addCoursePayedJe(String shId,String courseId,String payJe){
		if(!shCourses.containsKey(shId)) this.reloadShCourses(shId);
		if(shCourses.containsKey(shId)){
			for(EduCourse ec:shCourses.get(shId)){
				if(ec.getCourseId().equals(courseId)){
					int paynum = ec.getPayedStudents() + 1;
					BigDecimal je = BigDecimal.valueOf(Double.valueOf(ec.getPayedJe()+"") + Double.valueOf(payJe));
					ec.setPayedJe(je);
					ec.setPayStudents(paynum);
					break;
				}
			}
		}
	}
	
	private void updateCoursePaynum(String shId,String courseId,int num){
		if(!shCourses.containsKey(shId)) this.reloadShCourses(shId);
		if(shCourses.containsKey(shId)){
			for(EduCourse ec:shCourses.get(shId)){
				if(ec.getCourseId().equals(courseId)){
					int paynum = ec.getPayStudents() + num;
					if(paynum<0) paynum = 0;
					if(paynum>ec.getMaxStudents()) paynum = ec.getMaxStudents();
					ec.setPayStudents(paynum);
					break;
				}
			}
		}
	}
	
	private void addShCourses(String shId,EduCourse eduCourse){
		/*if(shCourses.containsKey(shId)){
			shCourses.get(shId).add(eduCourse);
		}else{
		}*/
		this.reloadShCourses(shId);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<EduCourse> sysnShCourses(String shId){
		List<EduCourse> ecs = null;
		Date date = new Date();
		if(shCourses.containsKey(shId)){
			Long st = sysnTimes.get(shId);
			if(date.getTime() - st > sysnTime){
				shCourses.put(shId, null);
				String sql = "select ec.* from edu_course ec where ec.USER_ID=? and ec.END_DATE>? order by ec.EDIT_DATE desc";
				ecs = eduCourseStudentService.getJdbcTemplate().query(sql, new Object[]{shId,date},new BeanPropertyRowMapper(EduCourse.class));
				LinkedList<EduCourse> lecs = new LinkedList<EduCourse>();
				if(ecs != null) lecs.addAll(ecs);
				shCourses.put(shId, lecs);
				sysnTimes.put(shId, new Date().getTime());
			}
		}else{
			String sql = "select ec.* from edu_course ec where ec.USER_ID=? and ec.END_DATE>? order by ec.EDIT_DATE desc";
			ecs = eduCourseStudentService.getJdbcTemplate().query(sql, new Object[]{shId,date},new BeanPropertyRowMapper(EduCourse.class));
			LinkedList<EduCourse> lecs = new LinkedList<EduCourse>();
			if(ecs != null) lecs.addAll(ecs);
			shCourses.put(shId, lecs);
			sysnTimes.put(shId, new Date().getTime());
		}
		ecs = shCourses.get(shId);
		return ecs;
	}
	
	public Result isWxManerger(@PathParam("shId") String shId, @PathParam("userOpenID") String userOpenID) {
		return publicwxService.isManerger(userOpenID, shId);
	}

	public Result findWxCourses(@PathParam("shId") String shId, EduCourse eduCourse,
			@PathParam("pageNumber") int pageNumber, @PathParam("pageSize") int pageSize) {
		if(shId != null && !"".equals(shId)){
			List<EduCourse> ecs = sysnShCourses(shId);
			int total = ecs.size();
			int start = (pageNumber-1) * pageSize;
			if(start < 0) start = 0;
			int end = pageNumber * pageSize;
			if(start >= total) ecs = new ArrayList<EduCourse>();
			if(end > total) end = total;
			if(start > end) end = start;
			ecs = ecs.subList(start, end);
			return Result.success(ecs);
		}else{
			String msg = "商户编号为空";
			log.error(msg);
			return Result.failure("参数校验失败", msg);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@SuppressWarnings("deprecation")
	public Result addCourseByAdmin(@PathParam("shId") String shId, @PathParam("userOpenID") String userOpenID, EduCourse course) {
		if(isWxManerger(shId, userOpenID).isSuccess()){
			if(course != null && course.getCourseName() != null && !"".equals(course.getCourseName())
					&& course.getSubjectSub() != null && !"".equals(course.getSubjectSub())
					&& course.getTeacherName() != null && !"".equals(course.getTeacherName())
					&& course.getSemester() != null && course.getStartDate() != null
					&& course.getEndDate() != null && course.getTeachTime() != null
					&& course.getTotalCourse() != null && course.getMaxStudents() != null
					&& course.getCourseInfo() != null && !"".equals(course.getCourseInfo())){	
				Date date = new Date();
				EduTeacher teacher=new EduTeacher();
				teacher.setTeacherName(course.getTeacherName());
				List<EduTeacher> teachers = eduTeacherService.select(teacher);
				String teacherId = null;
				if(teachers != null && teachers.size() > 0){
					teacherId = teachers.get(0).getTeacherId();
				}else{
					teacherId = UUID.randomUUID().toString();
					teacher.setTeacherId(teacherId);
					teacher.setEditDate(date);
					teacher.setUserId(shId);
					int rs = eduTeacherService.save(teacher);
					if(rs < 1) teacherId = null;
				}
				course.setTeacherId(teacherId);
				course.setCourseId(UUID.randomUUID().toString());
				course.setEditDate(date);
				course.setPayStudents(0);
				course.setSubject("1");
				course.setYear((date.getYear()+1900) + "");
				course.setUserId(shId);
				course.setPayedStudents(0);
				course.setPayedJe(BigDecimal.valueOf(0d));
				int rs = eduCourseService.save(course);
				if(rs>0) {
					addShCourses(shId, course);
					return Result.success();
				}
				String msg = "课程添加失败";
				log.error(msg);
				return Result.failure(msg);
			}else{
				String msg = "需要添加的课程为空或某些必要内容为空";
				log.error(msg);
				return Result.failure("参数校验失败",msg );
			}
		}else{
			String msg = "操作的用户非管理员";
			log.error(msg);
			return Result.failure("参数校验失败", msg);
		}
	}

	public Result findEduStudents(@PathParam("userOpenID") String userOpenID) {
		if(userOpenID != null && !"".equals(userOpenID)){
			EduStudent student = new EduStudent();
			student.setWxOpenid(userOpenID);
			List<EduStudent> students = eduStudentService.select(student);
			return Result.success(students);
		}else{
			String msg = "用户微信OPENID为空";
			log.error(msg);
			return Result.failure("参数校验失败",msg);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Result addStudentByWx(@PathParam("shId") String shId,@PathParam("userOpenID") String userOpenID, EduStudent eduStudent) {
		if(userOpenID != null && !"".equals(userOpenID)){
			if(eduStudent != null && eduStudent.getStudentName() != null && !"".equals(eduStudent.getStudentName())
					&& eduStudent.getPhone() != null && !"".equals(eduStudent.getPhone())
					&& eduStudent.getBirthday() != null && eduStudent.getSex() != null 
					&& eduStudent.getInGrade() != null){
				Date date = new Date();
				eduStudent.setEditDate(date);
				eduStudent.setWxOpenid(userOpenID);
				eduStudent.setStudentId(UUID.randomUUID().toString());
				eduStudent.setUserId(shId);
				int rs = eduStudentService.save(eduStudent);
				if(rs > 0) return Result.success(eduStudent);
				String msg = "添加学员失败";
				log.error(msg);
				return Result.failure(msg);
			}else{				
				String msg = "需要添加的学生对象为空或某些必填内容为空";
				log.error(msg);
				return Result.failure("参数校验失败",msg);
			}
		}else{
			String msg = "用户微信OPENID为空";
			log.error(msg);
			return Result.failure("参数校验失败",msg);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional(propagation = Propagation.REQUIRED)
	public Result addCourseByWx(@PathParam("userOpenID") String userOpenID, @PathParam("courseId") String courseId) {
		if(userOpenID != null && !"".equals(userOpenID) && courseId != null && !"".equals(courseId)){
			EduStudent eduStudent = new EduStudent();
			eduStudent.setWxOpenid(userOpenID);
			List<EduStudent> students = eduStudentService.select(eduStudent);
			if(students != null && students.size() > 0){
				eduStudent = students.get(0);
			}else{
				String msg = "此微信下面还没有学员";
				log.error(msg);
				return Result.failure(msg);
			}
			String sql = "select ec.* from edu_course_student ec where ec.COURSE_ID=? and ec.STUDENT_ID=? and (ec.IS_PAYED='0' or ec.IS_PAYED='2') ";
			List<EduCourseStudent> qcses = eduCourseStudentService.getJdbcTemplate().query(sql, new Object[]{courseId, eduStudent.getStudentId()},new BeanPropertyRowMapper(EduCourseStudent.class));
			if(qcses != null && qcses.size() > 0) return new Result(true,"该课程您已经添加",null,qcses.get(0).getCourseSid());
			EduCourse course = new EduCourse();
			course.setCourseId(courseId);
			course = eduCourseService.selectOne(course);
			if(course != null){
				if(course.getMaxStudents() - course.getPayStudents() < 1){
					String msg = "该班级已报满";
					log.error(msg);
					return Result.failure(msg);
				}
				sql = "update edu_course ec set ec.PAY_STUDENTS=ec.PAY_STUDENTS + 1 where ec.COURSE_ID=? and ec.PAY_STUDENTS<ec.MAX_STUDENTS";
				int rs = eduCourseService.getJdbcTemplate().update(sql, new Object[]{courseId});
				if(rs < 1){
					String msg = "该班级已报满";
					log.error(msg);
					return Result.failure("该班级已报满");
				} 
				Date date = new Date();
				EduCourseStudent cs = new EduCourseStudent();
				cs.setCourseId(courseId);
				cs.setCourseName(course.getCourseName());
				cs.setCourseSid(UUID.randomUUID().toString());
				cs.setEditDate(date);
				cs.setIsPayed(0);
				cs.setStudentId(eduStudent.getStudentId());
				cs.setStudentName(eduStudent.getStudentName());
				cs.setSubject(course.getSubject());
				cs.setSubjectSub(course.getSubjectSub());
				cs.setUserId(course.getUserId());
				rs = eduCourseStudentService.save(cs);
				this.updateCoursePaynum(course.getUserId(), courseId, 1);
				if(rs > 0) return new Result(true,null,null,cs.getCourseSid());
			}else{
				String msg = "系统中未查到该课程";
				log.error(msg);
				return Result.failure(msg);
			}
			String msg = "添加学员失败";
			log.error(msg);
			return Result.failure(msg);
		}else{
			String msg = "用户微信OPENID或课程编号为空";
			log.error(msg);
			return Result.failure("参数校验失败",msg);
		}
	}

	public Result getCourse(@PathParam("courseId") String courseId) {
		if(courseId != null && !"".equals(courseId)){
			EduCourse course = new EduCourse();
			course.setCourseId(courseId);
			course = eduCourseService.selectOne(course);
			return Result.success(course);
		}else{
			String msg = "课程编号为空";
			log.error(msg);
			return Result.failure("参数校验失败",msg);
		}
	}

	public Result getStudent(@PathParam("studentId") String studentId) {
		if(studentId != null && !"".equals(studentId)){
			EduStudent student = new EduStudent();
			student.setStudentId(studentId);
			student = eduStudentService.selectOne(student);
			return Result.success(student);
		}else{
			String msg = "学员编号为空";
			log.error(msg);
			return Result.failure("参数校验失败",msg);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Result payOk(@PathParam("courseSid") String courseSid,String payJe) {
		if(courseSid != null && !"".equals(courseSid) && payJe != null && !"".equals(payJe)){
			EduCourseStudent cs = new EduCourseStudent();
			cs.setCourseSid(courseSid);
			cs = eduCourseStudentService.selectOne(cs);
			if(cs != null){
				String sql = "update edu_course_student e set e.is_payed='1',e.pay_type='1',e.pay_date=?,e.pay_je=? where e.course_sid=? and e.is_payed='2'";
				int rs = eduCourseStudentService.getJdbcTemplate().update(sql, new Object[]{new Date(),payJe,courseSid});
				if(rs > 0 ){
					sql = "update edu_course e set e.payed_students=e.payed_students+1,e.payed_je=e.payed_je+? where e.course_id=?";
					rs = eduCourseStudentService.getJdbcTemplate().update(sql, new Object[]{BigDecimal.valueOf(Double.valueOf(payJe)),cs.getCourseId()});
					this.addCoursePayedJe(cs.getUserId(), cs.getCourseId(), payJe);
					return Result.success();
				}else{
					String msg = "付款状态修改失败";
					log.error(msg);
					return Result.failure(msg);
				}
			}
			String msg = "系统中未查到该学员选课信息";
			log.error(msg);
			return Result.failure(msg);
		}else{
			String msg = "学员选课编号或付款金额为空";
			log.error(msg);
			return Result.failure("参数校验失败",msg);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Result getMyCourse(String shId, String userOpenID) {
		if(userOpenID != null && !"".equals(userOpenID) && shId != null && !"".equals(shId)){
			String sql = "select ec.* from edu_course_student ec ,edu_student es where ec.STUDENT_ID=es.STUDENT_ID and es.WX_OPENID=? and ec.USER_ID=? and ec.IS_PAYED != '3' order by ec.EDIT_DATE desc";
			List<EduCourseStudent> ecs = eduCourseStudentService.getJdbcTemplate().query(sql, new Object[]{userOpenID, shId},new BeanPropertyRowMapper(EduCourseStudent.class));
			List<EduCourseStudentView> ecsvs = new ArrayList<EduCourseStudentView>();
			List<EduCourse> cs = shCourses.get(shId);
			if(cs == null) {
				sysnShCourses(shId);
				cs = shCourses.get(shId);
			}
			Map<String, EduCourse> cMap = new HashMap<String, EduCourse>();
			for(EduCourse ec:cs){
				cMap.put(ec.getCourseId(), ec);
			}
			for(EduCourseStudent es : ecs){
				EduCourseStudentView ecsv = new EduCourseStudentView();
				ecsv.setEduCourse(cMap.get(es.getCourseId()));
				ecsv.setEduCourseStudent(es);
				ecsvs.add(ecsv);
			}
			return Result.success(ecsvs);
		}else{
			String msg = "用户微信OPENID或商户ID为空";
			log.error(msg);
			return Result.failure("参数校验失败",msg);
		}
	}
	
	public boolean isBuyed(String shId, String userOpenID, String courseId) {
		boolean rs = false;
		EduStudent student = new EduStudent();
		student.setWxOpenid(userOpenID);
		List<EduStudent> students = eduStudentService.select(student);
		List<EduCourseStudent> ecs = new ArrayList<EduCourseStudent>();
		if(students != null && students.size() > 0){
			EduCourseStudent eCourseStudent = new EduCourseStudent();
			eCourseStudent.setUserId(shId);
			eCourseStudent.setStudentId(students.get(0).getStudentId());
			eCourseStudent.setIsPayed(1);
			eCourseStudent.setCourseId(courseId);
			ecs = eduCourseStudentService.select(eCourseStudent);
			if(ecs != null && ecs.size() > 0) rs = true;
		}
		return rs;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Result getMyCourseForTime(String shId, String userOpenID) {
		if(userOpenID != null && !"".equals(userOpenID) && shId != null && !"".equals(shId)){
			String sql = "select ec.* from edu_course_student ec ,edu_student es where ec.STUDENT_ID=es.STUDENT_ID and es.WX_OPENID=? and ec.USER_ID=? and ec.IS_PAYED='1' order by ec.PAY_DATE desc";
			List<EduCourseStudent> ecs = eduCourseStudentService.getJdbcTemplate().query(sql, new Object[]{userOpenID, shId},new BeanPropertyRowMapper(EduCourseStudent.class));
			List<EduCourseStudentView> ecsvs = new ArrayList<EduCourseStudentView>();
			List<EduCourse> cs = shCourses.get(shId);
			if(cs == null) {
				sysnShCourses(shId);
				cs = shCourses.get(shId);
			}
			Map<String, EduCourse> cMap = new HashMap<String, EduCourse>();
			for(EduCourse ec:cs){
				cMap.put(ec.getCourseId(), ec);
			}
			for(EduCourseStudent es : ecs){
				EduCourseStudentView ecsv = new EduCourseStudentView();
				ecsv.setEduCourse(cMap.get(es.getCourseId()));
				ecsv.setEduCourseStudent(es);
				ecsvs.add(ecsv);
			}
			return Result.success(ecsvs);
		}else{
			String msg = "用户微信OPENID或商户ID为空";
			log.error(msg);
			return Result.failure("参数校验失败",msg);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EduCourseStudent> findCourseStudent(String shId,
			String userOpenID, String courseId) {
		if(isWxManerger(shId, userOpenID).isSuccess()){			
			String sql = "select wup.AS_NAME as COURSE_NAME,wup.LOGO as common,ecs.COURSE_ID,ecs.COURSE_SID,ecs.EDIT_DATE,ecs.IS_PAYED,ecs.PAY_DATE,ecs.PAY_ID,ecs.PAY_JE,ecs.PAY_TYPE,es.WX_OPENID as STUDENT_ID,ecs.STUDENT_NAME,ecs.SUBJECT,ecs.SUBJECT_SUB,ecs.USER_ID from sijiao.edu_course_student ecs left join sijiao.edu_student es on ecs.STUDENT_ID=es.STUDENT_ID left join publicwx.wx_user_public wup on es.WX_OPENID=wup.WX_OPENID where ecs.COURSE_ID=? and ecs.USER_ID=? and ecs.IS_PAYED != '3' order by ecs.pay_date desc,ecs.edit_date desc";
			List<EduCourseStudent> ecs = eduCourseStudentService.getJdbcTemplate().query(sql, new Object[]{courseId, shId},new BeanPropertyRowMapper(EduCourseStudent.class));
			return ecs;
		}
		String msg = "非管理员操作";
		log.error(msg);
		return null;
	}

	public List<Map<String, Object>> findShCourseStudentTotal(String shId,
			String userOpenID, String year, String semester) {
		if(isWxManerger(shId, userOpenID).isSuccess()){			
			String sql = "select ec.year,ec.semester,count(ecs.course_id) order_students,sum(case ecs.pay_type when 1 then 1 else 0 end) wx_payed_students,sum(case ecs.pay_type when 2 then 1 else 0 end) xj_payed_students,sum(ecs.pay_je) payed_je,sum(case ecs.pay_type when 1 then ecs.pay_je else 0 end) wx_payed_je,sum(case ecs.pay_type when 2 then ecs.pay_je else 0 end) xj_payed_je from  edu_course_student ecs left join edu_course ec on ecs.course_id=ec.course_id where ecs.USER_ID=? and  ec.course_je>0 and ecs.is_payed != '3'";
			Object[] args = new Object[]{shId};
			if(year != null && !"".equals(year)){
				sql += " and ec.year='"+year+"'";
			}
			if(semester != null && !"".equals(semester) && !"0".equals(semester)){
				sql += " and ec.semester='"+semester+"'";
			}
			sql += " group by ec.year,ec.semester";
			List<Map<String, Object>> rs = eduCourseStudentService.getJdbcTemplate().queryForList(sql, args);
			if(rs == null) rs = new ArrayList<Map<String,Object>>();
			return rs;
		}
		String msg = "非管理员操作";
		log.error(msg);
		return null;
	}

	public Result getCourseSt(String shId,String courseSid) {
		EduCourseStudent eCourseStudent = new EduCourseStudent();
		eCourseStudent.setCourseSid(courseSid);
		eCourseStudent = eduCourseStudentService.selectOne(eCourseStudent);
		if(eCourseStudent != null){
			List<EduCourse> cs = shCourses.get(shId);
			if(cs == null) {
				sysnShCourses(shId);
				cs = shCourses.get(shId);
			}
			Map<String, EduCourse> cMap = new HashMap<String, EduCourse>();
			for(EduCourse ec:cs){
				cMap.put(ec.getCourseId(), ec);
			}
			EduCourseStudentView ecsv = new EduCourseStudentView();
			ecsv.setEduCourse(cMap.get(eCourseStudent.getCourseId()));
			ecsv.setEduCourseStudent(eCourseStudent);
			return Result.success(ecsv);
		}
		return Result.failure("未查到对应信息");
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Result prePay(String courseSid, @PathParam("payId") String payId) {
		String sql = "update edu_course_student e set e.is_payed='2',e.pay_id=?,e.pay_date=? where e.course_sid=? and (e.is_payed='0' or e.is_payed='2')";
		int rs = eduCourseStudentService.getJdbcTemplate().update(sql, new Object[]{payId,new Date(),courseSid});
		if(rs > 0 ){
			return Result.success();
		}else{
			EduCourseStudent eCourseStudent = new EduCourseStudent();
			eCourseStudent.setCourseSid(courseSid);
			eCourseStudent = eduCourseStudentService.selectOne(eCourseStudent);
			if(eCourseStudent != null){
				if(eCourseStudent.getIsPayed().equals(2)){					
					return Result.success();
				} else{			
					String msg = "您的课程课程已经失效或已经付款，请刷新您的课程";
					log.error(msg);
					return Result.failure(msg);
				}
			}else{	
				String msg = "您未添加该课程";
				log.error(msg);
				return Result.failure(msg);
			}
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void noPayhandler(Integer warnNum) {
		//检测未缴费的单，并判断可报人数是否为预警库数，是则置为已失效，已报名人数  -1
		EduCourseStudent ecs = new EduCourseStudent();
		ecs.setIsPayed(0);
		List<EduCourseStudent> ecses = eduCourseStudentService.select(ecs);
		for(EduCourseStudent ec:ecses){
			String shId = ec.getUserId();
			if(shCourses.get(shId) == null) this.sysnShCourses(shId);
			for(EduCourse eCourse:shCourses.get(shId)){
				if(eCourse.getCourseId().equals(ec.getCourseId())){
					if(eCourse.getMaxStudents() - eCourse.getPayStudents() < eCourse.getMaxStudents() * warnNum/10){
						String sql = "update edu_course_student ecs set ecs.IS_PAYED='3' where ecs.COURSE_SID=? and ecs.IS_PAYED='0' and ecs.EDIT_DATE<?";
						Date date = new Date(new Date().getTime() - 15*60*1000l);
						int rs = eduCourseStudentService.getJdbcTemplate().update(sql, new Object[]{ec.getCourseSid(),date});
						if(rs > 0){
							sql = "update edu_course ec set ec.PAY_STUDENTS=ec.PAY_STUDENTS - 1 where ec.COURSE_ID=? ";
							rs = eduCourseService.getJdbcTemplate().update(sql, new Object[]{ec.getCourseId()});
							this.updateCoursePaynum(shId, eCourse.getCourseId(), -1);
						}
					}
					break;
				}
			}
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void noPayHanderforDay(Integer offDay) {
		String sql = "select * from edu_course_student ecs where ecs.IS_PAYED='0' and ecs.EDIT_DATE<?";
		Date date = new Date(new Date().getTime() - offDay*12*60*60*1000l);
		List<Map<String, Object>> ecses = eduCourseStudentService.getJdbcTemplate().queryForList(sql, new Object[]{date});
		for(Map<String, Object> ecs:ecses){
			sql = "update edu_course_student ecs set ecs.IS_PAYED='3' where ecs.COURSE_SID=? and ecs.IS_PAYED='0' and ecs.EDIT_DATE<?";
			int rs = eduCourseStudentService.getJdbcTemplate().update(sql, new Object[]{ecs.get("COURSE_SID"),date});
			if(rs > 0){
				sql = "update edu_course ec set ec.PAY_STUDENTS=ec.PAY_STUDENTS - 1 where ec.COURSE_ID=? ";
				rs = eduCourseService.getJdbcTemplate().update(sql, new Object[]{ecs.get("COURSE_ID")});
				this.updateCoursePaynum((String)ecs.get("USER_ID"), (String)ecs.get("COURSE_ID"), -1);
			}
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void payingHanderforDay() {
		String sql = "select * from edu_course_student ecs where ecs.IS_PAYED='2' and ecs.EDIT_DATE<? and ecs.PAY_DATE<?";
		Date date = new Date(new Date().getTime() - delayDay*24*60*60*1000l);
		Date pdate = new Date(new Date().getTime() - delayPayMin*60*1000l);
		List<Map<String, Object>> ecses = eduCourseStudentService.getJdbcTemplate().queryForList(sql, new Object[]{date,pdate});
		for(Map<String, Object> ecs:ecses){
			sql = "update edu_course_student ecs set ecs.IS_PAYED='3' where ecs.COURSE_SID=? and ecs.IS_PAYED='2' and ecs.EDIT_DATE<? and ecs.PAY_DATE<?";
			int rs = eduCourseStudentService.getJdbcTemplate().update(sql, new Object[]{ecs.get("COURSE_SID"),date,pdate});
			if(rs > 0){
				sql = "update edu_course ec set ec.PAY_STUDENTS=ec.PAY_STUDENTS - 1 where ec.COURSE_ID=? ";
				rs = eduCourseService.getJdbcTemplate().update(sql, new Object[]{ecs.get("COURSE_ID")});
				this.updateCoursePaynum((String)ecs.get("USER_ID"), (String)ecs.get("COURSE_ID"), -1);
			}
		}
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional(propagation = Propagation.REQUIRED)
	public void payingHanderforHour() {
		String sql = "select * from edu_course_student ecs where ecs.IS_PAYED='2' and ecs.PAY_DATE<?";
		Date pdate = new Date(new Date().getTime() - 10*60*1000l);
		List<EduCourseStudent> ecses = eduCourseStudentService.getJdbcTemplate().query(sql, new Object[]{pdate},new BeanPropertyRowMapper(EduCourseStudent.class));
		for(EduCourseStudent ecs:ecses){
			WxPayConfig payConfig = publicwxService.payInfo(ecs.getUserId());
			try {
				boolean ispayed = WxPay.isPaySuccess(payConfig.getAppId(), payConfig.getMchId(), ecs.getPayId(), payConfig.getShKey());
				if(ispayed){
					List<EduCourse> cs = this.sysnShCourses(ecs.getUserId());
					if(cs != null){
						for(EduCourse ec:cs){
							if(ec.getCourseId().equals(ecs.getCourseId())){
								this.payOk(ecs.getCourseSid(), ec.getCourseJe()+"");
								break;
							}
						}
					}
				} 
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	@Transactional(propagation = Propagation.REQUIRED)
	public Result payXjOk(String courseSid) {
		if(courseSid != null && !"".equals(courseSid)){
			EduCourseStudent ecs = new EduCourseStudent();
			ecs.setCourseSid(courseSid);
			ecs = eduCourseStudentService.selectOne(ecs);
			if(ecs != null){
				List<EduCourse> cs = shCourses.get(ecs.getUserId());
				if(cs == null) {
					sysnShCourses(ecs.getUserId());
					cs = shCourses.get(ecs.getUserId());
				}
				EduCourse teCourse = null;
				if(cs != null){
					for(EduCourse ec:cs){
						if(ec.getCourseId().equals(ecs.getCourseId())){
							teCourse = ec;
							break;
						}
					}
				}
				if(teCourse == null) Result.failure("系统中未查到有发布该课程信息");
				String sql = "update edu_course_student e set e.is_payed='1',e.pay_type='2',e.pay_date=?,e.pay_je=? where e.course_sid=? and (e.is_payed='2' or e.is_payed='0')";
				int rs = eduCourseStudentService.getJdbcTemplate().update(sql, new Object[]{new Date(),teCourse.getCourseJe(),courseSid});
				if(rs > 0 ){
					sql = "update edu_course e set e.payed_students=e.payed_students+1,e.payed_je=e.payed_je+? where e.course_id=?";
					eduCourseStudentService.getJdbcTemplate().update(sql, new Object[]{teCourse.getCourseJe(),teCourse.getCourseId()});
					this.addCoursePayedJe(teCourse.getUserId(), teCourse.getCourseId(), teCourse.getCourseJe()+"");
					return Result.success();
				}else{
					String msg = "付款状态修改失败";
					log.error(msg);
					return Result.failure(msg);
				}
			}
			String msg = "系统中未查到该学员选课信息";
			log.error(msg);
			return Result.failure(msg);
		}else{
			String msg = "学员选课编号或付款金额为空";
			log.error(msg);
			return Result.failure("参数校验失败",msg);
		}
	}
public static void main(String[] args) {
	System.out.println(UUID.randomUUID().toString());
}
}
