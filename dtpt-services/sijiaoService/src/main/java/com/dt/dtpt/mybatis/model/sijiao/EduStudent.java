package com.dt.dtpt.mybatis.model.sijiao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Table(name = "edu_student")
public class EduStudent implements Serializable {
    /**
     * 学员编号
     */
	@Id
    @Column(name = "STUDENT_ID")
    private String studentId;

    /**
     * 用户编号
     */
    @Column(name = "ADD_USER")
    private String addUser;

    /**
     * 微信OPENID
     */
    @Column(name = "WX_OPENID")
    private String wxOpenid;

    /**
     * 学员姓名
     */
    @Column(name = "STUDENT_NAME")
    private String studentName;

    /**
     * 性别(0女1男)
     */
    @Column(name = "SEX")
    private Integer sex;

    /**
     * 年龄
     */
    @Column(name = "BIRTHDAY")
    private Date birthday;

    /**
     * 手机号
     */
    @Column(name = "PHONE")
    private String phone;

    /**
     * 是否在读(0不在读1在读)
     */
    @Column(name = "IS_INSCHOOL")
    private Integer isInschool;

    /**
     * 在读年级(1幼班2高中以上3大学以上4小一5小二6小三7小四8小五9小六10初一11初二12初三13高一14高二15高三)
     */
    @Column(name = "IN_GRADE")
    private Integer inGrade;

    /**
     * 在读学校
     */
    @Column(name = "IN_SCHOOL")
    private String inSchool;

    /**
     * 主攻专业
     */
    @Column(name = "IN_SCORE")
    private String inScore;

    /**
     * 最高学历(1初中以下2初中3中专4本科5本科以上)
     */
    @Column(name = "HIGHEST_EDU")
    private Integer highestEdu;

    /**
     * QQ号
     */
    @Column(name = "QQ")
    private Integer qq;

    /**
     * 所在省
     */
    @Column(name = "PROVINCE")
    private String province;

    /**
     * 所在市
     */
    @Column(name = "CITY")
    private String city;

    /**
     * 所在区
     */
    @Column(name = "AREA")
    private String area;

    /**
     * 住址
     */
    @Column(name = "ADDRESS")
    private String address;

    /**
     * 所属商户
     */
    @Column(name = "USER_ID")
    private String userId;

    /**
     * 邮编
     */
    @Column(name = "ZIP_CODE")
    private String zipCode;

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
     * 获取用户编号
     *
     * @return ADD_USER - 用户编号
     */
    public String getAddUser() {
        return addUser;
    }

    /**
     * 设置用户编号
     *
     * @param addUser 用户编号
     */
    public void setAddUser(String addUser) {
        this.addUser = addUser;
    }

    /**
     * 获取微信OPENID
     *
     * @return WX_OPENID - 微信OPENID
     */
    public String getWxOpenid() {
        return wxOpenid;
    }

    /**
     * 设置微信OPENID
     *
     * @param wxOpenid 微信OPENID
     */
    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid;
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
     * @return BIRTHDAY - 年龄
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置年龄
     *
     * @param birthday 年龄
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取手机号
     *
     * @return PHONE - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取是否在读(0不在读1在读)
     *
     * @return IS_INSCHOOL - 是否在读(0不在读1在读)
     */
    public Integer getIsInschool() {
        return isInschool;
    }

    /**
     * 设置是否在读(0不在读1在读)
     *
     * @param isInschool 是否在读(0不在读1在读)
     */
    public void setIsInschool(Integer isInschool) {
        this.isInschool = isInschool;
    }

    /**
     * 获取在读年级(1幼班2高中以上3大学以上4小一5小二6小三7小四8小五9小六10初一11初二12初三13高一14高二15高三)
     *
     * @return IN_GRADE - 在读年级(1幼班2高中以上3大学以上4小一5小二6小三7小四8小五9小六10初一11初二12初三13高一14高二15高三)
     */
    public Integer getInGrade() {
        return inGrade;
    }

    /**
     * 设置在读年级(1幼班2高中以上3大学以上4小一5小二6小三7小四8小五9小六10初一11初二12初三13高一14高二15高三)
     *
     * @param inGrade 在读年级(1幼班2高中以上3大学以上4小一5小二6小三7小四8小五9小六10初一11初二12初三13高一14高二15高三)
     */
    public void setInGrade(Integer inGrade) {
        this.inGrade = inGrade;
    }

    /**
     * 获取在读学校
     *
     * @return IN_SCHOOL - 在读学校
     */
    public String getInSchool() {
        return inSchool;
    }

    /**
     * 设置在读学校
     *
     * @param inSchool 在读学校
     */
    public void setInSchool(String inSchool) {
        this.inSchool = inSchool;
    }

    /**
     * 获取主攻专业
     *
     * @return IN_SCORE - 主攻专业
     */
    public String getInScore() {
        return inScore;
    }

    /**
     * 设置主攻专业
     *
     * @param inScore 主攻专业
     */
    public void setInScore(String inScore) {
        this.inScore = inScore;
    }

    /**
     * 获取最高学历(1初中以下2初中3中专4本科5本科以上)
     *
     * @return HIGHEST_EDU - 最高学历(1初中以下2初中3中专4本科5本科以上)
     */
    public Integer getHighestEdu() {
        return highestEdu;
    }

    /**
     * 设置最高学历(1初中以下2初中3中专4本科5本科以上)
     *
     * @param highestEdu 最高学历(1初中以下2初中3中专4本科5本科以上)
     */
    public void setHighestEdu(Integer highestEdu) {
        this.highestEdu = highestEdu;
    }

    /**
     * 获取QQ号
     *
     * @return QQ - QQ号
     */
    public Integer getQq() {
        return qq;
    }

    /**
     * 设置QQ号
     *
     * @param qq QQ号
     */
    public void setQq(Integer qq) {
        this.qq = qq;
    }

    /**
     * 获取所在省
     *
     * @return PROVINCE - 所在省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置所在省
     *
     * @param province 所在省
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取所在市
     *
     * @return CITY - 所在市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置所在市
     *
     * @param city 所在市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取所在区
     *
     * @return AREA - 所在区
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置所在区
     *
     * @param area 所在区
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取住址
     *
     * @return ADDRESS - 住址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置住址
     *
     * @param address 住址
     */
    public void setAddress(String address) {
        this.address = address;
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
     * 获取邮编
     *
     * @return ZIP_CODE - 邮编
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * 设置邮编
     *
     * @param zipCode 邮编
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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