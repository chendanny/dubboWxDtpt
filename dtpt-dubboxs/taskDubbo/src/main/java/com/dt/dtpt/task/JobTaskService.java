package com.dt.dtpt.task;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dt.dtpt.mybatis.model.task.ScheduleJob;
import com.dt.dtpt.util.Result;

@Service
@Path("/task")
@Consumes({"application/json; charset=UTF-8", "text/xml; charset=UTF-8"})
@Produces({"application/json; charset=UTF-8", "text/xml; charset=UTF-8"})
public interface JobTaskService {

	@GET
	@Path("/list")
	public Result taskList();
	
	@POST
	@Path("/add")
	@Transactional(propagation = Propagation.REQUIRED)
	public Result add(ScheduleJob scheduleJob);
	
	@POST
	@Path("/changeJobStatus/{jobId}/{cmd}")
	@Transactional(propagation = Propagation.REQUIRED)
	public Result changeJobStatus(@PathParam("jobId") Long jobId, @PathParam("cmd") String cmd);
	
	@POST
	@Path("/updateCron/{jobId}")
	@Transactional(propagation = Propagation.REQUIRED)
	public Result updateCron(@PathParam("jobId") Long jobId, @QueryParam("cron") String cron);
}
