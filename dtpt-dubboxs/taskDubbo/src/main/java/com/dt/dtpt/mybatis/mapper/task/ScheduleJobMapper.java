package com.dt.dtpt.mybatis.mapper.task;

import java.util.List;



import com.dt.dtpt.mybatis.model.task.ScheduleJob;

import tk.mybatis.mapper.common.Mapper;

public interface ScheduleJobMapper {
	int deleteByPrimaryKey(Long jobId);

	int insert(ScheduleJob record);

	int insertSelective(ScheduleJob record);

	ScheduleJob selectByPrimaryKey(Long jobId);

	int updateByPrimaryKeySelective(ScheduleJob record);

	int updateByPrimaryKey(ScheduleJob record);

	List<ScheduleJob> getAll();
}
