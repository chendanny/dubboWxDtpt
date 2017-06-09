package com.dt.dtpt.mybatis.model.common;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_sys_user")
public class TbSysUser implements Serializable {
    /**
     * 用户编号
     */
    @Column(name = "USER_ID")
    private String userId;

    /**
     * 用户名
     */
    @Column(name = "USERNAME")
    private String username;

    /**
     * 密码
     */
    @Column(name = "PASSWORD")
    private String password;

    /**
     * 状态修改时间
     */
    @Column(name = "STATE_DATE")
    private Date stateDate;

    /**
     * 姓名
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 性别(0女1男)
     */
    @Column(name = "SEX")
    private Integer sex;

    /**
     * 手机电话
     */
    @Column(name = "MOBILE_NBR")
    private String mobileNbr;

    /**
     * 邮箱地址
     */
    @Column(name = "EMAIL_ADDR")
    private String emailAddr;

    /**
     * 微信OPENID
     */
    @Column(name = "WX_UNIONID")
    private String wxUnionid;

    /**
     * 固定电话
     */
    @Column(name = "PHONE_NBR")
    private String phoneNbr;

    /**
     * 状态
     */
    @Column(name = "STATE")
    private Integer state;

    /**
     * 登陆状态(0离线1在线)
     */
    @Column(name = "LOGIN_STATE")
    private Integer loginState;

    /**
     * 微信号
     */
    @Column(name = "WX_ACCOUNT")
    private String wxAccount;

    /**
     * QQ号
     */
    @Column(name = "QQ")
    private String qq;

    /**
     * 昵称
     */
    @Column(name = "AS_NAME")
    private String asName;

    @Column(name = "LOGO")
    private String logo;

    @Column(name = "IN_CITY")
    private String inCity;

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
     * 获取用户编号
     *
     * @return USER_ID - 用户编号
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户编号
     *
     * @param userId 用户编号
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名
     *
     * @return USERNAME - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return PASSWORD - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取状态修改时间
     *
     * @return STATE_DATE - 状态修改时间
     */
    public Date getStateDate() {
        return stateDate;
    }

    /**
     * 设置状态修改时间
     *
     * @param stateDate 状态修改时间
     */
    public void setStateDate(Date stateDate) {
        this.stateDate = stateDate;
    }

    /**
     * 获取姓名
     *
     * @return NAME - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
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
     * 获取手机电话
     *
     * @return MOBILE_NBR - 手机电话
     */
    public String getMobileNbr() {
        return mobileNbr;
    }

    /**
     * 设置手机电话
     *
     * @param mobileNbr 手机电话
     */
    public void setMobileNbr(String mobileNbr) {
        this.mobileNbr = mobileNbr;
    }

    /**
     * 获取邮箱地址
     *
     * @return EMAIL_ADDR - 邮箱地址
     */
    public String getEmailAddr() {
        return emailAddr;
    }

    /**
     * 设置邮箱地址
     *
     * @param emailAddr 邮箱地址
     */
    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    /**
     * 获取微信OPENID
     *
     * @return WX_UNIONID - 微信OPENID
     */
    public String getWxUnionid() {
        return wxUnionid;
    }

    /**
     * 设置微信OPENID
     *
     * @param wxUnionid 微信OPENID
     */
    public void setWxUnionid(String wxUnionid) {
        this.wxUnionid = wxUnionid;
    }

    /**
     * 获取固定电话
     *
     * @return PHONE_NBR - 固定电话
     */
    public String getPhoneNbr() {
        return phoneNbr;
    }

    /**
     * 设置固定电话
     *
     * @param phoneNbr 固定电话
     */
    public void setPhoneNbr(String phoneNbr) {
        this.phoneNbr = phoneNbr;
    }

    /**
     * 获取状态
     *
     * @return STATE - 状态
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态
     *
     * @param state 状态
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取登陆状态(0离线1在线)
     *
     * @return LOGIN_STATE - 登陆状态(0离线1在线)
     */
    public Integer getLoginState() {
        return loginState;
    }

    /**
     * 设置登陆状态(0离线1在线)
     *
     * @param loginState 登陆状态(0离线1在线)
     */
    public void setLoginState(Integer loginState) {
        this.loginState = loginState;
    }

    /**
     * 获取微信号
     *
     * @return WX_ACCOUNT - 微信号
     */
    public String getWxAccount() {
        return wxAccount;
    }

    /**
     * 设置微信号
     *
     * @param wxAccount 微信号
     */
    public void setWxAccount(String wxAccount) {
        this.wxAccount = wxAccount;
    }

    /**
     * 获取QQ号
     *
     * @return QQ - QQ号
     */
    public String getQq() {
        return qq;
    }

    /**
     * 设置QQ号
     *
     * @param qq QQ号
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 获取昵称
     *
     * @return AS_NAME - 昵称
     */
    public String getAsName() {
        return asName;
    }

    /**
     * 设置昵称
     *
     * @param asName 昵称
     */
    public void setAsName(String asName) {
        this.asName = asName;
    }

    /**
     * @return LOGO
     */
    public String getLogo() {
        return logo;
    }

    /**
     * @param logo
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * @return IN_CITY
     */
    public String getInCity() {
        return inCity;
    }

    /**
     * @param inCity
     */
    public void setInCity(String inCity) {
        this.inCity = inCity;
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