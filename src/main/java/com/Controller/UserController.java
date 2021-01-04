package com.Controller;

import com.Mapper.test1.UserMapper1;
import com.Mapper.test2.UserMapper2;
import com.Model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author guanzhiding
 * @date 2020/12/29 16:43
 */
@RestController
public class UserController {

    @Autowired
    UserMapper1 userMapper1;
    @Autowired
    UserMapper2 userMapper2;

    @RequestMapping("/getAllUser1")
    public List<UserInfo> getUser1() {
        return userMapper1.findAll();
    }

    @RequestMapping("/getAllUser2")
    public List<UserInfo> getUser2() {
        return userMapper2.findAll();
    }


}
