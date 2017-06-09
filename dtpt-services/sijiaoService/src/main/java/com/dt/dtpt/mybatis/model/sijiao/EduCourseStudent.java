package com.dt.dtpt.mybatis.model.sijiao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "edu_course_student")
public class EduCourseStudent implements Serializable {
    /**
     * 选课编号
     */
	@Id
    @Column(name = "COURSE_SID")
    private String courseSid;

    /**
     * 课程编号
     */
    @Column(name = "COURSE_ID")
    private String courseId;

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
     * 科目小类(1软笔2硬笔)
     */
    @Column(name = "SUBJECT_SUB")
    private String subjectSub;

    /**
     * 学员编号
     */
    @Column(name = "STUDENT_ID")
    private String studentId;

    /**
     * 学员姓名
     */
    @Column(name = "STUDENT_NAME")
    private String studentName;

    /**
     * 是否缴费(0未缴费1已缴费)
     */
    @Column(name = "IS_PAYED")
    private Integer isPayed;

    /**
     * 缴费时间
     */
    @Column(name = "PAY_DATE")
    private Date payDate;

    /**
     * 缴费金额
     */
    @Column(name = "PAY_JE")
    private BigDecimal payJe;

    /**
     * 所属商户
     */
    @Column(name = "USER_ID")
    private String userId;

    /**
     * 编辑时间
     */
    @Column(name = "EDIT_DATE")
    private Date editDate;

    /**
     * 备注
     */
    @Column(name = "COMMON")
    private String common;

    /**
     * 支付方式：1微信支付
     */
    @Column(name = "PAY_TYPE")
    private Integer payType;
    
    /**
     * 第三方支付订单号
     */
    @Column(name = "PAY_ID")
    private String payId;
    
    private static final long serialVersionUID = 1L;

    /**
     * 获取选课编号
     *
     * @return COURSE_SID - 选课编号
     */
    public String getCourseSid() {
        return courseSid;
    }

    /**
     * 设置选课编号
     *
     * @param courseSid 选课编号
     */
    public void setCourseSid(String courseSid) {
        this.courseSid = courseSid;
    }

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
     * 获取科目小类(1软笔2硬笔)
     *
     * @return SUBJECT_SUB - 科目小类(1软笔2硬笔)
     */
    public String getSubjectSub() {
        return subjectSub;
    }

    /**
     * 设置科目小类(1软笔2硬笔)
     *
     * @param subjectSub 科目小类(1软笔2硬笔)
     */
    public void setSubjectSub(String subjectSub) {
        this.subjectSub = subjectSub;
    }

    /**
     * 获取学员编号
     *
     * @return STUDENT_ID - 学员编号
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * 设置学员编号
     *
     * @param studentId 学员编号
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * 获取学员姓名
     *
     * @return STUDENT_NAME - 学员姓名
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * 设置学员姓名
     *
     * @param studentName 学员姓名
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * 获取是否缴费(0未缴费1已缴费)
     *
     * @return IS_PAYED - 是否缴费(0未缴费1已缴费)
     */
    public Integer getIsPayed() {
        return isPayed;
    }

    /**
     * 设置是否缴费(0未缴费1已缴费)
     *
     * @param isPayed 是否缴费(0未缴费1已缴费)
     */
    public void setIsPayed(Integer isPayed) {
        this.isPayed = isPayed;
    }

    /**
     * 获取缴费时间
     *
     * @return PAY_DATE - 缴费时间
     */
    public Date getPayDate() {
        return payDate;
    }

    /**
     * 设置缴费时间
     *
     * @param payDate 缴费时间
     */
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    /**
     * 获取缴费金额
     *
     * @return PAY_JE - 缴费金额
     */
    public BigDecimal getPayJe() {
        return payJe;
    }

    /**
     * 设置缴费金额
     *
     * @param payJe 缴费金额
     */
    public void setPayJe(BigDecimal payJe) {
        this.payJe = payJe;
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

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public String getPayId() {
		return payId;
	}

	public void setPayId(String payId) {
		this.payId = payId;
	}
    
}