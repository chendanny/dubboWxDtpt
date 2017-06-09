package com.dt.dtpt.util.wx;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WxPay {

	private final static Logger logger = LoggerFactory.getLogger(WxPay.class);
	/**
	 * 微信订单查询接口地址
	 */
	public static final String ORDER_QUERY_URL = "https://api.mch.weixin.qq.com/pay/orderquery";
	public static final String TRADE_SUCCESS = "<trade_state><![CDATA[SUCCESS]]></trade_state>";
	
	
	/**
	 * 检测客户订单是否支付成功
	 * @param appid 应用APPID
	 * @param mch_id 微信支付商户号
	 * @param out_trade_no 客户订单号
	 * @param signKey 签名key
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static Boolean isPaySuccess(String appid,String mch_id,String out_trade_no,String signKey) throws ClientProtocolException, IOException{
		String orderInfo = queryWxOrder(appid, mch_id, out_trade_no, signKey);
		boolean rs = false;
		if(orderInfo != null && orderInfo.contains(TRADE_SUCCESS)) rs = true;
		return rs;
	}
	
	/**
	 * 查询微信订单下单情况
	 * @param appid 应用APPID
	 * @param mch_id 微信支付商户号
	 * @param out_trade_no 客户订单号
	 * @param signKey 签名key
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String queryWxOrder(String appid,String mch_id,String out_trade_no,String signKey) throws ClientProtocolException, IOException{
		String rs = null;
		if(appid == null || "".equals(appid)){
			logger.error("				appid为空");
			return rs;
		}
		if(mch_id == null || "".equals(mch_id)){
			logger.error("				mch_id为空");
			return rs;
		}
		if(out_trade_no == null || "".equals(out_trade_no)){
			logger.error("				out_trade_no为空");
			return rs;
		}
		if(signKey == null || "".equals(signKey)){
			logger.error("				signKey为空");
			return rs;
		}
		WxOrderqueryData data = new WxOrderqueryData(appid, mch_id, out_trade_no, WxUtil.getNonceStr(), null);
		WxUtil.signForOrderquery(data, signKey);
		rs = WxUtil.executeUrl(data, ORDER_QUERY_URL, WxOrderqueryData.class);
		return rs;
	}
	
	public static void main(String[] args) {
		try {
			if(isPaySuccess("wxa76644985975ad93","1340470301","bcf38ad6294b4640843b417cabad6ab8","fjxchdxcj258duotaikeji20151229dt")) System.out.println("=============");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
