package com.jason.dao.impl;

import com.common.hibernate.BaseDaoImpl;
import com.jason.dao.intf.UserDaoIntf;
import com.jason.model.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by suliguo on 2017/5/19.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<UserEntity> implements UserDaoIntf {

}
