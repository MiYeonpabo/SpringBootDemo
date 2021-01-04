package com.Mapper.test1;

import com.Model.UserInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import java.util.List;


/**
 * @author guanzhiding
 * @date 2020/12/28 16:36
 */
public interface UserMapper1 {

    @Select("select * from user_info")
    @Results({
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "userName", column = "user_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "nickName", column = "nick_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "passWord", column = "pass_word", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "regTime", column = "reg_time", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "email", column = "email", jdbcType = JdbcType.VARCHAR, javaType = String.class)
    })
    List<UserInfo> findAll();

    @Select("select id,user_name,nick_name from user_info where id=#{id}")
    @Results({
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(property = "userName", column = "user_name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "nickName", column = "nick_name", jdbcType = JdbcType.VARCHAR, javaType = String.class)
    })
    UserInfo getOne(Long id);

    @Insert("INSERT INTO user_info (user_name,nick_name,pass_word,reg_time,email) VALUES(#{userName},#{nickName},#{passWord},#{regTime},#{email})")
    void insertOne(UserInfo userInfo);

    @Update("UPDATE user_info SET  user_name=#{userName} where id=#{id}")
    void updateOne(UserInfo userInfo);

    @Delete("DELETE FROM user_info WHERE id =#{id}")
    void deleteOne(Long id);

}
