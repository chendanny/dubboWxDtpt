package com.dt.dtpt.util.wx;

public class WxOrderqueryData extends WxData{
	/**
	 * 应用APPID
	 */
	private String appid;
	/**
	 * 微信支付商户号
	 */
	private String mch_id;
	/**
	 * 客户订单号
	 */
	private String out_trade_no;
	/**
	 * 随即字符串
	 */
	private String nonce_str;
	/**
	 * 签名串
	 */
	private String sign;
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public WxOrderqueryData(String appid, String mch_id, String out_trade_no,
			String nonce_str, String sign) {
		super();
		this.appid = appid;
		this.mch_id = mch_id;
		this.out_trade_no = out_trade_no;
		this.nonce_str = nonce_str;
		this.sign = sign;
	}
	
}
