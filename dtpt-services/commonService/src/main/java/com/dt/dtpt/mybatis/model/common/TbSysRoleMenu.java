package com.dt.dtpt.mybatis.model.common;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_sys_role_menu")
public class TbSysRoleMenu implements Serializable {
    /**
     * 角色菜单编号
     */
    @Column(name = "ROLE_MENU_ID")
    private String roleMenuId;

    /**
     * 角色编号
     */
    @Column(name = "ROLE_ID")
    private String roleId;

    /**
     * 菜单编号
     */
    @Column(name = "MENU_ID")
    private String menuId;

    private static final long serialVersionUID = 1L;

    /**
     * 获取角色菜单编号
     *
     * @return ROLE_MENU_ID - 角色菜单编号
     */
    public String getRoleMenuId() {
        return roleMenuId;
    }

    /**
     * 设置角色菜单编号
     *
     * @param roleMenuId 角色菜单编号
     */
    public void setRoleMenuId(String roleMenuId) {
        this.roleMenuId = roleMenuId;
    }

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
}