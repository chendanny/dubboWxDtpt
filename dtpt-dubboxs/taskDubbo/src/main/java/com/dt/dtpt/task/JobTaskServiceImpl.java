package com.dt.dtpt.task;

import java.lang.reflect.Method;
import java.net.URLDecoder;

import org.apache.commons.lang.StringUtils;
import org.quartz.CronScheduleBuilder;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dt.dtpt.mybatis.model.task.ScheduleJob;
import com.dt.dtpt.service.impl.ScheduleJobService;
import com.dt.dtpt.util.Result;
import com.dt.dtpt.util.SpringContextUtils;

public class JobTaskServiceImpl implements JobTaskService {

	private static Logger log = LoggerFactory.getLogger(JobTaskServiceImpl.class);
	
	@Autowired
	private ScheduleJobService taskService;
	
	public Result taskList() {
		return Result.success(taskService.getAllTask());
	}

	public Result add(ScheduleJob scheduleJob) {
		try {
			if(scheduleJob != null){
				if(scheduleJob.getJobName() != null) scheduleJob.setJobName(URLDecoder.decode(URLDecoder.decode(scheduleJob.getJobName())));
				if(scheduleJob.getDescription() != null) scheduleJob.setDescription(URLDecoder.decode(URLDecoder.decode(scheduleJob.getDescription())));
				System.out.println(scheduleJob.getCronExpression());
				if(scheduleJob.getCronExpression() != null) scheduleJob.setCronExpression(URLDecoder.decode(URLDecoder.decode(scheduleJob.getCronExpression())));
				System.out.println(scheduleJob.getCronExpression());
				CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression());
			}
		} catch (Exception e) {
			return Result.failure("cron表达式有误，不能被解析！");
		}
		Object obj = null;
		try {
			System.out.println(scheduleJob.getSpringId());
			System.out.println(scheduleJob.getBeanClass());
			if (StringUtils.isNotBlank(scheduleJob.getSpringId())) {
				obj = SpringContextUtils.getBean(scheduleJob.getSpringId());
			} else {
				Class clazz = Class.forName(scheduleJob.getBeanClass());
				obj = clazz.newInstance();
			}
		} catch (Exception e) {
			// do nothing.........
			e.printStackTrace();
		}
		if (obj == null) {
			return Result.failure("未找到目标类！");
		} else {
			Class clazz = obj.getClass();
			Method method = null;
			try {
				method = clazz.getMethod(scheduleJob.getMethodName(), null);
			} catch (Exception e) {
				// do nothing.....
			}
			if (method == null) {
				return Result.failure("未找到目标方法！");
			}
		}
		try {
			taskService.addTask(scheduleJob);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.failure("保存失败，检查 name group 组合是否有重复！");
		}

		return Result.success();
	}

	public Result changeJobStatus(Long jobId, String cmd) {
		try {
			taskService.changeStatus(jobId, cmd);
		} catch (SchedulerException e) {
			log.error(e.getMessage(), e);
			return Result.failure("任务状态改变失败！");
		}
		return Result.success();
	}

	public Result updateCron(Long jobId, String cron) {
		try {
			if(cron != null) cron = URLDecoder.decode(cron);
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
		} catch (Exception e) {
			return Result.failure("cron表达式有误，不能被解析！");
		}
		try {
			taskService.updateCron(jobId, cron);
		} catch (SchedulerException e) {
			return Result.failure("cron更新失败！");
		}
		return Result.success();
	}
	public static void main(String[] args) {
		System.out.println(URLDecoder.decode(URLDecoder.decode("0%252015%2520*%2520*%2520*%2520%253F")));
	}
}
