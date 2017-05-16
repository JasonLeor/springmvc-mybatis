package com.common.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by suliguo on 2017/5/17.
 */
public abstract class BaseMapperImpl<T, PK extends Serializable> implements BaseMapperIntf<T, PK> {


    public T insert(T entity) {
        return null;
    }

    public boolean batchinsert(List<T> list) {
        return false;
    }

    public boolean update(T entity) {
        return false;
    }

    public List<T> queryAll() {
        return null;
    }

    public List<T> queryAll(int pageNo, int size) {
        return null;
    }

    public List<T> queryAllByEntity(T entity) {
        return null;
    }

    public List<T> queryAllByEntity(int pageNo, int size, T entity) {
        return null;
    }

    public T QueryUnique(PK pk) {
        return null;
    }
}
