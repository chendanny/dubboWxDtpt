package com.dt.dtpt.service;

import com.dt.dtpt.util.Page;

import java.util.List;


public abstract interface IService<T>
{
  public static final int MIN_PAGE_SIZE = 1;
  public static final int DEF_PAGE_SIZE = 10;
  public static final int MAX_PAGE_SIZE = 100;

  T selectByKey(Object key);
  
  T selectOne(T entity);

  int save(T entity);

  int delete(Object key);

  int updateAll(T entity);

  int updateNotNull(T entity);

  List<T> select(T entity);

  public List<T> findAll();

  public Page<T> queryByPage(T entity, int pageNumber, int pageSize);
  
  public List<T> queryList(T entity, int pageNumber, int pageSize);
}