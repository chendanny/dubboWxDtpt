package com.dt.dtpt.mybatis.model.common;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wx_user_public")
public class WxUserPublic implements Serializable {
    @Id
    @Column(name = "USER_PWX_ID")
    private String userPwxId;

    @Column(name = "PUBLIC_ID")
    private String publicId;

    @Column(name = "ID")
    private String id;

    /**
     * 0已取消关注
            1已关注
     */
    @Column(name = "STATE")
    private Integer state;

    @Column(name = "ADD_DATE")
    private Date addDate;

    @Column(name = "REMOVE_DATE")
    private Date removeDate;

    private static final long serialVersionUID = 1L;

    /**
     * @return USER_PWX_ID
     */
    public String getUserPwxId() {
        return userPwxId;
    }

    /**
     * @param userPwxId
     */
    public void setUserPwxId(String userPwxId) {
        this.userPwxId = userPwxId;
    }

    /**
     * @return PUBLIC_ID
     */
    public String getPublicId() {
        return publicId;
    }

    /**
     * @param publicId
     */
    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    /**
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取0已取消关注
            1已关注
     *
     * @return STATE - 0已取消关注
            1已关注
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置0已取消关注
            1已关注
     *
     * @param state 0已取消关注
            1已关注
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * @return ADD_DATE
     */
    public Date getAddDate() {
        return addDate;
    }

    /**
     * @param addDate
     */
    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    /**
     * @return REMOVE_DATE
     */
    public Date getRemoveDate() {
        return removeDate;
    }

    /**
     * @param removeDate
     */
    public void setRemoveDate(Date removeDate) {
        this.removeDate = removeDate;
    }
}