package com.dt.dtpt.filter;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Priority(-2147483648)
public class RestCrossFilter implements ContainerResponseFilter{

	private static Logger log = LoggerFactory.getLogger(RestCrossFilter.class);
	public void filter(ContainerRequestContext arg0,
			ContainerResponseContext res) throws IOException {
		log.warn("============设置头部================start");
		res.getHeaders().add("Access-Control-Allow-Origin", "*");
		res.getHeaders().add("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		res.getHeaders().add("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		log.warn("============设置头部================end");
	}

}
