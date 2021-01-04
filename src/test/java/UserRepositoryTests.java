//import Dao.UserRepository;
//import Model.UserInfo;
//import lombok.SneakyThrows;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.text.DateFormat;
//import java.util.Date;
//import java.util.List;
//
///**
// * @author guanzhiding
// * @date 2020/12/24 17:17
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class UserRepositoryTests {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Test
//    public void Test() throws Exception {
//        Date date = new Date();
//        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
//        String formattedDate = dateFormat.format(date);
//        userRepository.save(new UserInfo("aa1", "aa@126.com", "aa", "aa123456", formattedDate));
//        userRepository.save(new UserInfo("bb2", "bb@126.com", "bb", "bb123456", formattedDate));
//        userRepository.save(new UserInfo("cc3", "cc@126.com", "cc", "cc123456", formattedDate));
//
//        Assert.assertEquals(3, userRepository.findAll().size());
//        Assert.assertEquals("bb123456", userRepository.findByUserNameOrEmail("bb2", "bb@126.com").getNickName());
//        userRepository.delete(userRepository.findByUserName("aa1"));
//    }
//
//    @Test
//    @SneakyThrows
//    public void testBaseQuery() {
//        UserInfo user = new UserInfo();
//        userRepository.findAll();
//        userRepository.findOne(null);
//        userRepository.save(user);
//        userRepository.delete(user);
//        userRepository.count();
//        userRepository.exists(null);
//    }
//
//    @Test
//    @SneakyThrows
//    public void testPageQuery() {
//        Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "id");
//        List<UserInfo> page = userRepository.findAll(pageable).getContent();
//        System.out.println(page);
//        userRepository.findUserInfoByUserName("aaa", pageable);
//    }
//
//
//
//}
