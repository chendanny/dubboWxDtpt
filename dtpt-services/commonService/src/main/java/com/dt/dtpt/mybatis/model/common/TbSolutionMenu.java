package com.dt.dtpt.mybatis.model.common;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_solution_menu")
public class TbSolutionMenu implements Serializable {
    /**
     * 编号
     */
    @Column(name = "SOLUTION_MENU_ID")
    private String solutionMenuId;

    /**
     * 组件方案编号
     */
    @Column(name = "SOLUTION_ID")
    private String solutionId;

    /**
     * 菜单ID
     */
    @Column(name = "MENU_ID")
    private String menuId;

    /**
     * 菜单新名称
     */
    @Column(name = "AS_NAME")
    private String asName;

    /**
     * 编辑时间
     */
    @Column(name = "EDIT_DATE")
    private Date editDate;

    /**
     * 父编号
     */
    @Column(name = "PARENT_ID")
    private String parentId;

    /**
     * 类型
     */
    @Column(name = "MENU_TYPE")
    private Integer menuType;

    /**
     * 序号
     */
    @Column(name = "MENU_XH")
    private Integer menuXh;

    /**
     * 备注
     */
    @Column(name = "COMMON")
    private String common;

    private static final long serialVersionUID = 1L;

    /**
     * 获取编号
     *
     * @return SOLUTION_MENU_ID - 编号
     */
    public String getSolutionMenuId() {
        return solutionMenuId;
    }

    /**
     * 设置编号
     *
     * @param solutionMenuId 编号
     */
    public void setSolutionMenuId(String solutionMenuId) {
        this.solutionMenuId = solutionMenuId;
    }

    /**
     * 获取组件方案编号
     *
     * @return SOLUTION_ID - 组件方案编号
     */
    public String getSolutionId() {
        return solutionId;
    }

    /**
     * 设置组件方案编号
     *
     * @param solutionId 组件方案编号
     */
    public void setSolutionId(String solutionId) {
        this.solutionId = solutionId;
    }

    /**
     * 获取菜单ID
     *
     * @return MENU_ID - 菜单ID
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * 设置菜单ID
     *
     * @param menuId 菜单ID
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    /**
     * 获取菜单新名称
     *
     * @return AS_NAME - 菜单新名称
     */
    public String getAsName() {
        return asName;
    }

    /**
     * 设置菜单新名称
     *
     * @param asName 菜单新名称
     */
    public void setAsName(String asName) {
        this.asName = asName;
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
     * 获取父编号
     *
     * @return PARENT_ID - 父编号
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父编号
     *
     * @param parentId 父编号
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取类型
     *
     * @return MENU_TYPE - 类型
     */
    public Integer getMenuType() {
        return menuType;
    }

    /**
     * 设置类型
     *
     * @param menuType 类型
     */
    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
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