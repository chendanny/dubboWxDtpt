package com.dt.dtpt.service.publicwx;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dt.dtpt.mybatis.model.publicwx.WxPayConfig;
import com.dt.dtpt.mybatis.model.publicwx.WxPublic;
import com.dt.dtpt.mybatis.model.publicwx.WxUserPublic;
import com.dt.dtpt.util.Result;
/**
 * 当前生产服务器IP:120.76.152.25
 * 当前生产服务器端口(PORT):8888
 * 当前测试服务器IP:120.76.152.25
 * 当前测试服务器端口(PORT):7888
 * @author Administrator
 *
 */
@Service
@Path("/publicwx")
@Consumes({"application/json; charset=UTF-8", "text/xml; charset=UTF-8"})
@Produces({"application/json; charset=UTF-8", "text/xml; charset=UTF-8"})
public interface PublicwxService {

	/**
	 * 获取商户的access_token
	 * <br/>runAdress:http://{IP}:{PORT}/services/publicwx/{shId}/getAccessToken
	 * <br/>example:{@link http://120.76.152.25:7888/services/publicwx/9055be7a45a5425da1c44b2e2126411a/getAccessToken}
	 * @param shId 商户编号
	 * @return
	 */
	@GET
	@Path("/{shId}/getAccessToken")
	public String getAccessToken(@PathParam("shId") String shId);
	
	/**
	 * 获取商户的jsapi_ticket
	 * <br/>runAdress:http://{IP}:{PORT}/services/publicwx/{shId}/getJsapiTicket
	 * <br/>example:{@link http://120.76.152.25:7888/services/publicwx/9055be7a45a5425da1c44b2e2126411a/getJsapiTicket}
	 * @param shId 商户编号
	 * @return
	 */
	@GET
	@Path("/{shId}/getJsapiTicket")
	public String getJsapiTicket(@PathParam("shId") String shId);
	
	/**
	 * 加载所有商户的全局access_token，面向任务
	 * <br/>runAdress:http://{IP}:{PORT}/services/publicwx/loadAccessToken
	 * <br/>example:{@link http://120.76.152.25:7888/services/publicwx/loadAccessToken}
	 * 当token不存在或者有效时间低于20分钟时，重新加载token
	 */
	@GET
	@Path("/loadAccessToken")
	public void loadAccessToken();
	
	/**
	 * 加载所有商户的jsapi_ticket，面向任务
	 * <br/>runAdress:http://{IP}:{PORT}/services/publicwx/loadJsapiTicket
	 * <br/>example:{@link http://120.76.152.25:7888/services/publicwx/loadJsapiTicket}
	 * 当ticket不存在或者有效时间低于20分钟时，重新加载ticket
	 */
	@GET
	@Path("/loadJsapiTicket")
	public void loadJsapiTicket();
	
	/**
	 * 重新加载指定商户的access_token
	 * 当token不存在或者有效时间低于20分钟时，重新加载token
	 * <br/>runAdress:http://{IP}:{PORT}/services/publicwx/{shId}/reLoadAccessToken
	 * <br/>example:{@link http://120.76.152.25:7888/services/publicwx/9055be7a45a5425da1c44b2e2126411a/reLoadAccessToken}
	 * @param shId 商户编号
	 * @return
	 */
	@GET
	@Path("/{shId}/reLoadAccessToken")
	public String reLoadAccessToken(@PathParam("shId") String shId);
	
	/**
	 * 重新加载指定商户的jsapi_ticket
	 * 当ticket不存在或者有效时间低于20分钟时，重新加载ticket
	 * <br/>runAdress:http://{IP}:{PORT}/services/publicwx/{shId}/reLoadJsapiTicket
	 * <br/>example:{@link http://120.76.152.25:7888/services/publicwx/9055be7a45a5425da1c44b2e2126411a/reLoadJsapiTicket}
	 * @param shId 商户编号
	 * @return
	 */
	@GET
	@Path("/{shId}/reLoadJsapiTicket")
	public String reLoadJsapiTicket(@PathParam("shId") String shId);
	
	/**
	 * 根据商户编号获取公众号信息
	 * <br/>runAdress:http://{IP}:{PORT}/services/publicwx/{shId}
	 * <br/>example:{@link http://120.76.152.25:7888/services/publicwx/9055be7a45a5425da1c44b2e2126411a}
	 * @param shId 商户的用户编号，不能为空
	 * @return 返回WxPublic对象
	 */
	@GET
	@Path("/{shId}")
	public WxPublic getWxPublicByShid(@PathParam("shId") String shId);
	
	/**
	 * 判断用户是否为商户管理员
	 * <br/>runAdress:http://{IP}:{PORT}/services/publicwx/{shId}/isManerger/{userOpenID}
	 * <br/>example:{@link http://120.76.152.25:7888/services/publicwx/9055be7a45a5425da1c44b2e2126411a/isManerger/oUDNMwBwAOoiYp0JrqHOx6BFiupo}
	 * @param userOpenID 用户微信OPENID，不能为空
	 * @param shId 商户的用户编号，不能为空
	 * @return 是则返回对象的success属性值为true,否则为false
	 */
	@GET
	@Path("/{shId}/isManerger/{userOpenID}")
	public Result isManerger(@PathParam("userOpenID") String userOpenID, @PathParam("shId") String shId);
	
	/**
	 * 用户关注公众号
	 * <br/>runAdress:http://{IP}:{PORT}/services/publicwx/{shId}/attentionPublic,post对象：WxUserPublic
	 * <br/>example:{@link http://120.76.152.25:7888/services/publicwx/9055be7a45a5425da1c44b2e2126411a/attentionPublic},postdata:{...}
	 * @param wxUserPublic 微信用户对象,微信OPENID不能为空，希望微信UnionID能不为空
	 * @param shId 商户编号
	 * @return 记录成功，返回对象的success属性为true,否则为false
	 */
	@POST
	@Path("/{shId}/attentionPublic")
	@Transactional(propagation = Propagation.REQUIRED)
	public Result attentionPublic(WxUserPublic wxUserPublic, @PathParam("shId") String shId);
	
	/**
	 * 获取商户微信支付配置信息
	 * <br/>runAdress:http://{IP}:{PORT}/services/publicwx/{shId}/payInfo
	 * <br/>example:{@link http://120.76.152.25:7888/services/publicwx/9055be7a45a5425da1c44b2e2126411a/payInfo}
	 * @return 返回商户支付配置信息
	 */
	@GET
	@Path("/{shId}/payInfo")
	public WxPayConfig payInfo(@PathParam("shId") String shId);
}
