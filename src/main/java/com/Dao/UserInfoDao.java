package com.Dao;

import com.Model.ShiroUser;
import org.springframework.data.repository.CrudRepository;

/**
 * @author guanzhiding
 * @date 2021/1/7 15:10
 */
public interface UserInfoDao extends CrudRepository<ShiroUser,Long> {
    /**通过username查找用户信息;*/
    public ShiroUser findByUsername(String username);
}
