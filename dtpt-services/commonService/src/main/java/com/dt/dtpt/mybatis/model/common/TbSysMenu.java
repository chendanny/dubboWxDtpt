package com.dt.dtpt.mybatis.model.common;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_sys_menu")
public class TbSysMenu implements Serializable {
    /**
     * 菜单编号
     */
    @Column(name = "MENU_ID")
    private String menuId;

    /**
     * 父ID
     */
    @Column(name = "PARENT_ID")
    private String parentId;

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
     * 动作
     */
    @Column(name = "ACTION")
    private String action;

    /**
     * 菜单类型
     */
    @Column(name = "TYPE")
    private Integer type;

    /**
     * 资源ID
     */
    @Column(name = "RESOURCE_ID")
    private String resourceId;

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

    /**
     * 序号
     */
    @Column(name = "MENU_XH")
    private Integer menuXh;

    private static final long serialVersionUID = 1L;

    /**
     * 获取菜单编号
     *
     * @return MENU_ID - 菜单编号
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * 设置菜单编号
     *
     * @param menuId 菜单编号
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    /**
     * 获取父ID
     *
     * @return PARENT_ID - 父ID
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父ID
     *
     * @param parentId 父ID
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
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
     * 获取动作
     *
     * @return ACTION - 动作
     */
    public String getAction() {
        return action;
    }

    /**
     * 设置动作
     *
     * @param action 动作
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * 获取菜单类型
     *
     * @return TYPE - 菜单类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置菜单类型
     *
     * @param type 菜单类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取资源ID
     *
     * @return RESOURCE_ID - 资源ID
     */
    public String getResourceId() {
        return resourceId;
    }

    /**
     * 设置资源ID
     *
     * @param resourceId 资源ID
     */
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
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

    /**
     * 获取序号
     *
     * @return MENU_XH - 序号
     */
    public Integer getMenuXh() {
        return menuXh;
    }

    /**
     * 设置序号
     *
     * @param menuXh 序号
     */
    public void setMenuXh(Integer menuXh) {
        this.menuXh = menuXh;
    }
}