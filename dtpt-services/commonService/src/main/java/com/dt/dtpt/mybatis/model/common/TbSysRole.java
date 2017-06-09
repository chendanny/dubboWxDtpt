package com.dt.dtpt.mybatis.model.common;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_sys_role")
public class TbSysRole implements Serializable {
    /**
     * 角色编号
     */
    @Column(name = "ROLE_ID")
    private String roleId;

    /**
     * 名称
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 注释
     */
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * 状态
     */
    @Column(name = "STATE")
    private Integer state;

    /**
     * 修改状态时间
     */
    @Column(name = "STATE_DATE")
    private Date stateDate;

    private static final long serialVersionUID = 1L;

    /**
     * 获取角色编号
     *
     * @return ROLE_ID - 角色编号
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 设置角色编号
     *
     * @param roleId 角色编号
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取名称
     *
     * @return NAME - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取注释
     *
     * @return DESCRIPTION - 注释
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置注释
     *
     * @param description 注释
     */
    public void setDescription(String description) {
        this.description = description;
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
     * 获取修改状态时间
     *
     * @return STATE_DATE - 修改状态时间
     */
    public Date getStateDate() {
        return stateDate;
    }

    /**
     * 设置修改状态时间
     *
     * @param stateDate 修改状态时间
     */
    public void setStateDate(Date stateDate) {
        this.stateDate = stateDate;
    }
}