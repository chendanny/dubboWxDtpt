package com.dt.dtpt.service.sijiao;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dt.dtpt.mybatis.model.sijiao.EduCourse;
import com.dt.dtpt.mybatis.model.sijiao.EduCourseStudent;
import com.dt.dtpt.mybatis.model.sijiao.EduStudent;
import com.dt.dtpt.util.Result;
/**
 * 当前生产服务器IP:120.76.152.25
 * 当前生产服务器端口(PORT):8889
 * 当前测试服务器IP:120.76.152.25
 * 当前测试服务器端口(PORT):7889
 * @author Administrator
 *-encoding UTF-8 -charset UTF-8
 */
@Service
@Path("/sijiao")
@Consumes({"application/json; charset=UTF-8", "text/xml; charset=UTF-8"})
@Produces({"application/json; charset=UTF-8", "text/xml; charset=UTF-8"})
public interface SijiaoService {
	
	public static final int delayDay = 1;
	public static final int delayPayMin = 30;
	//==================== WX interface ==================
	/**
	 * 是否为管理员
	 * <br/>runAdress:http://{IP}:{PORT}/services/sijiao/isWxManerger/{shId}/{userOpenID}
	 * <br/>example:{@link http://120.76.152.25:7889/services/sijiao/isWxManerger/9055be7a45a5425da1c44b2e2126411a/oPIfIs_f0BBZJrvQBScbgXpI-8Wg}
	 * @param shId 管理员用户编号，不能为空
	 * @param userOpenID 当前操作用户微信OPENID，不能为空
	 * @return 是返回对象的success属性为true，否则为false
	 */
	@GET
	@Path("/isWxManerger/{shId}/{userOpenID}")
	public Result isWxManerger(@PathParam("shId") String shId, @PathParam("userOpenID") String userOpenID);
	/**
	 * 用户获取课程列表
	 * <br/>runAdress:http://{IP}:{PORT}/services/sijiao/findWxCourses/{shId}/{pageNumber}/{pageSize}
	 * <br/>example:{@link http://120.76.152.25:7889/services/sijiao/findWxCourses/9055be7a45a5425da1c44b2e2126411a/1/15}
	 * @param shId 管理员用户编号，不能为空
	 * @param eduCourse 精准匹配的课程条件对象
	 * @param pageNumber 页码，不能为空
	 * @param pageSize 每页数据行数，不能为空
	 * @return 返回对象的success为true时，result属性为List<EduCourse>
	 */
	@POST
	@Path("/findWxCourses/{shId}/{pageNumber}/{pageSize}")
	public Result findWxCourses(@PathParam("shId") String shId, EduCourse eduCourse,
			@PathParam("pageNumber") int pageNumber, @PathParam("pageSize") int pageSize);
	/**
	 * 新增课程
	 * <br/>runAdress:http://{IP}:{PORT}/services/sijiao/addCourseByAdmin/{shId}/{userOpenID},post对象：EduCourse
	 * <br/>example:{@link http://120.76.152.25:7889/services/sijiao/addCourseByAdmin/9055be7a45a5425da1c44b2e2126411a/oPIfIs_f0BBZJrvQBScbgXpI-8Wg},postData:{...}
	 * @param shId 管理员用户编号，不能为空
	 * @param userOpenID 当前操作用户微信OPENID，不能为空
	 * @param course 需要添加的课程信息：课程名称、课程类型、老师姓名、学年、学期、开始日期、结束日期、上课时间、上课地点、节数、限制人数、课程内容
	 * @return 返回对象的success属性为true是，操作成功；否则操作失败
	 */
	@POST
	@Path("/addCourseByAdmin/{shId}/{userOpenID}")
	@Transactional(propagation = Propagation.REQUIRED)
	public Result addCourseByAdmin(@PathParam("shId") String shId, @PathParam("userOpenID") String userOpenID, EduCourse course);
	/**
	 * 获取用户下已添加学员
	 * <br/>runAdress:http://{IP}:{PORT}/services/sijiao/findEduStudents/{userOpenID}
	 * <br/>example:{@link http://120.76.152.25:7889/services/sijiao/findEduStudents/oPIfIs_f0BBZJrvQBScbgXpI-8Wg}
	 * @param userOpenID 当前操作用户微信OPENID，不能为空
	 * @return 返回对象的success属性为true时，result属性为List<EduStudent>
	 */
	@GET
	@Path("/findEduStudents/{userOpenID}")
	public Result findEduStudents(@PathParam("userOpenID") String userOpenID);
	
	/**
	 * 添加学员
	 * <br/>runAdress:http://{IP}:{PORT}/services/sijiao/addStudentByWx/{shId}/{userOpenID},post对象：EduStudent
	 * <br/>example:{@link http://120.76.152.25:7889/services/sijiao/addStudentByWx/9055be7a45a5425da1c44b2e2126411a/oPIfIs_f0BBZJrvQBScbgXpI-8Wg},postData:{...}
	 * @param shId 管理员用户编号，不能为空
	 * @param userOpenID 当前操作用户微信OPENID，不能为空
	 * @param eduStudent 需要添加的学员信息：姓名、手机、住址、出生年月、性别、学年级
	 * @return 返回对象的success属性值为true时，添加成功，result值为EduStudent对象；否则添加失败
	 */
	@POST
	@Path("/addStudentByWx/{shId}/{userOpenID}")
	@Transactional(propagation = Propagation.REQUIRED)
	public Result addStudentByWx(@PathParam("shId") String shId,@PathParam("userOpenID") String userOpenID, EduStudent eduStudent);
	/**
	 * 学员添加课程
	 * <br/>runAdress:http://{IP}:{PORT}/services/sijiao/addCourseByWx/{userOpenID}/{courseId}
	 * <br/>example:{@link http://120.76.152.25:7889/services/sijiao/addCourseByWx/oPIfIs_f0BBZJrvQBScbgXpI-8Wg/d3130f2658b24d47a6fd802f454dc7fd}
	 * @param userOpenID 当前操作用户微信OPENID，不能为空
	 * @param courseId 需要添加的课程编号，不能为空
	 * @return 返回对象的success属性值为true时，添加成功,result值为courseSid(学员选课编号)；否则添加失败
	 */
	@POST
	@Path("/addCourseByWx/{userOpenID}/{courseId}")
	@Transactional(propagation = Propagation.REQUIRED)
	public Result addCourseByWx(@PathParam("userOpenID") String userOpenID, @PathParam("courseId") String courseId);
	/**
	 * 预付款确认课程详细信息
	 * <br/>runAdress:http://{IP}:{PORT}/services/sijiao/getCourse/{courseId}
	 * <br/>example:{@link http://120.76.152.25:7889/services/sijiao/getCourse/d3130f2658b24d47a6fd802f454dc7fd}
	 * @param courseId 课程编号，不能为空
	 * @return 返回对象的success属性值为true时，result属性为EduCourse
	 */
	@GET
	@Path("/getCourse/{courseId}")
	public Result getCourse(@PathParam("courseId") String courseId);
	/**
	 * 预付款确认学员信息
	 * <br/>runAdress:http://{IP}:{PORT}/services/sijiao/getStudent/{studentId}
	 * <br/>example:{@link http://120.76.152.25:7889/services/sijiao/getStudent/76f9d6589f6e4f2a8468f8571bf1745e}
	 * @param studentId 学员编号，不能为空
	 * @return 返回对象的success属性值为true时，result属性为EduStudent
	 */
	@GET
	@Path("/getStudent/{studentId}")
	public Result getStudent(@PathParam("studentId") String studentId);
	/**
	 * 课程付款完成
	 * <br/>runAdress:http://{IP}:{PORT}/services/sijiao/payOk/{courseSid}
	 * <br/>example:{@link http://120.76.152.25:7889/services/sijiao/payOk/6bdeb6b269fc4827a9048740a27f4681}
	 * @param courseSid 学员选课编号(订单编号)，不能为空
	 * @param payJe 实际付款金额
	 * @return 返回对象的success属性值为true时，操作成功；否则操作失败
	 */
	@POST
	@Path("/payOk/{courseSid}")
	@Transactional(propagation = Propagation.REQUIRED)
	public Result payOk(@PathParam("courseSid") String courseSid,String payJe);
	
	/**
	 * 获取我已添加的课程
	 * <br/>runAdress:http://{IP}:{PORT}/services/sijiao/getMyCourse/{shId}/{userOpenID}
	 * <br/>example:{@link http://120.76.152.25:7889/services/sijiao/getMyCourse/9055be7a45a5425da1c44b2e2126411a/oPIfIs_f0BBZJrvQBScbgXpI-8Wg}
	 * @param shId 管理员用户编号，不能为空
	 * @param userOpenID 当前操作用户微信OPENID，不能为空
	 * @return 返回对象的success属性值为true时，result属性为List<com.dt.dtpt.vo.EduCourseStudentView>
	 */
	@GET
	@Path("/getMyCourse/{shId}/{userOpenID}")
	public Result getMyCourse(@PathParam("shId") String shId,@PathParam("userOpenID") String userOpenID);
	/**
	 * 获取我已缴费的课程，学习历程接口
	 * <br/>runAdress:http://{IP}:{PORT}/services/sijiao/getMyCourseForTime/{shId}/{userOpenID}
	 * <br/>example:{@link http://120.76.152.25:7889/services/sijiao/getMyCourseForTime/9055be7a45a5425da1c44b2e2126411a/oPIfIs_f0BBZJrvQBScbgXpI-8Wg}
	 * @param shId 管理员用户编号，不能为空
	 * @param userOpenID 当前操作用户微信OPENID，不能为空
	 * @return 返回对象的success属性值为true时，result属性为List<com.dt.dtpt.vo.EduCourseStudentView>
	 */
	@GET
	@Path("/getMyCourseForTime/{shId}/{userOpenID}")
	public Result getMyCourseForTime(@PathParam("shId") String shId,@PathParam("userOpenID") String userOpenID);
	
	/**
	 * 判断用户是否已经购买过指定课程
	 * <br/>runAdress:http://{IP}:{PORT}/services/sijiao/isBuyed/{shId}/{userOpenID}/{courseId}
	 * <br/>example:{@link http://120.76.152.25:7889/services/sijiao/isBuyed/9055be7a45a5425da1c44b2e2126411a/oPIfIs_f0BBZJrvQBScbgXpI-8Wg/d3130f2658b24d47a6fd802f454dc7fd}
	 * @param shId 管理员用户编号，不能为空
	 * @param userOpenID 当前操作用户微信OPENID，不能为空
	 * @param courseId 课程编号，不能为空
	 * @return
	 */
	@GET
	@Path("/isBuyed/{shId}/{userOpenID}/{courseId}")
	public boolean isBuyed(@PathParam("shId") String shId,@PathParam("userOpenID") String userOpenID,@PathParam("courseId") String courseId);
	
	/**
	 * 根据已添加课程编号获取已添加课程信息
	 * <br/>runAdress:http://{IP}:{PORT}/services/sijiao/getCourseSt/{shId}/{courseSid}
	 * <br/>example:{@link http://120.76.152.25:7889/services/sijiao/getCourseSt/9055be7a45a5425da1c44b2e2126411a/6bdeb6b269fc4827a9048740a27f4681}
	 * @param courseSid 学员选课编号(订单编号)，不能为空
	 * @return 返回对象的success属性值为true时，result属性为com.dt.dtpt.vo.EduCourseStudentView
	 */
	@GET
	@Path("/getCourseSt/{shId}/{courseSid}")
	public Result getCourseSt(@PathParam("shId") String shId,@PathParam("courseSid") String courseSid);
	
	/**
	 * 判断是否可以付款，并置为订单状态为付款中
	 * <br/>runAdress:http://{IP}:{PORT}/services/sijiao/prePay/{courseSid}/{payId}
	 * <br/>example:{@link http://120.76.152.25:7889/services/sijiao/prePay/6bdeb6b269fc4827a9048740a27f4681/6bdeb6b2698c4827a9048740a27f4681}
	 * @param courseSid 学员选课编号(订单编号)，不能为空
	 * @param payId 第三方支付订单号
	 * @return 返回对象的success属性值为true时，可以付款；否则订单就是失效了，需要重新下单
	 */
	@GET
	@Path("/prePay/{courseSid}/{payId}")
	@Transactional(propagation = Propagation.REQUIRED)
	public Result prePay(@PathParam("courseSid") String courseSid, @PathParam("payId") String payId);
	
	/**
	 * 检测未缴费的单，并判断可报人数是否为预警成数，是则置为已失效，已报名人数  -1,面向任务
	 * 假如最多可报20人，预警成数为 2/10，即预警数为4，此处该传参数2
	 * <br/>runAdress:http://{IP}:{PORT}/services/sijiao/noPayhandler/{warnNum}
	 * <br/>example:{@link http://120.76.152.25:7889/services/sijiao/noPayhandler/2}
	 */
	@GET
	@Path("/noPayhandler/{warnNum}")
	@Transactional(propagation = Propagation.REQUIRED)
	public void noPayhandler(@PathParam("warnNum") @DefaultValue("2") Integer warnNum);
	
	/**
	 * 未缴费超出指定天数的课程，置为失效，默认值为1天,面向任务
	 * <br/>runAdress:http://{IP}:{PORT}/services/sijiao/noPayHanderforDay/{offDay}
	 * <br/>example:{@link http://120.76.152.25:7889/services/sijiao/noPayHanderforDay/1}
	 * @param offDay
	 */
	@GET
	@Path("/noPayHanderforDay/{offDay}")
	@Transactional(propagation = Propagation.REQUIRED)
	public void noPayHanderforDay(@PathParam("offDay") @DefaultValue("1") Integer offDay);
	
	/**
	 * 下单超出指定天数，同时缴费中已超出指定分钟数的课程，置为失效，下单超时默认为1天，支付超时默认为30分钟,面向任务
	 * <br/>runAdress:http://{IP}:{PORT}/services/sijiao/payingHanderforDay
	 * <br/>example:{@link http://120.76.152.25:7889/services/sijiao/payingHanderforDay}
	 * @param offDay
	 */
	@GET
	@Path("/payingHanderforDay")
	@Transactional(propagation = Propagation.REQUIRED)
	public void payingHanderforDay();
	
	/**
	 * 下单一天时间内，同时缴费中已超出30分钟的课程，去调用接口检验是否已经支付成功,面向任务
	 * <br/>runAdress:http://{IP}:{PORT}/services/sijiao/payingHanderforHour
	 * <br/>example:{@link http://120.76.152.25:7889/services/sijiao/payingHanderforHour}
	 * @param offDay
	 */
	@GET
	@Path("/payingHanderforHour")
	@Transactional(propagation = Propagation.REQUIRED)
	public void payingHanderforHour();
	
	
	/**
	 * 管理员通过公众号查看各课程的购买情况:列表显示每班的学员名称及缴费时间
	 * <br/>runAdress:http://{IP}:{PORT}/services/sijiao/findCourseStudent/{shId}/{userOpenID}/{courseId}
	 * <br/>example:{@link http://120.76.152.25:7889/services/sijiao/findCourseStudent/9055be7a45a5425da1c44b2e2126411a/oPIfIs_f0BBZJrvQBScbgXpI-8Wg/d3130f2658b24d47a6fd802f454dc7fd}
	 * @param shId 商户编号
	 * @param userOpenID 用户微信公众号，用来判断是否为管理员
	 * @param courseId 课程编号
	 * @return 如果userOpenId非管理员openID，则返回null，否则返回该商户下该课程对应已缴费的学员对象集合
	 */
	@GET
	@Path("/findCourseStudent/{shId}/{userOpenID}/{courseId}")
	public List<EduCourseStudent> findCourseStudent(@PathParam("shId") String shId,@PathParam("userOpenID") String userOpenID,@PathParam("courseId") String courseId);
	
	/**
	 * 管理员通过公众号查看对应季节所有课程报名及购买总体情况
	 * <br/>runAdress:http://{IP}:{PORT}/services/sijiao/findShCourseStudentTotal/{shId}/{userOpenID}/{year}/{semester}
	 * <br/>example:{@link http://120.76.152.25:7889/services/sijiao/findShCourseStudentTotal/9055be7a45a5425da1c44b2e2126411a/oPIfIs_f0BBZJrvQBScbgXpI-8Wg/2016/2}
	 * @param shId 商户编号
	 * @param userOpenID 用户微信公众号，用来判断是否为管理员
	 * @param year 指定年份,比如2016
	 * @param semester 指定季节,(0所有季节1春季2夏季3秋季4冬季)
	 * @return 如果userOpenId非管理员openID，则返回null，否则返回该商户下对应季节所有课程报名及购买总体情况MAP集合，map中键名描述：
	 * <br/>year(年份)、semester(季节)、order_students(报名人数)、wx_payed_students(微信支付人数)、xj_payed_students(现金支付人数)、payed_je(总付款金额)、wx_payed_je(微信总付款金额)、xj_payed_je(现金总付款金额)
	 */
	@GET
	@Path("/findShCourseStudentTotal/{shId}/{userOpenID}/{year}/{semester}")
	public List<Map<String, Object>> findShCourseStudentTotal(@PathParam("shId") String shId,@PathParam("userOpenID") String userOpenID,@PathParam("year") String year,@PathParam("semester") String semester);
	
	/**
	 * 现金付款完成
	 * <br/>runAdress:http://{IP}:{PORT}/services/sijiao/payXjOk/{courseSid}
	 * <br/>example:{@link http://120.76.152.25:7889/services/sijiao/payXjOk/6bdeb6b269fc4827a9048740a27f4681}
	 * @param courseSid 学员选课编号(订单编号)，不能为空
	 * @return 返回对象的success属性值为true时，操作成功；否则操作失败
	 */
	@GET
	@Path("/payXjOk/{courseSid}")
	@Transactional(propagation = Propagation.REQUIRED)
	public Result payXjOk(@PathParam("courseSid") String courseSid);
	//==================== WX interface ==================
}
