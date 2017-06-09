package com.dt.dtpt.task.sijiao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dt.dtpt.service.sijiao.SijiaoService;
@Component("sijiaoJob")
public class SijiaoJob {

	@Autowired
	public SijiaoService sijiaoService;
	
	public void noPayhandler(){
		sijiaoService.noPayhandler(2);
	}
	
	public void noPayHanderforDay(){
		sijiaoService.noPayHanderforDay(1);
	}
}
