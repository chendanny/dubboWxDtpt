package com.dt.dtpt.mybatis.model.common;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wx_menu_public")
public class WxMenuPublic implements Serializable {
    @Id
    @Column(name = "PUBLIC_MENU_ID")
    private String publicMenuId;

    @Column(name = "PUBLIC_ID")
    private String publicId;

    @Column(name = "PUBLIC_MENU_NAME")
    private String publicMenuName;

    @Column(name = "PARENT_ID")
    private String parentId;

    @Column(name = "SOLUTION_MENU_ID")
    private String solutionMenuId;

    @Column(name = "MENU_TYPE")
    private Integer menuType;

    @Column(name = "MENU_XH")
    private Integer menuXh;

    @Column(name = "EDIT_DATE")
    private Date editDate;

    @Column(name = "COMMON")
    private String common;

    private static final long serialVersionUID = 1L;

    /**
     * @return PUBLIC_MENU_ID
     */
    public String getPublicMenuId() {
        return publicMenuId;
    }

    /**
     * @param publicMenuId
     */
    public void setPublicMenuId(String publicMenuId) {
        this.publicMenuId = publicMenuId;
    }

    /**
     * @return PUBLIC_ID
     */
    public String getPublicId() {
        return publicId;
    }

    /**
     * @param publicId
     */
    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    /**
     * @return PUBLIC_MENU_NAME
     */
    public String getPublicMenuName() {
        return publicMenuName;
    }

    /**
     * @param publicMenuName
     */
    public void setPublicMenuName(String publicMenuName) {
        this.publicMenuName = publicMenuName;
    }

    /**
     * @return PARENT_ID
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * @return SOLUTION_MENU_ID
     */
    public String getSolutionMenuId() {
        return solutionMenuId;
    }

    /**
     * @param solutionMenuId
     */
    public void setSolutionMenuId(String solutionMenuId) {
        this.solutionMenuId = solutionMenuId;
    }

    /**
     * @return MENU_TYPE
     */
    public Integer getMenuType() {
        return menuType;
    }

    /**
     * @param menuType
     */
    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    /**
     * @return MENU_XH
     */
    public Integer getMenuXh() {
        return menuXh;
    }

    /**
     * @param menuXh
     */
    public void setMenuXh(Integer menuXh) {
        this.menuXh = menuXh;
    }

    /**
     * @return EDIT_DATE
     */
    public Date getEditDate() {
        return editDate;
    }

    /**
     * @param editDate
     */
    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    /**
     * @return COMMON
     */
    public String getCommon() {
        return common;
    }

    /**
     * @param common
     */
    public void setCommon(String common) {
        this.common = common;
    }
}