package com.dt.dtpt.mybatis.model.sijiao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

@Table(name = "edu_course")
public class EduCourse implements Serializable {
    /**
     * 课程编号
     */
	@Id
    @Column(name = "COURSE_ID")
    private String courseId;

    /**
     * 学校编号
     */
    @Column(name = "SCHOOL_ID")
    private String schoolId;

    /**
     * 课程名称
     */
    @Column(name = "COURSE_NAME")
    private String courseName;

    /**
     * 课程科目(1书法)
     */
    @Column(name = "SUBJECT")
    private String subject;

    /**
     * 课程科目小类(1软笔2硬笔)
     */
    @Column(name = "SUBJECT_SUB")
    private String subjectSub;

    /**
     * 学年
     */
    @Column(name = "YEAR")
    private String year;

    /**
     * 学期
     */
    @Column(name = "SEMESTER")
    private Integer semester;

    /**
     * 开班时间
     */
    @Column(name = "START_DATE")
    private Date startDate;

    /**
     * 结束时间
     */
    @Column(name = "END_DATE")
    private Date endDate;

    /**
     * 老师编号
     */
    @Column(name = "TEACHER_ID")
    private String teacherId;

    /**
     * 老师姓名
     */
    @Column(name = "TEACHER_NAME")
    private String teacherName;

    /**
     * 老师电话
     */
    @Column(name = "TEACHER_PHONE")
    private String teacherPhone;

    /**
     * 总节数
     */
    @Column(name = "TOTAL_COURSE")
    private Integer totalCourse;

    /**
     * 上课时间
     */
    @Column(name = "TEACH_TIME")
    private String teachTime;

    /**
     * 上课地点
     */
    @Column(name = "TEACH_ADDRESS")
    private String teachAddress;

    /**
     * 学习内容
     */
    @Column(name = "COURSE_INFO")
    private String courseInfo;

    /**
     * 满额人数
     */
    @Column(name = "MAX_STUDENTS")
    private Integer maxStudents;

    /**
     * 已报名人数
     */
    @Column(name = "PAY_STUDENTS")
    private Integer payStudents;
    
    /**
     * 已缴费人数
     */
    @Column(name = "PAYED_STUDENTS")
    private Integer payedStudents;

    /**
     * 已缴费金额
     */
    @Column(name = "PAYED_JE")
    private BigDecimal payedJe;
    
    /**
     * 课程价格
     */
    @Column(name = "COURSE_JE")
    private BigDecimal courseJe;

    /**
     * 编辑时间
     */
    @Column(name = "EDIT_DATE")
    private Date editDate;

    /**
     * 所属商户
     */
    @Column(name = "USER_ID")
    private String userId;

    /**
     * 备注
     */
    @Column(name = "COMMON")
    private String common;

    private static final long serialVersionUID = 1L;

    /**
     * 获取课程编号
     *
     * @return COURSE_ID - 课程编号
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * 设置课程编号
     *
     * @param courseId 课程编号
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * 获取学校编号
     *
     * @return SCHOOL_ID - 学校编号
     */
    public String getSchoolId() {
        return schoolId;
    }

    /**
     * 设置学校编号
     *
     * @param schoolId 学校编号
     */
    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    /**
     * 获取课程名称
     *
     * @return COURSE_NAME - 课程名称
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * 设置课程名称
     *
     * @param courseName 课程名称
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * 获取课程科目(1书法)
     *
     * @return SUBJECT - 课程科目(1书法)
     */
    public String getSubject() {
        return subject;
    }

    /**
     * 设置课程科目(1书法)
     *
     * @param subject 课程科目(1书法)
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * 获取课程科目小类(1软笔2硬笔)
     *
     * @return SUBJECT_SUB - 课程科目小类(1软笔2硬笔)
     */
    public String getSubjectSub() {
        return subjectSub;
    }

    /**
     * 设置课程科目小类(1软笔2硬笔)
     *
     * @param subjectSub 课程科目小类(1软笔2硬笔)
     */
    public void setSubjectSub(String subjectSub) {
        this.subjectSub = subjectSub;
    }

    /**
     * 获取学年
     *
     * @return YEAR - 学年
     */
    public String getYear() {
        return year;
    }

    /**
     * 设置学年
     *
     * @param year 学年
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * 获取学期
     *
     * @return SEMESTER - 学期
     */
    public Integer getSemester() {
        return semester;
    }

    /**
     * 设置学期
     *
     * @param semester 学期
     */
    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    /**
     * 获取开班时间
     *
     * @return START_DATE - 开班时间
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 设置开班时间
     *
     * @param startDate 开班时间
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取结束时间
     *
     * @return END_DATE - 结束时间
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置结束时间
     *
     * @param endDate 结束时间
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取老师编号
     *
     * @return TEACHER_ID - 老师编号
     */
    public String getTeacherId() {
        return teacherId;
    }

    /**
     * 设置老师编号
     *
     * @param teacherId 老师编号
     */
    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * 获取老师姓名
     *
     * @return TEACHER_NAME - 老师姓名
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * 设置老师姓名
     *
     * @param teacherName 老师姓名
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    /**
     * 获取老师电话
     *
     * @return TEACHER_PHONE - 老师电话
     */
    public String getTeacherPhone() {
        return teacherPhone;
    }

    /**
     * 设置老师电话
     *
     * @param teacherPhone 老师电话
     */
    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    /**
     * 获取总节数
     *
     * @return TOTAL_COURSE - 总节数
     */
    public Integer getTotalCourse() {
        return totalCourse;
    }

    /**
     * 设置总节数
     *
     * @param totalCourse 总节数
     */
    public void setTotalCourse(Integer totalCourse) {
        this.totalCourse = totalCourse;
    }

    /**
     * 获取上课时间
     *
     * @return TEACH_TIME - 上课时间
     */
    public String getTeachTime() {
        return teachTime;
    }

    /**
     * 设置上课时间
     *
     * @param teachTime 上课时间
     */
    public void setTeachTime(String teachTime) {
        this.teachTime = teachTime;
    }

    /**
     * 获取上课地点
     *
     * @return TEACH_ADDRESS - 上课地点
     */
    public String getTeachAddress() {
        return teachAddress;
    }

    /**
     * 设置上课地点
     *
     * @param teachAddress 上课地点
     */
    public void setTeachAddress(String teachAddress) {
        this.teachAddress = teachAddress;
    }

    /**
     * 获取学习内容
     *
     * @return COURSE_INFO - 学习内容
     */
    public String getCourseInfo() {
        return courseInfo;
    }

    /**
     * 设置学习内容
     *
     * @param courseInfo 学习内容
     */
    public void setCourseInfo(String courseInfo) {
        this.courseInfo = courseInfo;
    }

    /**
     * 获取满额人数
     *
     * @return MAX_STUDENTS - 满额人数
     */
    public Integer getMaxStudents() {
        return maxStudents;
    }

    /**
     * 设置满额人数
     *
     * @param maxStudents 满额人数
     */
    public void setMaxStudents(Integer maxStudents) {
        this.maxStudents = maxStudents;
    }

    /**
     * 获取已报名人数
     *
     * @return PAY_STUDENTS - 已报名人数
     */
    public Integer getPayStudents() {
        return payStudents;
    }

    /**
     * 设置已报名人数
     *
     * @param payStudents 已报名人数
     */
    public void setPayStudents(Integer payStudents) {
        this.payStudents = payStudents;
    }

    public Integer getPayedStudents() {
		return payedStudents;
	}

	public void setPayedStudents(Integer payedStudents) {
		this.payedStudents = payedStudents;
	}

	public BigDecimal getPayedJe() {
		return payedJe;
	}

	public void setPayedJe(BigDecimal payedJe) {
		this.payedJe = payedJe;
	}

	/**
     * 获取课程价格
     *
     * @return COURSE_JE - 课程价格
     */
    public BigDecimal getCourseJe() {
        return courseJe;
    }

    /**
     * 设置课程价格
     *
     * @param courseJe 课程价格
     */
    public void setCourseJe(BigDecimal courseJe) {
        this.courseJe = courseJe;
    }

    /**
     * 获取编辑时间
     *
     * @return EDIT_DATE - 编辑时间
     */
    public Date getEditDate() {
        return editDate;
    }

    /**
     * 设置编辑时间
     *
     * @param editDate 编辑时间
     */
    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    /**
     * 获取所属商户
     *
     * @return USER_ID - 所属商户
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置所属商户
     *
     * @param userId 所属商户
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取备注
     *
     * @return COMMON - 备注
     */
    public String getCommon() {
        return common;
    }

    /**
     * 设置备注
     *
     * @param common 备注
     */
    public void setCommon(String common) {
        this.common = common;
    }
}