package com.dt.dtpt.mybatis.model.publicwx;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wx_user_public")
public class WxUserPublic implements Serializable {
    /**
     * 编号
     */
	@Id
    @Column(name = "USER_PWX_ID")
    private String userPwxId;

    /**
     * 公众号编号
     */
    @Column(name = "PUBLIC_ID")
    private String publicId;

    /**
     * 用户编号
     */
    @Column(name = "USER_ID")
    private String userId;

    /**
     * 状态(0已取消关注1关注中)
     */
    @Column(name = "STATE")
    private Integer state;

    @Column(name = "PULLER_ID")
    private String pullerId;

    /**
     * 微信OPENID
     */
    @Column(name = "WX_OPENID")
    private String wxOpenid;

    /**
     * 微信OPENID
     */
    @Column(name = "WX_UNIONID")
    private String wxUnionid;

    /**
     * 关注时间
     */
    @Column(name = "ADD_DATE")
    private Date addDate;

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
     * 取消关注时间
     */
    @Column(name = "REMOVE_DATE")
    private Date removeDate;

    private static final long serialVersionUID = 1L;

    /**
     * 获取编号
     *
     * @return USER_PWX_ID - 编号
     */
    public String getUserPwxId() {
        return userPwxId;
    }

    /**
     * 设置编号
     *
     * @param userPwxId 编号
     */
    public void setUserPwxId(String userPwxId) {
        this.userPwxId = userPwxId;
    }

    /**
     * 获取公众号编号
     *
     * @return PUBLIC_ID - 公众号编号
     */
    public String getPublicId() {
        return publicId;
    }

    /**
     * 设置公众号编号
     *
     * @param publicId 公众号编号
     */
    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

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
     * 获取状态(0已取消关注1关注中)
     *
     * @return STATE - 状态(0已取消关注1关注中)
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态(0已取消关注1关注中)
     *
     * @param state 状态(0已取消关注1关注中)
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * @return PULLER_ID
     */
    public String getPullerId() {
        return pullerId;
    }

    /**
     * @param pullerId
     */
    public void setPullerId(String pullerId) {
        this.pullerId = pullerId;
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
     * 获取关注时间
     *
     * @return ADD_DATE - 关注时间
     */
    public Date getAddDate() {
        return addDate;
    }

    /**
     * 设置关注时间
     *
     * @param addDate 关注时间
     */
    public void setAddDate(Date addDate) {
        this.addDate = addDate;
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
     * 获取取消关注时间
     *
     * @return REMOVE_DATE - 取消关注时间
     */
    public Date getRemoveDate() {
        return removeDate;
    }

    /**
     * 设置取消关注时间
     *
     * @param removeDate 取消关注时间
     */
    public void setRemoveDate(Date removeDate) {
        this.removeDate = removeDate;
    }
}