package com.dt.dtpt.mybatis.model.common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_user_solution")
public class TbUserSolution implements Serializable {
    /**
     * 编号
     */
    @Column(name = "USER_SID")
    private String userSid;

    /**
     * 方案组件编号
     */
    @Column(name = "SOLUTION_ID")
    private String solutionId;

    /**
     * 用户编号
     */
    @Column(name = "USER_ID")
    private String userId;

    /**
     * 生效时间
     */
    @Column(name = "START_DATE")
    private Date startDate;

    /**
     * 失效时间
     */
    @Column(name = "END_DATE")
    private Date endDate;

    /**
     * 是否试用
     */
    @Column(name = "IS_TEST")
    private Integer isTest;

    /**
     * 是否失效
     */
    @Column(name = "IS_OVER")
    private Integer isOver;

    /**
     * 交易金额
     */
    @Column(name = "FEE")
    private BigDecimal fee;

    /**
     * 使用周期
     */
    @Column(name = "USE_LIFE")
    private Integer useLife;

    /**
     * 交易时间
     */
    @Column(name = "CREATE_DATE")
    private Date createDate;

    /**
     * 备注
     */
    @Column(name = "COMMON")
    private String common;

    private static final long serialVersionUID = 1L;

    /**
     * 获取编号
     *
     * @return USER_SID - 编号
     */
    public String getUserSid() {
        return userSid;
    }

    /**
     * 设置编号
     *
     * @param userSid 编号
     */
    public void setUserSid(String userSid) {
        this.userSid = userSid;
    }

    /**
     * 获取方案组件编号
     *
     * @return SOLUTION_ID - 方案组件编号
     */
    public String getSolutionId() {
        return solutionId;
    }

    /**
     * 设置方案组件编号
     *
     * @param solutionId 方案组件编号
     */
    public void setSolutionId(String solutionId) {
        this.solutionId = solutionId;
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
     * 获取生效时间
     *
     * @return START_DATE - 生效时间
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 设置生效时间
     *
     * @param startDate 生效时间
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取失效时间
     *
     * @return END_DATE - 失效时间
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置失效时间
     *
     * @param endDate 失效时间
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取是否试用
     *
     * @return IS_TEST - 是否试用
     */
    public Integer getIsTest() {
        return isTest;
    }

    /**
     * 设置是否试用
     *
     * @param isTest 是否试用
     */
    public void setIsTest(Integer isTest) {
        this.isTest = isTest;
    }

    /**
     * 获取是否失效
     *
     * @return IS_OVER - 是否失效
     */
    public Integer getIsOver() {
        return isOver;
    }

    /**
     * 设置是否失效
     *
     * @param isOver 是否失效
     */
    public void setIsOver(Integer isOver) {
        this.isOver = isOver;
    }

    /**
     * 获取交易金额
     *
     * @return FEE - 交易金额
     */
    public BigDecimal getFee() {
        return fee;
    }

    /**
     * 设置交易金额
     *
     * @param fee 交易金额
     */
    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    /**
     * 获取使用周期
     *
     * @return USE_LIFE - 使用周期
     */
    public Integer getUseLife() {
        return useLife;
    }

    /**
     * 设置使用周期
     *
     * @param useLife 使用周期
     */
    public void setUseLife(Integer useLife) {
        this.useLife = useLife;
    }

    /**
     * 获取交易时间
     *
     * @return CREATE_DATE - 交易时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置交易时间
     *
     * @param createDate 交易时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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