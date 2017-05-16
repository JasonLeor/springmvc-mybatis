package com.common.hibernate;

import com.common.page.Pagenation;

import java.io.Serializable;
import java.util.List;

public interface BaseDaoIntf<T extends Serializable> {

    public T get(Serializable id);

    public List<T> findAll();

    public List<T> find(String hql, Object... values);

    public Object findUnique(String hql, Object... values);

    public T save(T entity);

    public Object update(Object entity);

    public void delete(Object entity);

    public T deleteById(Serializable id);

    public Object updateById(Serializable id);

    public Pagenation find(String hql, int pageNo, int pageSize, boolean group);

    public int countQueryResult(Finder finder);

    public Pagenation find(String hql, int pageNo, int pageSize);

    public boolean updateByHql(String hql);

    public Pagenation findBySql(String sql, int pageNo, int pageSize, String clazz);

    public Pagenation query(String hql, int pageNo, int pageSize, boolean group);
}
