package com.dt.dtpt.mybatis.model.sijiao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

@Table(name = "edu_active_student")
public class EduActiveStudent implements Serializable {
    /**
     * 编号
     */
	@Id
    @Column(name = "STUDENT_ACT_ID")
    private String studentActId;

    /**
     * 活动编号
     */
    @Column(name = "ACTIVE_ID")
    private String activeId;

    /**
     * 活动主题
     */
    @Column(name = "ACTIVE_TITLE")
    private String activeTitle;

    /**
     * 活动大类
     */
    @Column(name = "ACTIVE_SUBJECT")
    private String activeSubject;

    /**
     * 活动小类
     */
    @Column(name = "ACTIVE_SUBJECT_SUB")
    private String activeSubjectSub;

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

    private static final long serialVersionUID = 1L;

    /**
     * 获取编号
     *
     * @return STUDENT_ACT_ID - 编号
     */
    public String getStudentActId() {
        return studentActId;
    }

    /**
     * 设置编号
     *
     * @param studentActId 编号
     */
    public void setStudentActId(String studentActId) {
        this.studentActId = studentActId;
    }

    /**
     * 获取活动编号
     *
     * @return ACTIVE_ID - 活动编号
     */
    public String getActiveId() {
        return activeId;
    }

    /**
     * 设置活动编号
     *
     * @param activeId 活动编号
     */
    public void setActiveId(String activeId) {
        this.activeId = activeId;
    }

    /**
     * 获取活动主题
     *
     * @return ACTIVE_TITLE - 活动主题
     */
    public String getActiveTitle() {
        return activeTitle;
    }

    /**
     * 设置活动主题
     *
     * @param activeTitle 活动主题
     */
    public void setActiveTitle(String activeTitle) {
        this.activeTitle = activeTitle;
    }

    /**
     * 获取活动大类
     *
     * @return ACTIVE_SUBJECT - 活动大类
     */
    public String getActiveSubject() {
        return activeSubject;
    }

    /**
     * 设置活动大类
     *
     * @param activeSubject 活动大类
     */
    public void setActiveSubject(String activeSubject) {
        this.activeSubject = activeSubject;
    }

    /**
     * 获取活动小类
     *
     * @return ACTIVE_SUBJECT_SUB - 活动小类
     */
    public String getActiveSubjectSub() {
        return activeSubjectSub;
    }

    /**
     * 设置活动小类
     *
     * @param activeSubjectSub 活动小类
     */
    public void setActiveSubjectSub(String activeSubjectSub) {
        this.activeSubjectSub = activeSubjectSub;
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
}