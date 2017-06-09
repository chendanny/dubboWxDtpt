package com.dt.dtpt.service.publicwx.impl;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dt.dtpt.util.UUID;

import javax.ws.rs.PathParam;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dt.dtpt.mybatis.model.publicwx.WxPayConfig;
import com.dt.dtpt.mybatis.model.publicwx.WxPublic;
import com.dt.dtpt.mybatis.model.publicwx.WxUserPublic;
import com.dt.dtpt.service.impl.WxPayConfigService;
import com.dt.dtpt.service.impl.WxPublicService;
import com.dt.dtpt.service.impl.WxUserPublicService;
import com.dt.dtpt.service.publicwx.PublicwxService;
import com.dt.dtpt.util.Result;
import com.dt.dtpt.util.wx.WxUtil;
@Service
@Transactional(readOnly = true)
public class PublicwxServiceImpl implements PublicwxService {

	protected transient final Log log = LogFactory.getLog(PublicwxServiceImpl.class);
	
	public static Map<String, WxPublic> wxPublics = new HashMap<String, WxPublic>();
	public static Map<String, WxPayConfig> wxPayConfigs = new HashMap<String, WxPayConfig>();
	public static Map<String, Long> sysnTimes = new HashMap<String, Long>();
	public static final Long sysnTime = 5 * 60 * 1000l;
	
	public static Map<String,String> shTokens = new HashMap<String, String>();
	/**
	 * 商户token失效时间
	 */
	public static Map<String, Long> shTokenTimes = new HashMap<String, Long>();
	
	public static Map<String, String> shJsapiTickets = new HashMap<String, String>();
	/**
	 * 商户ticket失效时间
	 */
	public static Map<String, Long> shTicketTimes = new HashMap<String, Long>();
	public static final Long tokenTicketSynTime = 20 * 60 * 1000l;
	
	
	@Autowired
	WxPublicService wxpublicService;
	
	@Autowired
	WxUserPublicService wxuserPublicService;
	
	@Autowired
	WxPayConfigService wxPayConfigService;
	
	public String getAccessToken(String shId) {
		if(getWxPublicByShid(shId) != null){
			if(!shTokens.containsKey(shId)) reLoadAccessToken(shId);
			return shTokens.get(shId);
		}
		return null;
	}

	public String getJsapiTicket(String shId) {
		if(getWxPublicByShid(shId) != null){
			if(!shJsapiTickets.containsKey(shId)) reLoadJsapiTicket(shId);
			return shJsapiTickets.get(shId);
		}
		return null;
	}

	public void loadAccessToken() {
		WxPublic wxPublic = new WxPublic();
		List<WxPublic> twxPublics = wxpublicService.select(wxPublic);
		if(twxPublics != null){
			for(WxPublic wp : twxPublics){
				reLoadAccessToken(wp.getUserId());
			}
		}
	}

	public void loadJsapiTicket() {
		WxPublic wxPublic = new WxPublic();
		List<WxPublic> twxPublics = wxpublicService.select(wxPublic);
		if(twxPublics != null){
			for(WxPublic wp : twxPublics){
				reLoadJsapiTicket(wp.getUserId());
			}
		}
	}

	public String reLoadAccessToken(String shId) {
		try {
			WxPublic wxPublic = getWxPublicByShid(shId);
			if(wxPublic != null){
				boolean isReload = false;
				if(!shTokens.containsKey(shId)){
					isReload = true;
				}else{
					Long endTime = shTokenTimes.get(shId);
					if(endTime == null) endTime = 0l;
					if(new Date().getTime() > endTime - tokenTicketSynTime) isReload = true;
				}
				if(isReload){
					String[] tokeninfo = WxUtil.getAccessTokeninfo(null, wxPublic.getAppId(),wxPublic.getAppSecret());
					if(tokeninfo != null && tokeninfo.length > 1){
						String token = tokeninfo[0];
						Long endTime = new 	Date().getTime() + Long.valueOf(tokeninfo[1]) * 1000;
						shTokens.put(shId, null);
						shTokens.put(shId, token);
						shTokenTimes.put(shId, null);
						shTokenTimes.put(shId, endTime);
					}
				}
				return shTokens.get(shId);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String reLoadJsapiTicket(String shId) {
		try {
			if(getWxPublicByShid(shId) != null){
				boolean isReload = false;
				if(!shJsapiTickets.containsKey(shId)){
					isReload = true;
				}else{
					Long endTime = shTicketTimes.get(shId);
					if(endTime == null) endTime = 0l;
					if(new Date().getTime() > endTime - tokenTicketSynTime) isReload = true;
				}
				if(isReload){					
					String accessToken = getAccessToken(shId);
					String[] ticketinfo = WxUtil.getJsapiTicketinfo(accessToken, null);
					if(ticketinfo != null && ticketinfo.length > 1){
						String ticket = ticketinfo[0];
						Long endTime = new 	Date().getTime() + Long.valueOf(ticketinfo[1]) * 1000;
						shJsapiTickets.put(shId, null);
						shJsapiTickets.put(shId, ticket);
						shTicketTimes.put(shId, null);
						shTicketTimes.put(shId, endTime);
					}
				}
				return shJsapiTickets.get(shId);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void sysnWxPublicConfig(String shId){
		boolean isQuery = false;
		if(wxPublics.containsKey(shId)){
			Long st = sysnTimes.get(shId);
			if(new Date().getTime() - st > sysnTime) isQuery = true;
		}else{
			isQuery = true;
		}
		if(isQuery){
			WxPublic wxPublic = new WxPublic();
			wxPublic.setUserId(shId);
			List<WxPublic> twxPublics = wxpublicService.select(wxPublic);
			wxPublic  = null;
			if(twxPublics != null && twxPublics.size() > 0) wxPublic = twxPublics.get(0);
			wxPublics.put(shId, null);
			wxPublics.put(shId, wxPublic);
			WxPayConfig config = new WxPayConfig();
			config.setUserId(shId);
			List<WxPayConfig> configs = wxPayConfigService.select(config);
			config = null;
			if(configs != null && configs.size() > 0) config = configs.get(0);
			wxPayConfigs.put(shId, null);
			wxPayConfigs.put(shId, config);
			sysnTimes.put(shId, new Date().getTime());
		}
	}
	
	public WxPublic getWxPublicByShid(@PathParam("shId") String shId) {
		this.sysnWxPublicConfig(shId);
		return wxPublics.get(shId);
	}

	public Result isManerger(@PathParam("userOpenID") String userOpenID, @PathParam("shId") String shId) {
		if(userOpenID != null && !"".equals(userOpenID) && shId != null && !"".equals(shId)){
			WxPublic wxPublic = (WxPublic) this.getWxPublicByShid(shId);
			if(wxPublic != null && wxPublic.getWxOpenid() != null && wxPublic.getWxOpenid().contains(userOpenID)){
				return Result.success();
			}else{
				return Result.failure("操作用户账号非该商户管理员账号");
			}
		}else{
			return Result.failure("参数校验失败", "商户的编号或用户微信账号为空");
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Result attentionPublic(WxUserPublic wxUserPublic, @PathParam("shId") String shId) {
		log.error("=====0============");
		if(shId != null && !"".equals(shId) && wxUserPublic != null && wxUserPublic.getWxOpenid() != null 
				&& !"".equals(wxUserPublic.getWxOpenid())){
			WxPublic wxPublic = new WxPublic();
			wxPublic.setUserId(shId);
			List<WxPublic> wxPublics = wxpublicService.select(wxPublic);
			wxPublic  = null;
			String res = "";
			log.error("=====1============");
			if(wxPublics != null && wxPublics.size() > 0){
				wxPublic = wxPublics.get(0);
				WxUserPublic wup = new WxUserPublic();
				wup.setPublicId(wxPublic.getPublicId());
				wup.setWxOpenid(wxUserPublic.getWxOpenid());
				log.error("=====2============");
				wup = wxuserPublicService.selectOne(wup);
				Date date = new Date();
				wxUserPublic.setAddDate(date);
				wxUserPublic.setPublicId(wxPublic.getPublicId());
				int rs = 0;
				if(wup != null){
					log.error("=====3============");
					wxUserPublic.setUserPwxId(wup.getUserPwxId());
					rs = wxuserPublicService.updateAll(wxUserPublic);
				}else{
					log.error("=====4============");
					wxUserPublic.setUserPwxId(UUID.randomUUID().toString());
					rs = wxuserPublicService.save(wxUserPublic);
				}
				log.error("=====5============");
				if(rs > 0) return Result.success();
				res = "更新数据库失败";
			}else{
				res = "未查找到对应公众号信息";
			} 
			log.error("=====6============");
			return Result.failure("关注失败",res);
		}else{
			log.error("=====7============");
			return Result.failure("参数校验失败", "商户编号或用户微信openID为空");
		}
	}

	public WxPayConfig payInfo(String shId) {
		this.sysnWxPublicConfig(shId);
		return wxPayConfigs.get(shId);
	}

	public void setWxpublicService(WxPublicService wxpublicService) {
		this.wxpublicService = wxpublicService;
	}

	public void setWxuserPublicService(WxUserPublicService wxuserPublicService) {
		this.wxuserPublicService = wxuserPublicService;
	}

	public PublicwxServiceImpl() {
		super();
	}

	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString());
	}
}
