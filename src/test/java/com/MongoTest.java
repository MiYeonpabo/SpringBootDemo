package com;

import com.Dao.UserMgRepositoryImpl;
import com.Model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author guanzhiding
 * @date 2021/1/5 16:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoTest {

    @Autowired
    private UserMgRepositoryImpl userMgRepository;

    @Test
    public void test() throws Exception {
        User user = new User();
        user.setName("zhangsan");
        user.setPassWord("admin");
        userMgRepository.save(user);
    }

    @Test
    public void test1() {
        User user = userMgRepository.findUserByName("小明");
        System.out.println(user);
    }

    @Test
    public void test2() {
        User user = new User();
        user.setName("小明");
        user.setPassWord("admin");
        System.out.println(userMgRepository.update(user));
    }

    @Test
    public void test3() {
        User user = new User();
        user.setName("小明");
        user.setPassWord("admin");
        userMgRepository.delete(user);
    }
}
