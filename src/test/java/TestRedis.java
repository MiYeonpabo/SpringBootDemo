import com.Model.User;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author guanzhiding
 * @date 2020/12/25 10:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    @SneakyThrows
    public void Test() {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    @SneakyThrows
    public void TestObj() throws Exception {
        User user = new User("aa", "aa123456");
        ValueOperations<String, User> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("com.neox", user);
        valueOperations.set("com.neo.f", user, 1, TimeUnit.SECONDS);
        Thread.sleep(1000);
        boolean boo = redisTemplate.hasKey("com.neox");
        if (boo) {
            System.out.println("exists is true");
        } else {
            System.out.println("exists is false");
        }
    }
}
