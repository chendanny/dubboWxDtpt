package com.dt.dtpt.mybatis.model.common;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wx_public")
public class WxPublic implements Serializable {
    @Id
    @Column(name = "PUBLIC_ID")
    private String publicId;

    @Column(name = "ID")
    private String id;

    @Column(name = "PUBLIC_NAME")
    private String publicName;

    @Column(name = "WX_ACCOUNT")
    private String wxAccount;

    @Column(name = "WX_OPENID")
    private String wxOpenid;

    @Column(name = "PUBLIC_TYPE")
    private Integer publicType;

    @Column(name = "IS_APPLY")
    private Integer isApply;

    @Column(name = "UNIQUE_CHAR")
    private String uniqueChar;

    @Column(name = "ENCRIY_CHAR")
    private String encriyChar;

    /**
     * 1行业解决方案
            2自定义组件
     */
    @Column(name = "SOLUTION_TYPE")
    private Integer solutionType;

    /**
     * 0否
            1是
     */
    @Column(name = "IS_SELF")
    private Integer isSelf;

    @Column(name = "EDIT_DATE")
    private Date editDate;

    @Column(name = "COMMON")
    private String common;

    private static final long serialVersionUID = 1L;

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
     * @return PUBLIC_NAME
     */
    public String getPublicName() {
        return publicName;
    }

    /**
     * @param publicName
     */
    public void setPublicName(String publicName) {
        this.publicName = publicName;
    }

    /**
     * @return WX_ACCOUNT
     */
    public String getWxAccount() {
        return wxAccount;
    }

    /**
     * @param wxAccount
     */
    public void setWxAccount(String wxAccount) {
        this.wxAccount = wxAccount;
    }

    /**
     * @return WX_OPENID
     */
    public String getWxOpenid() {
        return wxOpenid;
    }

    /**
     * @param wxOpenid
     */
    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid;
    }

    /**
     * @return PUBLIC_TYPE
     */
    public Integer getPublicType() {
        return publicType;
    }

    /**
     * @param publicType
     */
    public void setPublicType(Integer publicType) {
        this.publicType = publicType;
    }

    /**
     * @return IS_APPLY
     */
    public Integer getIsApply() {
        return isApply;
    }

    /**
     * @param isApply
     */
    public void setIsApply(Integer isApply) {
        this.isApply = isApply;
    }

    /**
     * @return UNIQUE_CHAR
     */
    public String getUniqueChar() {
        return uniqueChar;
    }

    /**
     * @param uniqueChar
     */
    public void setUniqueChar(String uniqueChar) {
        this.uniqueChar = uniqueChar;
    }

    /**
     * @return ENCRIY_CHAR
     */
    public String getEncriyChar() {
        return encriyChar;
    }

    /**
     * @param encriyChar
     */
    public void setEncriyChar(String encriyChar) {
        this.encriyChar = encriyChar;
    }

    /**
     * 获取1行业解决方案
            2自定义组件
     *
     * @return SOLUTION_TYPE - 1行业解决方案
            2自定义组件
     */
    public Integer getSolutionType() {
        return solutionType;
    }

    /**
     * 设置1行业解决方案
            2自定义组件
     *
     * @param solutionType 1行业解决方案
            2自定义组件
     */
    public void setSolutionType(Integer solutionType) {
        this.solutionType = solutionType;
    }

    /**
     * 获取0否
            1是
     *
     * @return IS_SELF - 0否
            1是
     */
    public Integer getIsSelf() {
        return isSelf;
    }

    /**
     * 设置0否
            1是
     *
     * @param isSelf 0否
            1是
     */
    public void setIsSelf(Integer isSelf) {
        this.isSelf = isSelf;
    }

    /**
     * @return EDIT_DATE
     */
    public Date getEditDate() {
        return editDate;
    }

    /**
     * @param editDate
     */
    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    /**
     * @return COMMON
     */
    public String getCommon() {
        return common;
    }

    /**
     * @param common
     */
    public void setCommon(String common) {
        this.common = common;
    }
}