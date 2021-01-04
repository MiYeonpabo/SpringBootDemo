package com.Controller;

import com.Model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author guanzhiding
 * @date 2020/12/25 10:49
 */
@RestController
public class RedisController {

    @RequestMapping("/getRedisUser")
    @Cacheable(value = "user-key",keyGenerator="keyGenerator")
    public User testRedis() {
        User user = new User("aaa", "111");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }

    @RequestMapping("/getUUID")
    public String getUUID(HttpSession session) {
        UUID uuid = (UUID) session.getAttribute("uid");
        if (null == uuid) {
            uuid = UUID.randomUUID();
        }
        session.setAttribute("uid", uuid);
        return session.getId();
    }
}
