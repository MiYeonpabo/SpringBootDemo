package com.Service;

import com.Model.ShiroUser;

/**
 * @author guanzhiding
 * @date 2021/1/7 15:11
 */
public interface UserInfoService {
    /**通过username查找用户信息;*/
    public ShiroUser findByUsername(String username);
}
