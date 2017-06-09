package com.dt.dtpt.mybatis.model.common;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_sys_user_role")
public class TbSysUserRole implements Serializable {
    /**
     * 编号
     */
    @Column(name = "USER_ROLE_ID")
    private String userRoleId;

    /**
     * 用户编号
     */
    @Column(name = "USER_ID")
    private String userId;

    /**
     * 角色编号
     */
    @Column(name = "ROLE_ID")
    private String roleId;

    private static final long serialVersionUID = 1L;

    /**
     * 获取编号
     *
     * @return USER_ROLE_ID - 编号
     */
    public String getUserRoleId() {
        return userRoleId;
    }

    /**
     * 设置编号
     *
     * @param userRoleId 编号
     */
    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
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
}