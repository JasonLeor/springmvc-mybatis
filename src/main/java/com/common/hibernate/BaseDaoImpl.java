package com.common.hibernate;

import com.common.page.Pagenation;
import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaseDaoImpl<T extends Serializable> implements BaseDaoIntf<T> {

    protected SessionFactory sessionFactory;
    private Class<T> persistentClass;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public T get(Serializable id) {
        Assert.notNull(id);
        return (T) getSession().get(getPersistentClass(), id);
    }

    public List<T> findAll() {
        return findByCriteria();
    }

    public List<T> find(String hql, Object... values) {
        return createQuery(hql, values).list();
    }

    public Object findUnique(String hql, Object... values) {
        return createQuery(hql, values).uniqueResult();
    }

    public T save(T entity) {
        Assert.notNull(entity);
        getSession().save(entity);
        return entity;
    }

    public Object update(Object entity) {
        Assert.notNull(entity);
        getSession().update(entity);
        return entity;
    }

    public Object updateById(Serializable id) {
        Assert.notNull(id);
        T entity = get(id);
        getSession().update(entity);
        return entity;
    }

    public void delete(Object entity) {
        Assert.notNull(entity);
        getSession().delete(entity);
    }

    public T deleteById(Serializable id) {
        Assert.notNull(id);
        T entity = load(id);
        getSession().delete(entity);
        return entity;
    }

    public T load(Serializable id) {
        Assert.notNull(id);
        return load(id, false);
    }

    public T load(Serializable id, boolean lock) {
        Assert.notNull(id);
        T entity = null;
        if (lock) {
            entity = (T) getSession().load(getPersistentClass(), id,
                    LockMode.UPGRADE);
        } else {
            entity = (T) getSession().load(getPersistentClass(), id);
        }
        return entity;
    }

    protected List<T> findByCriteria(Criterion... criterion) {
        return createCriteria(criterion).list();
    }

    protected Criteria createCriteria(Criterion... criterions) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        for (Criterion c : criterions) {
            criteria.add(c);
        }
        return criteria;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    protected Query createQuery(String queryString, Object... values) {
        Assert.hasText(queryString);
        Query queryObject = getSession().createQuery(queryString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                queryObject.setParameter(i, values[i]);
            }
        }
        return queryObject;
    }

    public int countQueryResult(Finder finder) {
        Query query = getSession().createQuery(finder.getRowCountHql());
        finder.setParamsToQuery(query);
        return ((Number) query.iterate().next()).intValue();
    }


    public Pagenation find(String hql, int pageNo, int pageSize, boolean group) {
        Finder finder = new Finder(hql);
        int totalCount = 0;
        if (group) {
            totalCount = this.find(hql).size();
        } else {
            totalCount = countQueryResult(finder);
        }

        Pagenation p = new Pagenation(pageNo, pageSize, totalCount);
        if (totalCount < 1) {
            p.setList(new ArrayList());
            return p;
        }

        Query query = getSession().createQuery(finder.getOrigHql());
        finder.setParamsToQuery(query);
        query.setFirstResult(p.getFirstResult());
        query.setMaxResults(p.getPageSize());
        List list = query.list();
        p.setList(list);
        return p;
    }

    public Pagenation find(String hql, int pageNo, int pageSize) {
        int totalCount = 0;
        Session session = getSession();
        Query query = session.createQuery(hql);
        String count = "select count(*) " + hql.substring(hql.indexOf("from"), hql.length());

        totalCount = Integer.parseInt(session.createQuery(count).uniqueResult().toString());

        Pagenation p = new Pagenation(pageNo, pageSize, totalCount);
        query.setFirstResult(p.getFirstResult());
        query.setMaxResults(p.getPageSize());
        List list = query.list();
        p.setList(list);
        return p;
    }

    public boolean updateByHql(String hql) {
        // TODO Auto-generated method stub
        Session session = this.getSession();
        Query query = session.createQuery(hql);
        int rows = query.executeUpdate();
        if (rows != 0) {
            return true;
        }
        return false;
    }

    /***
     * 根据sql分页
     * @param sql sql语句
     * @param pageNo 当前页
     * @param pageSize 每页几行
     * @return 分页列表
     */
    public Pagenation findBySql(String sql, int pageNo, int pageSize, String clazz) {
        int totalCount = 0;
        Session session = this.getSession();
        Query query = session.createSQLQuery(sql);
        String count = "select count(*) " + sql.substring(sql.indexOf("from"), sql.length());

        totalCount = Integer.parseInt(session.createQuery(count).uniqueResult().toString());

        Pagenation p = new Pagenation(pageNo, pageSize, totalCount);
        query.setFirstResult(p.getFirstResult());
        query.setMaxResults(p.getPageSize());
        List list = query.list();
        p.setList(list);
        return p;
    }

    public Pagenation query(String hql, int pageNo, int pageSize, boolean group) {
        System.out.println(hql);
        int totalCount = 0;
        Session session = getSession();
        Query query = session.createQuery(hql);
        if (group) {
            totalCount = query.list().size();
        } else {
            String count = "select count(*) " + hql.substring(hql.indexOf("from"), hql.length());
            totalCount = Integer.parseInt(session.createQuery(count).uniqueResult().toString());
        }
        Pagenation p = new Pagenation(pageNo, pageSize, totalCount);
        query.setFirstResult(p.getFirstResult());
        query.setMaxResults(p.getPageSize());
        List list = query.list();
        p.setList(list);
        return p;
    }
}
