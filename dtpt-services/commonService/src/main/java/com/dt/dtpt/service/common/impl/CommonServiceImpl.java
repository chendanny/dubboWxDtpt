package com.dt.dtpt.service.common.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dt.dtpt.mybatis.model.common.TbSysUser;
import com.dt.dtpt.service.IService;
import com.dt.dtpt.service.common.CommonService;
import com.dt.dtpt.util.Result;

@Service(value = "commonService")
@Transactional(readOnly = true)
public class CommonServiceImpl implements CommonService {

	@Autowired
	IService<TbSysUser> userService;
	
	public Result getUserByWxzh(String userWxzh) {
		if(userWxzh != null && !"".equals(userWxzh)){
			TbSysUser user=new TbSysUser();
			user.setWxAccount(userWxzh);
			List<TbSysUser> users = userService.selectByExample(user);
			user = null;
			if(users != null && users.size() > 0) user = users.get(0);
			return Result.success(user);
		}else{
			return Result.failure("参数校验失败", "用户微信账号为空");
		}
	}

}
