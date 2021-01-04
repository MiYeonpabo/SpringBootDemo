//package Dao;
//
//import Model.UserInfo;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// * @author guanzhiding
// * @date 2020/12/24 17:13
// */
//public interface UserRepository extends JpaRepository<UserInfo, Long> {
//    UserInfo findByUserName(String userName);
//
//    UserInfo findByUserNameOrEmail(String username, String emaill);
//
//    Page<UserInfo> findAll(Pageable pageable);
//
//    Page<UserInfo> findUserInfoByUserName(String userName, Pageable pageable);
//
//    @Modifying
//    @Query("update user_info u set u.user_name = ?1 where u.id = ?2")
//    int modifyByIdAndUserId(String userName, Long id);
//
//    @Transactional
//    @Modifying
//    @Query("delete from user_info where id = ?1")
//    void deleteByUserId(Long id);
//
//    @Transactional(timeout = 10)
//    @Query("select u from user_info u where u.email = ?1")
//    UserInfo findByEmail(String email);
//
//    //创建一个结果集的接口来接收连表查询后的结果
//    @Query("select h.city as city, h.name as name, avg(r.rating) as averageRating from Hotel h left outer join h.reviews r where h.city = ?1 group by h")
//    Page<HotelSummary> findByEmail(UserInfo userInfo, Pageable pageable);
//
//
//    @Query("select h.name as name, avg(r.rating) as averageRating from Hotel h left outer join h.reviews r  group by h")
//    Page<HotelSummary> findByCity(Pageable pageable);
//}
