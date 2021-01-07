package com.Controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author guanzhiding
 * @date 2021/1/7 11:32
 */
@Controller
@RequestMapping("/userInfo")
public class ShiroUserController {

    @RequestMapping("/userList")
    @RequiresPermissions("userInfo:view")
    public String userInfo() {
        return "userInfo";
    }

    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")
    public String userInfoAdd() {
        return "userInfoAdd";
    }

    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")
    public String userInfoDel() {
        return "userInfoDel";
    }
}
