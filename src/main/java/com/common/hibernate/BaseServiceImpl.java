package com.common.hibernate;

import com.common.page.Pagenation;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaseServiceImpl<T extends Serializable> extends
        HibernateDaoSupport implements BaseServiceIntf<T> {
    private BaseDaoIntf<T> dao;

    @Autowired
    public void setFactory(
            @Qualifier("sessionFactory") SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    protected BaseDaoIntf<T> getDao() {
        return this.dao;
    }

    public void setDao(BaseDaoIntf<T> dao) {
        this.dao = dao;
    }

    @Transactional(readOnly = true)
    public T findById(Serializable id) {
        return dao.get(id);
    }

    @Transactional(readOnly = true)
    public List<T> findAll() {
        return dao.findAll();
    }

    @Transactional(readOnly = true)
    public List<T> find(String hql, Object... values) {
        return this.getDao().find(hql, values);
    }

    @Transactional(readOnly = true)
    public Object findUnique(String hql) {
        return this.dao.findUnique(hql);
    }

    @Transactional
    public T save(T entity) {
        return dao.save(entity);
    }

    @Transactional
    public Object update(Object o) {
        return getDao().update(o);
    }

    @Transactional
    public void delete(Object o) {
        getDao().delete(o);
    }

    @Transactional
    public T deleteById(Serializable id) {
        if (id == null) {
            return null;
        }
        return dao.deleteById(id);
    }

    @Transactional
    public List<T> deleteById(Serializable[] ids) {
        List<T> dts = new ArrayList<T>();
        T del = null;
        if (ids != null && ids.length > 0) {
            for (Serializable id : ids) {
                del = deleteById(id);
                if (del != null) {
                    dts.add(del);
                }
            }
        }
        return dts;
    }

    public int countQueryResult(Finder finder) {
        return dao.countQueryResult(finder);
    }

    @Transactional(readOnly = true)
    public Pagenation find(String hql, int pageNo, int pageSize, boolean group) {
        return dao.find(hql, pageNo, pageSize, group);
    }

    @Transactional(readOnly = true)
    public Pagenation find(String hql, int pageNo, int pageSize) {
        return dao.find(hql, pageNo, pageSize);
    }

    @Transactional
    public boolean updateByHql(String hql) {
        return dao.updateByHql(hql);
    }

    @Transactional
    public Object updateById(Serializable id) {
        return getDao().updateById(id);
    }

    public Pagenation findBySql(String sql, int pageNo, int pageSize, String clazz) {
        return getDao().findBySql(sql, pageNo, pageSize, clazz);
    }

    public Pagenation query(String hql, int pageNo, int pageSize, boolean group) {
        return getDao().query(hql, pageNo, pageSize, group);
    }
}
