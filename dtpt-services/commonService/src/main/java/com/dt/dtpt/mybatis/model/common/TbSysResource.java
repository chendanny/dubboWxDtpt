package com.dt.dtpt.mybatis.model.common;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_sys_resource")
public class TbSysResource implements Serializable {
    /**
     * 资源编号
     */
    @Column(name = "RESOURCE_ID")
    private String resourceId;

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
     * 树深度
     */
    @Column(name = "LEVEL")
    private Integer level;

    /**
     * 协议
     */
    @Column(name = "LOCAL")
    private String local;

    /**
     * ip或域名地址
     */
    @Column(name = "HOST")
    private String host;

    /**
     * 端口
     */
    @Column(name = "PORT")
    private String port;

    /**
     * 路径地址
     */
    @Column(name = "URL")
    private String url;

    /**
     * 父ID
     */
    @Column(name = "PARENT_ID")
    private String parentId;

    /**
     * 状态
     */
    @Column(name = "STATE")
    private Integer state;

    /**
     * 改变状态时间
     */
    @Column(name = "STATE_DATE")
    private Date stateDate;

    /**
     * 工程名称
     */
    @Column(name = "CONTEXT")
    private String context;

    /**
     * 别名
     */
    @Column(name = "SYMBOL")
    private String symbol;

    private static final long serialVersionUID = 1L;

    /**
     * 获取资源编号
     *
     * @return RESOURCE_ID - 资源编号
     */
    public String getResourceId() {
        return resourceId;
    }

    /**
     * 设置资源编号
     *
     * @param resourceId 资源编号
     */
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
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
     * 获取树深度
     *
     * @return LEVEL - 树深度
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置树深度
     *
     * @param level 树深度
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取协议
     *
     * @return LOCAL - 协议
     */
    public String getLocal() {
        return local;
    }

    /**
     * 设置协议
     *
     * @param local 协议
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * 获取ip或域名地址
     *
     * @return HOST - ip或域名地址
     */
    public String getHost() {
        return host;
    }

    /**
     * 设置ip或域名地址
     *
     * @param host ip或域名地址
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * 获取端口
     *
     * @return PORT - 端口
     */
    public String getPort() {
        return port;
    }

    /**
     * 设置端口
     *
     * @param port 端口
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * 获取路径地址
     *
     * @return URL - 路径地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置路径地址
     *
     * @param url 路径地址
     */
    public void setUrl(String url) {
        this.url = url;
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
     * 获取改变状态时间
     *
     * @return STATE_DATE - 改变状态时间
     */
    public Date getStateDate() {
        return stateDate;
    }

    /**
     * 设置改变状态时间
     *
     * @param stateDate 改变状态时间
     */
    public void setStateDate(Date stateDate) {
        this.stateDate = stateDate;
    }

    /**
     * 获取工程名称
     *
     * @return CONTEXT - 工程名称
     */
    public String getContext() {
        return context;
    }

    /**
     * 设置工程名称
     *
     * @param context 工程名称
     */
    public void setContext(String context) {
        this.context = context;
    }

    /**
     * 获取别名
     *
     * @return SYMBOL - 别名
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * 设置别名
     *
     * @param symbol 别名
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}