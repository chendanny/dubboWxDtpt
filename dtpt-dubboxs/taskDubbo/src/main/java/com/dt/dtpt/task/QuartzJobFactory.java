package com.dt.dtpt.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.dt.dtpt.mybatis.model.task.ScheduleJob;



/**
 * @author 肖长江
 * 计划任务执行处 无状态
 */
public class QuartzJobFactory implements Job {
	public void execute(JobExecutionContext context) throws JobExecutionException {
		ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
		TaskUtils.invokMethod(scheduleJob);
	}
}