package com.dt.dtpt.util;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xiaochj
 * 
 */
public class HttpClientUtil {

	private final static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
	public static final String DEF_CHARSET = "UTF-8";
	
	/**
	 * 远程访问Http请求，返回json数据
	 * @param httpClient httpClient对象，针对不同业务，可以传递不同的实例，比如多线程并发访问、单线程访问
	 * @param url 请求的url地址
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String getJson(HttpClient httpClient,String url) throws ClientProtocolException, IOException{
		logger.info("================ http请求                 start ==================");
		logger.info("================     URL:"+url);
		HttpGet httpGet = new HttpGet(url);
		httpGet.addHeader("Content-Type", "text/json"); 
        HttpResponse response = httpClient.execute(httpGet); 
        String rs = EntityUtils.toString(response.getEntity());
        logger.info("================  RETURN:"+rs);
        logger.info("================ http请求                    end ==================");
        return  rs;
	}
	
	/**
	 * 远程访问Http请求，返回json数据
	 * @param url 请求的url地址
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String getJson(String url) throws ClientProtocolException, IOException{
		HttpClient httpClient = new DefaultHttpClient(); 
		return  getJson(httpClient, url);
	}
	
	/**
	 * 远程访问Http请求，传递xml数据，返回请求结果
	 * @param httpClient httpClient对象，针对不同业务，可以传递不同的实例，比如多线程并发访问、单线程访问
	 * @param url 请求的url地址
	 * @param xmlStr 传递的xml字符串
	 * @param charSet 数据编码
	 * @return 返回请求结果
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String postXml(HttpClient httpClient,String url,String xmlStr,String charSet) throws ClientProtocolException, IOException{
		logger.info("================ http请求                 start ==================");
		logger.info("================ CHARSET:"+xmlStr);
		logger.info("================     URL:"+url);
		logger.info("================     XML:"+xmlStr);
		HttpPost httppost = new HttpPost(url); 
        StringEntity myEntity = new StringEntity(xmlStr, charSet != null && !"".equals(charSet)?charSet:DEF_CHARSET); 
        httppost.addHeader("Content-Type", "text/xml"); 
        httppost.setEntity(myEntity); 
        HttpResponse response = httpClient.execute(httppost); 
        String rs = EntityUtils.toString(response.getEntity());
        logger.info("================  RETURN:"+rs);
        logger.info("================ http请求                    end ==================");
        return  rs;
	}
	
	/**
	 * 远程访问Http请求，传递xml数据，返回请求结果
	 * @param url 请求的url地址
	 * @param xmlStr 传递的xml字符串
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String postXml(String url,String xmlStr) throws ClientProtocolException, IOException{
        HttpClient httpclient = new DefaultHttpClient(); 
		String rs = postXml(httpclient,url, xmlStr,null);
		httpclient.getConnectionManager().shutdown();
		return rs;
	}
	public static void main(String[] args) {
		try {
			System.out.println("====="+getJson("http://120.76.152.25:7888/services/publicwx/12345/getAccessToken"));
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
