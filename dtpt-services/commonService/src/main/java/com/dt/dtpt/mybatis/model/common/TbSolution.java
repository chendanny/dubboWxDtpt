package com.dt.dtpt.mybatis.model.common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_solution")
public class TbSolution implements Serializable {
    /**
     * 编号
     */
    @Column(name = "SOLUTION_ID")
    private String solutionId;

    /**
     * 名称
     */
    @Column(name = "SOLUTION_NAME")
    private String solutionName;

    /**
     * 级别(1方案2组件)
     */
    @Column(name = "SOLUTION_GRADE")
    private Integer solutionGrade;

    /**
     * LOGO
     */
    @Column(name = "LOGO")
    private String logo;

    /**
     * 描述
     */
    @Column(name = "DES")
    private String des;

    /**
     * 行业(取字典表数据)
     */
    @Column(name = "SOLUTION_TYPE")
    private Integer solutionType;

    /**
     * 分类(取字典表数据)
     */
    @Column(name = "SUB_TYPE")
    private Integer subType;

    /**
     * 展示类型(1微信2PC3安卓4苹果)
     */
    @Column(name = "SHOW_TYPE")
    private Integer showType;

    /**
     * 是否免费(0否1是)
     */
    @Column(name = "IS_FREE")
    private Integer isFree;

    /**
     * 使用周期(1一月2两月3三月6半年12一年)
     */
    @Column(name = "USE_LIFE")
    private Integer useLife;

    /**
     * 最小周期单价
     */
    @Column(name = "SOLUTION_FEE")
    private BigDecimal solutionFee;

    /**
     * 周期折价公式
     */
    @Column(name = "DISCOUNT_RULE")
    private String discountRule;

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
     * 获取编号
     *
     * @return SOLUTION_ID - 编号
     */
    public String getSolutionId() {
        return solutionId;
    }

    /**
     * 设置编号
     *
     * @param solutionId 编号
     */
    public void setSolutionId(String solutionId) {
        this.solutionId = solutionId;
    }

    /**
     * 获取名称
     *
     * @return SOLUTION_NAME - 名称
     */
    public String getSolutionName() {
        return solutionName;
    }

    /**
     * 设置名称
     *
     * @param solutionName 名称
     */
    public void setSolutionName(String solutionName) {
        this.solutionName = solutionName;
    }

    /**
     * 获取级别(1方案2组件)
     *
     * @return SOLUTION_GRADE - 级别(1方案2组件)
     */
    public Integer getSolutionGrade() {
        return solutionGrade;
    }

    /**
     * 设置级别(1方案2组件)
     *
     * @param solutionGrade 级别(1方案2组件)
     */
    public void setSolutionGrade(Integer solutionGrade) {
        this.solutionGrade = solutionGrade;
    }

    /**
     * 获取LOGO
     *
     * @return LOGO - LOGO
     */
    public String getLogo() {
        return logo;
    }

    /**
     * 设置LOGO
     *
     * @param logo LOGO
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * 获取描述
     *
     * @return DES - 描述
     */
    public String getDes() {
        return des;
    }

    /**
     * 设置描述
     *
     * @param des 描述
     */
    public void setDes(String des) {
        this.des = des;
    }

    /**
     * 获取行业(取字典表数据)
     *
     * @return SOLUTION_TYPE - 行业(取字典表数据)
     */
    public Integer getSolutionType() {
        return solutionType;
    }

    /**
     * 设置行业(取字典表数据)
     *
     * @param solutionType 行业(取字典表数据)
     */
    public void setSolutionType(Integer solutionType) {
        this.solutionType = solutionType;
    }

    /**
     * 获取分类(取字典表数据)
     *
     * @return SUB_TYPE - 分类(取字典表数据)
     */
    public Integer getSubType() {
        return subType;
    }

    /**
     * 设置分类(取字典表数据)
     *
     * @param subType 分类(取字典表数据)
     */
    public void setSubType(Integer subType) {
        this.subType = subType;
    }

    /**
     * 获取展示类型(1微信2PC3安卓4苹果)
     *
     * @return SHOW_TYPE - 展示类型(1微信2PC3安卓4苹果)
     */
    public Integer getShowType() {
        return showType;
    }

    /**
     * 设置展示类型(1微信2PC3安卓4苹果)
     *
     * @param showType 展示类型(1微信2PC3安卓4苹果)
     */
    public void setShowType(Integer showType) {
        this.showType = showType;
    }

    /**
     * 获取是否免费(0否1是)
     *
     * @return IS_FREE - 是否免费(0否1是)
     */
    public Integer getIsFree() {
        return isFree;
    }

    /**
     * 设置是否免费(0否1是)
     *
     * @param isFree 是否免费(0否1是)
     */
    public void setIsFree(Integer isFree) {
        this.isFree = isFree;
    }

    /**
     * 获取使用周期(1一月2两月3三月6半年12一年)
     *
     * @return USE_LIFE - 使用周期(1一月2两月3三月6半年12一年)
     */
    public Integer getUseLife() {
        return useLife;
    }

    /**
     * 设置使用周期(1一月2两月3三月6半年12一年)
     *
     * @param useLife 使用周期(1一月2两月3三月6半年12一年)
     */
    public void setUseLife(Integer useLife) {
        this.useLife = useLife;
    }

    /**
     * 获取最小周期单价
     *
     * @return SOLUTION_FEE - 最小周期单价
     */
    public BigDecimal getSolutionFee() {
        return solutionFee;
    }

    /**
     * 设置最小周期单价
     *
     * @param solutionFee 最小周期单价
     */
    public void setSolutionFee(BigDecimal solutionFee) {
        this.solutionFee = solutionFee;
    }

    /**
     * 获取周期折价公式
     *
     * @return DISCOUNT_RULE - 周期折价公式
     */
    public String getDiscountRule() {
        return discountRule;
    }

    /**
     * 设置周期折价公式
     *
     * @param discountRule 周期折价公式
     */
    public void setDiscountRule(String discountRule) {
        this.discountRule = discountRule;
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