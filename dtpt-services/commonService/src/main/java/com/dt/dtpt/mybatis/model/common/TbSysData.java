package com.dt.dtpt.mybatis.model.common;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_sys_data")
public class TbSysData implements Serializable {
    /**
     * 编号
     */
    @Column(name = "DATA_ID")
    private String dataId;

    /**
     * 名称
     */
    @Column(name = "DATA_NAME")
    private String dataName;

    /**
     * 编码
     */
    @Column(name = "DATA_CODE")
    private String dataCode;

    /**
     * 父编号
     */
    @Column(name = "DATA_PID")
    private String dataPid;

    /**
     * 排序
     */
    @Column(name = "DATA_XH")
    private Integer dataXh;

    /**
     * 备注
     */
    @Column(name = "COMMON")
    private String common;

    private static final long serialVersionUID = 1L;

    /**
     * 获取编号
     *
     * @return DATA_ID - 编号
     */
    public String getDataId() {
        return dataId;
    }

    /**
     * 设置编号
     *
     * @param dataId 编号
     */
    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    /**
     * 获取名称
     *
     * @return DATA_NAME - 名称
     */
    public String getDataName() {
        return dataName;
    }

    /**
     * 设置名称
     *
     * @param dataName 名称
     */
    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    /**
     * 获取编码
     *
     * @return DATA_CODE - 编码
     */
    public String getDataCode() {
        return dataCode;
    }

    /**
     * 设置编码
     *
     * @param dataCode 编码
     */
    public void setDataCode(String dataCode) {
        this.dataCode = dataCode;
    }

    /**
     * 获取父编号
     *
     * @return DATA_PID - 父编号
     */
    public String getDataPid() {
        return dataPid;
    }

    /**
     * 设置父编号
     *
     * @param dataPid 父编号
     */
    public void setDataPid(String dataPid) {
        this.dataPid = dataPid;
    }

    /**
     * 获取排序
     *
     * @return DATA_XH - 排序
     */
    public Integer getDataXh() {
        return dataXh;
    }

    /**
     * 设置排序
     *
     * @param dataXh 排序
     */
    public void setDataXh(Integer dataXh) {
        this.dataXh = dataXh;
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