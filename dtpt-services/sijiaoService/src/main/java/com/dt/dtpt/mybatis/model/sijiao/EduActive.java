package com.dt.dtpt.mybatis.model.sijiao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "edu_active")
public class EduActive implements Serializable {
    /**
     * 活动编号
     */
	@Id
    @Column(name = "ACTIVE_ID")
    private String activeId;

    /**
     * 学校编号
     */
    @Column(name = "SCHOOL_ID")
    private String schoolId;

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
     * 开始时间
     */
    @Column(name = "START_DATE")
    private Date startDate;

    /**
     * 结束时间
     */
    @Column(name = "END_DATE")
    private Date endDate;

    /**
     * 地点
     */
    @Column(name = "ADDRESS")
    private String address;

    /**
     * 带队人
     */
    @Column(name = "LEADER")
    private String leader;

    /**
     * 带队人电话
     */
    @Column(name = "LEADER_PHONE")
    private String leaderPhone;

    /**
     * 活动内容
     */
    @Column(name = "ACTIVE_INFO")
    private String activeInfo;

    /**
     * 满额人数
     */
    @Column(name = "MAX_STUDENTS")
    private Integer maxStudents;

    /**
     * 发布人
     */
    @Column(name = "PUBLICER")
    private String publicer;

    /**
     * 发布人昵称
     */
    @Column(name = "PUBLICER_AS_NAME")
    private String publicerAsName;

    /**
     * 活动费用
     */
    @Column(name = "ACTIVE_JF")
    private BigDecimal activeJf;

    /**
     * 发布时间
     */
    @Column(name = "PUBLIC_DATE")
    private Date publicDate;

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
     * 获取开始时间
     *
     * @return START_DATE - 开始时间
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 设置开始时间
     *
     * @param startDate 开始时间
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取结束时间
     *
     * @return END_DATE - 结束时间
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置结束时间
     *
     * @param endDate 结束时间
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取地点
     *
     * @return ADDRESS - 地点
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地点
     *
     * @param address 地点
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取带队人
     *
     * @return LEADER - 带队人
     */
    public String getLeader() {
        return leader;
    }

    /**
     * 设置带队人
     *
     * @param leader 带队人
     */
    public void setLeader(String leader) {
        this.leader = leader;
    }

    /**
     * 获取带队人电话
     *
     * @return LEADER_PHONE - 带队人电话
     */
    public String getLeaderPhone() {
        return leaderPhone;
    }

    /**
     * 设置带队人电话
     *
     * @param leaderPhone 带队人电话
     */
    public void setLeaderPhone(String leaderPhone) {
        this.leaderPhone = leaderPhone;
    }

    /**
     * 获取活动内容
     *
     * @return ACTIVE_INFO - 活动内容
     */
    public String getActiveInfo() {
        return activeInfo;
    }

    /**
     * 设置活动内容
     *
     * @param activeInfo 活动内容
     */
    public void setActiveInfo(String activeInfo) {
        this.activeInfo = activeInfo;
    }

    /**
     * 获取满额人数
     *
     * @return MAX_STUDENTS - 满额人数
     */
    public Integer getMaxStudents() {
        return maxStudents;
    }

    /**
     * 设置满额人数
     *
     * @param maxStudents 满额人数
     */
    public void setMaxStudents(Integer maxStudents) {
        this.maxStudents = maxStudents;
    }

    /**
     * 获取发布人
     *
     * @return PUBLICER - 发布人
     */
    public String getPublicer() {
        return publicer;
    }

    /**
     * 设置发布人
     *
     * @param publicer 发布人
     */
    public void setPublicer(String publicer) {
        this.publicer = publicer;
    }

    /**
     * 获取发布人昵称
     *
     * @return PUBLICER_AS_NAME - 发布人昵称
     */
    public String getPublicerAsName() {
        return publicerAsName;
    }

    /**
     * 设置发布人昵称
     *
     * @param publicerAsName 发布人昵称
     */
    public void setPublicerAsName(String publicerAsName) {
        this.publicerAsName = publicerAsName;
    }

    /**
     * 获取活动费用
     *
     * @return ACTIVE_JF - 活动费用
     */
    public BigDecimal getActiveJf() {
        return activeJf;
    }

    /**
     * 设置活动费用
     *
     * @param activeJf 活动费用
     */
    public void setActiveJf(BigDecimal activeJf) {
        this.activeJf = activeJf;
    }

    /**
     * 获取发布时间
     *
     * @return PUBLIC_DATE - 发布时间
     */
    public Date getPublicDate() {
        return publicDate;
    }

    /**
     * 设置发布时间
     *
     * @param publicDate 发布时间
     */
    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
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