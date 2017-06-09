package com.dt.dtpt.mybatis.model.common;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_sys_exception")
public class TbSysException implements Serializable {
    /**
     * 异常编号
     */
    @Column(name = "EXCPTION_ID")
    private String excptionId;

    /**
     * 调用方法
     */
    @Column(name = "FUNC")
    private String func;

    /**
     * 调用参数
     */
    @Column(name = "PARAMS")
    private String params;

    /**
     * 长参数
     */
    @Column(name = "DATA")
    private String data;

    /**
     * 调用时间
     */
    @Column(name = "CALL_TIME")
    private Date callTime;

    /**
     * 堆跟踪信息
     */
    @Column(name = "STACK_TRACE")
    private String stackTrace;

    /**
     * 执行sql
     */
    @Column(name = "EXE_SQL")
    private String exeSql;

    private static final long serialVersionUID = 1L;

    /**
     * 获取异常编号
     *
     * @return EXCPTION_ID - 异常编号
     */
    public String getExcptionId() {
        return excptionId;
    }

    /**
     * 设置异常编号
     *
     * @param excptionId 异常编号
     */
    public void setExcptionId(String excptionId) {
        this.excptionId = excptionId;
    }

    /**
     * 获取调用方法
     *
     * @return FUNC - 调用方法
     */
    public String getFunc() {
        return func;
    }

    /**
     * 设置调用方法
     *
     * @param func 调用方法
     */
    public void setFunc(String func) {
        this.func = func;
    }

    /**
     * 获取调用参数
     *
     * @return PARAMS - 调用参数
     */
    public String getParams() {
        return params;
    }

    /**
     * 设置调用参数
     *
     * @param params 调用参数
     */
    public void setParams(String params) {
        this.params = params;
    }

    /**
     * 获取长参数
     *
     * @return DATA - 长参数
     */
    public String getData() {
        return data;
    }

    /**
     * 设置长参数
     *
     * @param data 长参数
     */
    public void setData(String data) {
        this.data = data;
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
     * 获取堆跟踪信息
     *
     * @return STACK_TRACE - 堆跟踪信息
     */
    public String getStackTrace() {
        return stackTrace;
    }

    /**
     * 设置堆跟踪信息
     *
     * @param stackTrace 堆跟踪信息
     */
    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    /**
     * 获取执行sql
     *
     * @return EXE_SQL - 执行sql
     */
    public String getExeSql() {
        return exeSql;
    }

    /**
     * 设置执行sql
     *
     * @param exeSql 执行sql
     */
    public void setExeSql(String exeSql) {
        this.exeSql = exeSql;
    }
}