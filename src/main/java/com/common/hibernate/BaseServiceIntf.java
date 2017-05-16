package com.common.hibernate;

import com.common.hibernate.Finder;
import com.common.page.Pagenation;

import java.io.Serializable;
import java.util.List;

public interface BaseServiceIntf<T extends Serializable> {

    public T findById(Serializable id);

    public Object findUnique(String hql);

    public List<T> findAll();

    public List<T> find(String hql, Object... values);

    public T save(T entity);

    public Object update(Object entity);

    public void delete(Object o);

    public T deleteById(Serializable id);

    public List<T> deleteById(Serializable[] ids);


    public Pagenation find(String hql, int pageNo, int pageSize, boolean group);

    public int countQueryResult(Finder finder);

    public Pagenation find(String hql, int pageNo, int pageSize);

    /****
     * @author Administrator huwentao
     * @param hql hql语句 根据hql语句进行修改
     * @return 返回修改结果
     */
    public boolean updateByHql(String hql);

    public Object updateById(Serializable id);


    /***
     * 根据sql分页
     * @param sql sql语句
     * @param clazz 所受管的实体类名
     * @param pageNo 当前页
     * @param pageSize 每页几行
     * @return 分页列表
     */
    public Pagenation findBySql(String sql, int pageNo, int pageSize, String clazz);

    public Pagenation query(String hql, int pageNo, int pageSize, boolean group);
}
