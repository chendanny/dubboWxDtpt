package com.dt.dtpt.mybatis.model.sijiao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Table(name = "edu_teacher")
public class EduTeacher implements Serializable {
    /**
     * 教师编号
     */
	@Id
    @Column(name = "TEACHER_ID")
    private String teacherId;

    /**
     * 学校编号
     */
    @Column(name = "SCHOOL_ID")
    private String schoolId;

    /**
     * 教师姓名
     */
    @Column(name = "TEACHER_NAME")
    private String teacherName;

    /**
     * 性别(0女1男)
     */
    @Column(name = "SEX")
    private Integer sex;

    /**
     * 年龄
     */
    @Column(name = "AGE")
    private Integer age;

    /**
     * 电话
     */
    @Column(name = "PHONE")
    private String phone;

    /**
     * 称号
     */
    @Column(name = "TEACHER_GRADE")
    private String teacherGrade;

    /**
     * 简介
     */
    @Column(name = "TEACHER_INFO")
    private String teacherInfo;

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
     * 获取教师编号
     *
     * @return TEACHER_ID - 教师编号
     */
    public String getTeacherId() {
        return teacherId;
    }

    /**
     * 设置教师编号
     *
     * @param teacherId 教师编号
     */
    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
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
     * 获取教师姓名
     *
     * @return TEACHER_NAME - 教师姓名
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * 设置教师姓名
     *
     * @param teacherName 教师姓名
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    /**
     * 获取性别(0女1男)
     *
     * @return SEX - 性别(0女1男)
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别(0女1男)
     *
     * @param sex 性别(0女1男)
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取年龄
     *
     * @return AGE - 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取电话
     *
     * @return PHONE - 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取称号
     *
     * @return TEACHER_GRADE - 称号
     */
    public String getTeacherGrade() {
        return teacherGrade;
    }

    /**
     * 设置称号
     *
     * @param teacherGrade 称号
     */
    public void setTeacherGrade(String teacherGrade) {
        this.teacherGrade = teacherGrade;
    }

    /**
     * 获取简介
     *
     * @return TEACHER_INFO - 简介
     */
    public String getTeacherInfo() {
        return teacherInfo;
    }

    /**
     * 设置简介
     *
     * @param teacherInfo 简介
     */
    public void setTeacherInfo(String teacherInfo) {
        this.teacherInfo = teacherInfo;
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