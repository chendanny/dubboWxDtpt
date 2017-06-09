package com.dt.dtpt.util.wx;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dt.dtpt.util.HttpClientUtil;
import com.dt.dtpt.util.MD5Util;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

public class WxUtil {
	private final static Logger logger = LoggerFactory.getLogger(WxUtil.class);
	private static String characterEncoding = "UTF-8";

	public final static String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	public final static String TOKEN_KEY_GRANT_TYPE = "client_credential";
	public final static String TOKEN_KEY_APP_ID = "APPID";
	public final static String TOKEN_KEY_APP_SECRET = "APPSECRET";
	public final static String TOKEN_KEY_GRANT_TYPE_DEF = "client_credential";
	public final static String TOKEN_SUCCESS_KEY = "access_token";
	public final static String TOKEN_SUCCESS_EXPIRES = "expires_in";
	
	public final static String TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
	public final static String TICKET_KEY_ACCESS_TOKEN = "ACCESS_TOKEN";
	public final static String TICKET_KEY_TYPE = "jsapi";
	public final static String TICKET_KEY_TYPE_DEF = "jsapi";
	public final static String TICKET_SUCCESS_KEY = "errcode:0,errmsg:ok,";
	public final static String TICKET_SUCCESS_TICKET = "ticket";
	public final static String TICKET_SUCCESS_EXPIRES= "expires_in";
	
	
	/**
	 * 执行获取ticket接口,正常情况返回数组[0]为ticket、数组[1]为有效时间,异常情况返回null
	 * @param accessToken 微信访问token
	 * @param type ticket类型，默认为jsapi
	 * @return
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static String[] getJsapiTicketinfo(String accessToken,String type) throws ClientProtocolException, IOException{
		String[] rs = null;
		logger.info("		getJsapiTicketinfo参数: 		accessToken="+accessToken);
		if(accessToken != null && !"".equals(accessToken)){			
			String url = TICKET_URL;
			url = url.replace(TICKET_KEY_ACCESS_TOKEN, accessToken);
			url = url.replace(TICKET_KEY_TYPE, type != null && !"".equals(type)?type:TICKET_KEY_TYPE_DEF);
			String json = HttpClientUtil.getJson(url);
			if(json != null){
				json = json.trim().replaceAll("\"", "");
				if(json.contains(TICKET_SUCCESS_KEY)){
					json = json.replace(TICKET_SUCCESS_KEY, "");
					json = json.replaceAll("\\{", "");
					json = json.replaceAll("\\}", "");
					json = json.replaceAll(":", "");
					json = json.replaceAll(TICKET_SUCCESS_TICKET, "");
					json = json.replaceAll(TICKET_SUCCESS_EXPIRES, "");
					rs = json.split(",");
					logger.info("      getJsapiTicketinfo:"+json);
				}
			}
		}else{
			logger.error("		getJsapiTicketinfo参数校验失败: 		accessToken="+accessToken);
		}
		return rs;
	}
	
	/**
	 * 执行获取token接口,正常情况返回数组[0]为token、数组[1]为有效时间,异常情况返回null
	 * @param grant_type 请求类型，不填默认为client_credential
	 * @param appid 微信用户唯一凭证
	 * @param secret 微信用户唯一凭证密钥
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String[] getAccessTokeninfo(String grant_type,String appid,String secret) throws ClientProtocolException, IOException{
		logger.error("		getAccessTokeninfo参数: 		appid="+appid + "	secret="+secret);
		String[] rs = null;
		if(appid != null && !"".equals(appid) && secret != null && !"".equals(secret)){			
			String url = TOKEN_URL;
			url = url.replace(TOKEN_KEY_GRANT_TYPE, grant_type==null || "".equals(grant_type)?TOKEN_KEY_GRANT_TYPE_DEF:grant_type);
			url = url.replace(TOKEN_KEY_APP_ID, appid);
			url = url.replace(TOKEN_KEY_APP_SECRET, secret);
			String json = HttpClientUtil.getJson(url);
			if(json != null && json.contains(TOKEN_SUCCESS_KEY)){
				//{"access_token":"ACCESS_TOKEN","expires_in":7200}
				json = json.trim().replaceAll("\"", "");
				json = json.replaceAll("\\{", "");
				json = json.replaceAll("\\}", "");
				json = json.replaceAll(":", "");
				json = json.replaceAll(TOKEN_SUCCESS_KEY, "");
				json = json.replaceAll(TOKEN_SUCCESS_EXPIRES, "");
				rs = json.split(",");
				logger.info("      getAccessTokeninfo:"+json);
			}
		}else{
			logger.error("		getAccessTokeninfo参数校验失败: 		appid="+appid + "	secret="+secret);
		}
		return rs;
	}
	
	/**
	 * 执行接口，执行结果转为字符串返回
	 * @param data 请求数据
	 * @param url 请求地址
	 * @param dataClazz 数据类
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String executeUrl(WxData data,String url,@SuppressWarnings("rawtypes") Class dataClazz) throws ClientProtocolException, IOException{
		XStream xs = new XStream(new DomDriver("UTF-8",
				new XmlFriendlyNameCoder("-_", "_")));
		xs.alias("xml", dataClazz);
		String xml = xs.toXML(data);
		return HttpClientUtil.postXml(url, xml);
	}
	
	/**
	 * 给查询订单请求数据签名，并将签名串赋值给请求数据
	 * @param data 请求数据
	 * @param key 签名Key
	 */
	public static void signForOrderquery(WxOrderqueryData data,String key){
		if(data != null){
			SortedMap<Object,Object> parameters = new TreeMap<Object,Object>();
			parameters.put(WxConstants.APPID, data.getAppid());
			parameters.put(WxConstants.MCH_ID, data.getMch_id());
			parameters.put(WxConstants.OUT_TRADE_NO, data.getOut_trade_no());
			parameters.put(WxConstants.NONCE_STR, data.getNonce_str());
			data.setSign(createSign(parameters,key));
		}
	} 
	
	/**
	 * 参数列表签名，并返回签名串
	 * @param parameters 参数集合
	 * @param key 签名key
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String createSign(SortedMap<Object, Object> parameters,
			String key) {
		logger.info("=============组织签名               start =============");
		StringBuffer sb = new StringBuffer();
		Set es = parameters.entrySet();// 所有参与传参的参数按照accsii排序（升序）
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			Object v = entry.getValue();
			if (null != v && !"".equals(v) && !"sign".equals(k)
					&& !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=" + key);
		logger.info("=============签名参数:"+sb.toString());
		String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding)
				.toUpperCase();
		logger.info("=============签名结果:"+sign);
		logger.info("=============组织签名                  end =============");
		return sign;
	}

	/**
	 * 获得加密后的随机串
	 * @return
	 */
	public static String getNonceStr() {
		Random random = new Random();
		return MD5Util.MD5Encode(String.valueOf(random.nextInt(10000)),
				characterEncoding);
	}
	
	public static void main(String[] args) {
		try {
			String[] rs = getAccessTokeninfo(null,"wxa76644985975ad93","0593f2832c6892d5562e607325008c0c");
			if(rs != null){
				System.out.println(rs[0]);
				rs = getJsapiTicketinfo(rs[0], null);
				if(rs != null) System.out.println(rs[0]);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
