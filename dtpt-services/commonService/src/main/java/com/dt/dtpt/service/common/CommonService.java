package com.dt.dtpt.service.common;

import com.dt.dtpt.util.Result;

public interface CommonService {

	/**
	 * 根据用户微信账号查找用户
	 * @param userWxzh
	 * @return Result对象中的result字段为 TbSysUser对象
	 */
	public Result getUserByWxzh(String userWxzh);
	
	
}
