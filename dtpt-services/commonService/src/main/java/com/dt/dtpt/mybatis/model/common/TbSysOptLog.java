package com.dt.dtpt.mybatis.model.common;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_sys_opt_log")
public class TbSysOptLog implements Serializable {
    /**
     * 日志编号
     */
    @Column(name = "LOG_ID")
    private String logId;

    /**
     * 操作用户ID
     */
    @Column(name = "USER_ID")
    private String userId;

    /**
     * 操作用户名
     */
    @Column(name = "USER_NAME")
    private String userName;

    /**
     * 操作方法
     */
    @Column(name = "FUNC")
    private String func;

    /**
     * 操作参数
     */
    @Column(name = "PARAMS")
    private String params;

    /**
     * 调用时间
     */
    @Column(name = "CALL_TIME")
    private Date callTime;

    /**
     * 耗时
     */
    @Column(name = "COST_TIME")
    private Integer costTime;

    /**
     * 调用sql
     */
    @Column(name = "EXE_SQL")
    private String exeSql;

    private static final long serialVersionUID = 1L;

    /**
     * 获取日志编号
     *
     * @return LOG_ID - 日志编号
     */
    public String getLogId() {
        return logId;
    }

    /**
     * 设置日志编号
     *
     * @param logId 日志编号
     */
    public void setLogId(String logId) {
        this.logId = logId;
    }

    /**
     * 获取操作用户ID
     *
     * @return USER_ID - 操作用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置操作用户ID
     *
     * @param userId 操作用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取操作用户名
     *
     * @return USER_NAME - 操作用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置操作用户名
     *
     * @param userName 操作用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取操作方法
     *
     * @return FUNC - 操作方法
     */
    public String getFunc() {
        return func;
    }

    /**
     * 设置操作方法
     *
     * @param func 操作方法
     */
    public void setFunc(String func) {
        this.func = func;
    }

    /**
     * 获取操作参数
     *
     * @return PARAMS - 操作参数
     */
    public String getParams() {
        return params;
    }

    /**
     * 设置操作参数
     *
     * @param params 操作参数
     */
    public void setParams(String params) {
        this.params = params;
    }

    /**
     * 获取调用时间
     *
     * @return CALL_TIME - 调用时间
     */
    public Date getCallTime() {
        return callTime;
    }

    /**
     * 设置调用时间
     *
     * @param callTime 调用时间
     */
    public void setCallTime(Date callTime) {
        this.callTime = callTime;
    }

    /**
     * 获取耗时
     *
     * @return COST_TIME - 耗时
     */
    public Integer getCostTime() {
        return costTime;
    }

    /**
     * 设置耗时
     *
     * @param costTime 耗时
     */
    public void setCostTime(Integer costTime) {
        this.costTime = costTime;
    }

    /**
     * 获取调用sql
     *
     * @return EXE_SQL - 调用sql
     */
    public String getExeSql() {
        return exeSql;
    }

    /**
     * 设置调用sql
     *
     * @param exeSql 调用sql
     */
    public void setExeSql(String exeSql) {
        this.exeSql = exeSql;
    }
}