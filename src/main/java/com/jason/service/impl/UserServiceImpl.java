package com.jason.service.impl;

import com.common.hibernate.BaseServiceImpl;
import com.jason.dao.intf.UserDaoIntf;
import com.jason.model.UserEntity;
import com.jason.service.intf.UserServiceIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by suliguo on 2017/5/19.
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<UserEntity> implements UserServiceIntf {
    public UserDaoIntf getDao() {
        return (UserDaoIntf) super.getDao();
    }

    @Autowired
    public void setDao(UserDaoIntf dao) {
        super.setDao(dao);
    }
}
