package com.Controller;

import com.Model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guanzhiding
 * @date 2020/12/23 17:05
 */
@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index() {
        return "Hello World!";
    }

    @RequestMapping("/getUser")
    public User getUser() {
        User user = new User();
        user.setName("小明");
        user.setPassWord("xxx");
        return user;
    }


}
