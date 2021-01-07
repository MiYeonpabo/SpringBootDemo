package com.Service.impl;

import com.Dao.UserInfoDao;
import com.Model.ShiroUser;
import com.Service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author guanzhiding
 * @date 2021/1/7 15:11
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public ShiroUser findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }
}
