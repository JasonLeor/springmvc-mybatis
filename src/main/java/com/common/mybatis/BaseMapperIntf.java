package com.common.mybatis;

import java.io.Serializable;
import java.util.List;

/**
 * Created by suliguo on 2017/5/17.
 */
public interface BaseMapperIntf<T, PK extends Serializable> {

    /**
     * 插入
     */
    T insert(T entity);

    /**
     * 批量插入
     */
    boolean batchinsert(List<T> list);

    /**
     * 更新对象
     */
    boolean update(T entity);

    /**
     * 查询所有
     */
    List<T> queryAll();

    /**
     * 查询所有(分页)
     */
    List<T> queryAll(int pageNo, int size);

    /**
     * 查询所有实体 根据属性值 判断条件
     */
    List<T> queryAllByEntity(T entity);

    /**
     * 查询所有实体 根据属性值 判断条件(分页)
     */
    List<T> queryAllByEntity(int pageNo, int size, T entity);

    /**
     * 根据主键查询
     *
     * @param pk
     * @return
     */
    T QueryUnique(PK pk);

}
