package com.dt.dtpt.service.impl;

import com.dt.dtpt.service.IService;
import com.dt.dtpt.util.Page;
import com.dt.dtpt.util.PageParameter;
import com.github.pagehelper.PageHelper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.common.Mapper;

@Service
public abstract class BaseService<T> implements IService<T> {

	@Autowired
	protected JdbcTemplate jdbcTemplate;
	@Autowired
	protected Mapper<T> mapper;

	public Mapper<T> getMapper() {
		return this.mapper;
	}

	public T selectByKey(Object key) {
		return this.mapper.selectByPrimaryKey(key);
	}

	public T selectOne(T entity) {
		return this.mapper.selectOne(entity);
	}

	public int save(T entity) {
		return this.mapper.insert(entity);
	}

	public int delete(Object key) {
		return this.mapper.deleteByPrimaryKey(key);
	}

	public int updateAll(T entity) {
		return this.mapper.updateByPrimaryKey(entity);
	}

	public int updateNotNull(T entity) {
		return this.mapper.updateByPrimaryKeySelective(entity);
	}

	public List<T> select(T entity) {
		return this.mapper.select(entity);
	}

	public List<T> findAll() {
		return this.mapper.selectAll();
	}

	public Page<T> queryByPage(T queryObj, int pageNumber, int pageSize) {
		PageParameter page = new PageParameter();
		page.setCurrentPage(pageNumber);
		page.setPageSize(pageSize);
		PageHelper.startPage(pageNumber, pageSize);
		List<T> lst = this.mapper.select(queryObj);
		int countnum = this.mapper.selectCount(queryObj);
		page.setTotalCount(countnum);
		int totalPage = countnum / page.getPageSize()
				+ (countnum % page.getPageSize() == 0 ? 0 : 1);
		page.setTotalPage(totalPage);
		Page<T> result = new Page<T>(page, lst);
		return result;
	}

	public List<T> queryList(T queryObj, int pageNumber, int pageSize) {
		PageParameter page = new PageParameter();
		page.setCurrentPage(pageNumber);
		page.setPageSize(pageSize);
		PageHelper.startPage(pageNumber, pageSize);
		List<T> lst = this.mapper.select(queryObj);
		return lst;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

}