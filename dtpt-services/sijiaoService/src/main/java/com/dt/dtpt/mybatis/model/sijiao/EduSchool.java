package com.dt.dtpt.mybatis.model.sijiao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Table(name = "edu_school")
public class EduSchool implements Serializable {
    /**
     * 学校编号
     */
	@Id
    @Column(name = "SCHOOL_ID")
    private String schoolId;

    /**
     * 学校名称
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 学校简名
     */
    @Column(name = "AS_NAME")
    private String asName;

    /**
     * 学校电话
     */
    @Column(name = "TEL_PHONE")
    private String telPhone;

    /**
     * 校长姓名
     */
    @Column(name = "MASTER")
    private String master;

    /**
     * 校长手机号
     */
    @Column(name = "MASTER_PHONE")
    private String masterPhone;

    /**
     * 学校简介
     */
    @Column(name = "INFO")
    private String info;

    /**
     * 学校地址
     */
    @Column(name = "ADDRESS")
    private String address;

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
     * 获取学校名称
     *
     * @return NAME - 学校名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置学校名称
     *
     * @param name 学校名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取学校简名
     *
     * @return AS_NAME - 学校简名
     */
    public String getAsName() {
        return asName;
    }

    /**
     * 设置学校简名
     *
     * @param asName 学校简名
     */
    public void setAsName(String asName) {
        this.asName = asName;
    }

    /**
     * 获取学校电话
     *
     * @return TEL_PHONE - 学校电话
     */
    public String getTelPhone() {
        return telPhone;
    }

    /**
     * 设置学校电话
     *
     * @param telPhone 学校电话
     */
    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    /**
     * 获取校长姓名
     *
     * @return MASTER - 校长姓名
     */
    public String getMaster() {
        return master;
    }

    /**
     * 设置校长姓名
     *
     * @param master 校长姓名
     */
    public void setMaster(String master) {
        this.master = master;
    }

    /**
     * 获取校长手机号
     *
     * @return MASTER_PHONE - 校长手机号
     */
    public String getMasterPhone() {
        return masterPhone;
    }

    /**
     * 设置校长手机号
     *
     * @param masterPhone 校长手机号
     */
    public void setMasterPhone(String masterPhone) {
        this.masterPhone = masterPhone;
    }

    /**
     * 获取学校简介
     *
     * @return INFO - 学校简介
     */
    public String getInfo() {
        return info;
    }

    /**
     * 设置学校简介
     *
     * @param info 学校简介
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * 获取学校地址
     *
     * @return ADDRESS - 学校地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置学校地址
     *
     * @param address 学校地址
     */
    public void setAddress(String address) {
        this.address = address;
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