package com;

import com.MQ.DirectExchange.HelloSender;
import com.MQ.DirectExchange.HelloSender2;
import com.MQ.FanoutExchange.SenderA;
import com.MQ.TopicExchange.Sender1;
import com.MQ.TopicExchange.Sender2;
import com.Model.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MQTest {

    @Autowired
    HelloSender helloSender;

    @Autowired
    HelloSender2 helloSender2;

    @Autowired
    Sender1 sender1;

    @Autowired
    Sender2 sender2;

    @Autowired
    SenderA senderA;

    //direct
    @Test
    public void Test() throws Exception {
        helloSender.send();
    }

    //一对多
    @Test
    public void Test2() throws Exception {
        for (int i = 0; i < 10; i++) {
            helloSender.send();
        }
    }

    //多对多
    @Test
    public void Test3() throws Exception {
        for (int i = 0; i < 10; i++) {
            helloSender.send();
            helloSender2.send();
        }
    }

    //发送对象
    @Test
    public void Test4() throws Exception {
        UserInfo userInfo = new UserInfo("aa", "123");
        helloSender.send(userInfo);
    }

    //topic
    @Test
    public void Test5() throws Exception {
        sender1.send();
    }

    @Test
    public void Test6() throws Exception {
        sender2.send();
    }

    //fanout(不用绑定exchange也能发送接收)
    @Test
    public void Test7() throws Exception {
        senderA.send();
    }
}
