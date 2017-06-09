package com.dt.dtpt.mybatis.model.publicwx;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wx_menu_public")
public class WxMenuPublic implements Serializable {
    /**
     * 菜单编号
     */
    @Column(name = "PUBLIC_MENU_ID")
    private String publicMenuId;

    /**
     * 公众号编号
     */
    @Column(name = "PUBLIC_ID")
    private String publicId;

    /**
     * 菜单名称
     */
    @Column(name = "PUBLIC_MENU_NAME")
    private String publicMenuName;

    /**
     * 父菜单编号
     */
    @Column(name = "PARENT_ID")
    private String parentId;

    /**
     * 方案组件菜单编号
     */
    @Column(name = "SOLUTION_MENU_ID")
    private String solutionMenuId;

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
     * 获取菜单编号
     *
     * @return PUBLIC_MENU_ID - 菜单编号
     */
    public String getPublicMenuId() {
        return publicMenuId;
    }

    /**
     * 设置菜单编号
     *
     * @param publicMenuId 菜单编号
     */
    public void setPublicMenuId(String publicMenuId) {
        this.publicMenuId = publicMenuId;
    }

    /**
     * 获取公众号编号
     *
     * @return PUBLIC_ID - 公众号编号
     */
    public String getPublicId() {
        return publicId;
    }

    /**
     * 设置公众号编号
     *
     * @param publicId 公众号编号
     */
    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    /**
     * 获取菜单名称
     *
     * @return PUBLIC_MENU_NAME - 菜单名称
     */
    public String getPublicMenuName() {
        return publicMenuName;
    }

    /**
     * 设置菜单名称
     *
     * @param publicMenuName 菜单名称
     */
    public void setPublicMenuName(String publicMenuName) {
        this.publicMenuName = publicMenuName;
    }

    /**
     * 获取父菜单编号
     *
     * @return PARENT_ID - 父菜单编号
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父菜单编号
     *
     * @param parentId 父菜单编号
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取方案组件菜单编号
     *
     * @return SOLUTION_MENU_ID - 方案组件菜单编号
     */
    public String getSolutionMenuId() {
        return solutionMenuId;
    }

    /**
     * 设置方案组件菜单编号
     *
     * @param solutionMenuId 方案组件菜单编号
     */
    public void setSolutionMenuId(String solutionMenuId) {
        this.solutionMenuId = solutionMenuId;
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