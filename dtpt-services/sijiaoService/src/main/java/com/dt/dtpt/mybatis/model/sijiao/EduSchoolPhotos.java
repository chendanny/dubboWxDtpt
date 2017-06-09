package com.dt.dtpt.mybatis.model.sijiao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Table(name = "edu_school_photos")
public class EduSchoolPhotos implements Serializable {
    /**
     * 相册编号
     */
	@Id
    @Column(name = "PHOTO_ID")
    private String photoId;

    /**
     * 相册名称
     */
    @Column(name = "PHOTO_NAME")
    private String photoName;

    /**
     * 相册简介
     */
    @Column(name = "PHOTO_INFO")
    private String photoInfo;

    /**
     * 课程编号
     */
    @Column(name = "SOURCE_ID")
    private String sourceId;

    /**
     * 课程名称
     */
    @Column(name = "SOURCE_NAME")
    private String sourceName;

    /**
     * 活动编号
     */
    @Column(name = "ACTIVE_ID")
    private String activeId;

    /**
     * 活动名称
     */
    @Column(name = "ACTIVE_NAME")
    private String activeName;

    /**
     * 相册照片
     */
    @Column(name = "PHOTO_PICS")
    private String photoPics;

    /**
     * 照片名称
     */
    @Column(name = "PHOTO_NAMES")
    private String photoNames;

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
     * 获取相册编号
     *
     * @return PHOTO_ID - 相册编号
     */
    public String getPhotoId() {
        return photoId;
    }

    /**
     * 设置相册编号
     *
     * @param photoId 相册编号
     */
    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    /**
     * 获取相册名称
     *
     * @return PHOTO_NAME - 相册名称
     */
    public String getPhotoName() {
        return photoName;
    }

    /**
     * 设置相册名称
     *
     * @param photoName 相册名称
     */
    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    /**
     * 获取相册简介
     *
     * @return PHOTO_INFO - 相册简介
     */
    public String getPhotoInfo() {
        return photoInfo;
    }

    /**
     * 设置相册简介
     *
     * @param photoInfo 相册简介
     */
    public void setPhotoInfo(String photoInfo) {
        this.photoInfo = photoInfo;
    }

    /**
     * 获取课程编号
     *
     * @return SOURCE_ID - 课程编号
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * 设置课程编号
     *
     * @param sourceId 课程编号
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * 获取课程名称
     *
     * @return SOURCE_NAME - 课程名称
     */
    public String getSourceName() {
        return sourceName;
    }

    /**
     * 设置课程名称
     *
     * @param sourceName 课程名称
     */
    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
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
     * 获取活动名称
     *
     * @return ACTIVE_NAME - 活动名称
     */
    public String getActiveName() {
        return activeName;
    }

    /**
     * 设置活动名称
     *
     * @param activeName 活动名称
     */
    public void setActiveName(String activeName) {
        this.activeName = activeName;
    }

    /**
     * 获取相册照片
     *
     * @return PHOTO_PICS - 相册照片
     */
    public String getPhotoPics() {
        return photoPics;
    }

    /**
     * 设置相册照片
     *
     * @param photoPics 相册照片
     */
    public void setPhotoPics(String photoPics) {
        this.photoPics = photoPics;
    }

    /**
     * 获取照片名称
     *
     * @return PHOTO_NAMES - 照片名称
     */
    public String getPhotoNames() {
        return photoNames;
    }

    /**
     * 设置照片名称
     *
     * @param photoNames 照片名称
     */
    public void setPhotoNames(String photoNames) {
        this.photoNames = photoNames;
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