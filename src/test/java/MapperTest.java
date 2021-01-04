import com.Mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author guanzhiding
 * @date 2020/12/28 16:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void Test() {
        //查询全部
//        List<UserInfo> list = userMapper.findAll();
//        System.out.println(list);
        //查询一个及部分字段(没做类型对接的为null)
//        UserInfo userInfo = userMapper.getOne(9L);
//        System.out.println(userInfo);
        //插入
//        userMapper.insertOne(new UserInfo("dd", "dd4", "dd@126.com", "dd123456", "2020年12月24日 下午05时31分24秒"));
        //更新
//        UserInfo userInfo = new UserInfo();
//        userInfo.setId(11L);
//        userInfo.setUserName("ee");
//        userMapper.updateOne(userInfo);
        //删除
//        userMapper.deleteOne(11L);
    }
}
