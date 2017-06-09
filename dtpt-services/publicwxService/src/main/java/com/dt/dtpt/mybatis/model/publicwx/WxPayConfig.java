package com.dt.dtpt.mybatis.model.publicwx;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "wx_pay_config")
public class WxPayConfig implements Serializable {
    @Id
    @Column(name = "WX_PAY_CID")
    private String wxPayCid;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "PUBLIC_ID")
    private String publicId;

    @Column(name = "WXFW_ID")
    private String wxfwId;

    @Column(name = "APP_ID")
    private String appId;

    /**
     * 0收款配置
            1出款配置
            
            收款配置对应支付方式中接口
            出款配置对应支付工具中接口
            默认为0
     */
    @Column(name = "CONFIG_TYPE")
    private Integer configType;

    /**
     * 0刷卡支付
            1公众号支付
            2扫码支付
            3APP支付
            
     */
    @Column(name = "PAY_TYPE")
    private Integer payType;

    /**
     * 0代金券或立减优惠
            1现金红包
            2企业付款
     */
    @Column(name = "PAY_TOOL")
    private Integer payTool;

    @Column(name = "MCH_ID")
    private String mchId;

    @Column(name = "PAY_ACCOUNT")
    private String payAccount;

    @Column(name = "PASS_W")
    private String passW;

    /**
     * 参考微信接口中的银行类型
     */
    @Column(name = "BANK_TYPE")
    private String bankType;

    @Column(name = "BANK_NAME")
    private String bankName;

    @Column(name = "BANK_NO")
    private String bankNo;

    @Column(name = "BANK_OWNER")
    private String bankOwner;

    @Column(name = "BANK_OWNER_PHONE")
    private String bankOwnerPhone;

    /**
     * 0否
            1是
     */
    @Column(name = "IS_PROXY_APPL")
    private Integer isProxyAppl;

    /**
     * 0审核未通过
            1正常可用
            2异常不可用
     */
    @Column(name = "C_STATE")
    private Integer cState;

    @Column(name = "SH_KEY")
    private String shKey;

    /**
     * 1MD5
     */
    @Column(name = "SIGN_TYPE")
    private Integer signType;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "EDIT_DATE")
    private Date editDate;

    private static final long serialVersionUID = 1L;

    /**
     * @return WX_PAY_CID
     */
    public String getWxPayCid() {
        return wxPayCid;
    }

    /**
     * @param wxPayCid
     */
    public void setWxPayCid(String wxPayCid) {
        this.wxPayCid = wxPayCid;
    }

    /**
     * @return USER_ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
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
     * @return WXFW_ID
     */
    public String getWxfwId() {
        return wxfwId;
    }

    /**
     * @param wxfwId
     */
    public void setWxfwId(String wxfwId) {
        this.wxfwId = wxfwId;
    }

    /**
     * @return APP_ID
     */
    public String getAppId() {
        return appId;
    }

    /**
     * @param appId
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * 获取0收款配置
            1出款配置
            
            收款配置对应支付方式中接口
            出款配置对应支付工具中接口
            默认为0
     *
     * @return CONFIG_TYPE - 0收款配置
            1出款配置
            
            收款配置对应支付方式中接口
            出款配置对应支付工具中接口
            默认为0
     */
    public Integer getConfigType() {
        return configType;
    }

    /**
     * 设置0收款配置
            1出款配置
            
            收款配置对应支付方式中接口
            出款配置对应支付工具中接口
            默认为0
     *
     * @param configType 0收款配置
            1出款配置
            
            收款配置对应支付方式中接口
            出款配置对应支付工具中接口
            默认为0
     */
    public void setConfigType(Integer configType) {
        this.configType = configType;
    }

    /**
     * 获取0刷卡支付
            1公众号支付
            2扫码支付
            3APP支付
            
     *
     * @return PAY_TYPE - 0刷卡支付
            1公众号支付
            2扫码支付
            3APP支付
            
     */
    public Integer getPayType() {
        return payType;
    }

    /**
     * 设置0刷卡支付
            1公众号支付
            2扫码支付
            3APP支付
            
     *
     * @param payType 0刷卡支付
            1公众号支付
            2扫码支付
            3APP支付
            
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /**
     * 获取0代金券或立减优惠
            1现金红包
            2企业付款
     *
     * @return PAY_TOOL - 0代金券或立减优惠
            1现金红包
            2企业付款
     */
    public Integer getPayTool() {
        return payTool;
    }

    /**
     * 设置0代金券或立减优惠
            1现金红包
            2企业付款
     *
     * @param payTool 0代金券或立减优惠
            1现金红包
            2企业付款
     */
    public void setPayTool(Integer payTool) {
        this.payTool = payTool;
    }

    /**
     * @return MCH_ID
     */
    public String getMchId() {
        return mchId;
    }

    /**
     * @param mchId
     */
    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    /**
     * @return PAY_ACCOUNT
     */
    public String getPayAccount() {
        return payAccount;
    }

    /**
     * @param payAccount
     */
    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    /**
     * @return PASS_W
     */
    public String getPassW() {
        return passW;
    }

    /**
     * @param passW
     */
    public void setPassW(String passW) {
        this.passW = passW;
    }

    /**
     * 获取参考微信接口中的银行类型
     *
     * @return BANK_TYPE - 参考微信接口中的银行类型
     */
    public String getBankType() {
        return bankType;
    }

    /**
     * 设置参考微信接口中的银行类型
     *
     * @param bankType 参考微信接口中的银行类型
     */
    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    /**
     * @return BANK_NAME
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * @param bankName
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * @return BANK_NO
     */
    public String getBankNo() {
        return bankNo;
    }

    /**
     * @param bankNo
     */
    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    /**
     * @return BANK_OWNER
     */
    public String getBankOwner() {
        return bankOwner;
    }

    /**
     * @param bankOwner
     */
    public void setBankOwner(String bankOwner) {
        this.bankOwner = bankOwner;
    }

    /**
     * @return BANK_OWNER_PHONE
     */
    public String getBankOwnerPhone() {
        return bankOwnerPhone;
    }

    /**
     * @param bankOwnerPhone
     */
    public void setBankOwnerPhone(String bankOwnerPhone) {
        this.bankOwnerPhone = bankOwnerPhone;
    }

    /**
     * 获取0否
            1是
     *
     * @return IS_PROXY_APPL - 0否
            1是
     */
    public Integer getIsProxyAppl() {
        return isProxyAppl;
    }

    /**
     * 设置0否
            1是
     *
     * @param isProxyAppl 0否
            1是
     */
    public void setIsProxyAppl(Integer isProxyAppl) {
        this.isProxyAppl = isProxyAppl;
    }

    /**
     * 获取0审核未通过
            1正常可用
            2异常不可用
     *
     * @return C_STATE - 0审核未通过
            1正常可用
            2异常不可用
     */
    public Integer getcState() {
        return cState;
    }

    /**
     * 设置0审核未通过
            1正常可用
            2异常不可用
     *
     * @param cState 0审核未通过
            1正常可用
            2异常不可用
     */
    public void setcState(Integer cState) {
        this.cState = cState;
    }

    /**
     * @return SH_KEY
     */
    public String getShKey() {
        return shKey;
    }

    /**
     * @param shKey
     */
    public void setShKey(String shKey) {
        this.shKey = shKey;
    }

    /**
     * 获取1MD5
     *
     * @return SIGN_TYPE - 1MD5
     */
    public Integer getSignType() {
        return signType;
    }

    /**
     * 设置1MD5
     *
     * @param signType 1MD5
     */
    public void setSignType(Integer signType) {
        this.signType = signType;
    }

    /**
     * @return CREATE_DATE
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
}