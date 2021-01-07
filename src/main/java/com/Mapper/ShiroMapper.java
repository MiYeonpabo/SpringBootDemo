package com.Mapper;

import com.Model.ShiroUser;
import com.Model.UserInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * @author guanzhiding
 * @date 2021/1/7 11:28
 */
public interface ShiroMapper {

    @Select("select * from shiro_user")
    @Results({
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Integer.class),
            @Result(property = "name", column = "name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "password", column = "password", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "salt", column = "salt", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "state", column = "state", jdbcType = JdbcType.TINYINT, javaType = Byte.class),
            @Result(property = "username", column = "username", jdbcType = JdbcType.VARCHAR, javaType = String.class)
    })
    List<UserInfo> findAll();

    @Select("select * from shiro_user where username=#{username}")
    @Results({
            @Result(property = "id", column = "id", jdbcType = JdbcType.BIGINT, javaType = Integer.class),
            @Result(property = "name", column = "name", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "password", column = "password", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "salt", column = "salt", jdbcType = JdbcType.VARCHAR, javaType = String.class),
            @Result(property = "state", column = "state", jdbcType = JdbcType.TINYINT, javaType = Byte.class),
            @Result(property = "username", column = "username", jdbcType = JdbcType.VARCHAR, javaType = String.class)
    })
    ShiroUser findByUsername(String username);

    @Update("UPDATE shiro_user SET  name=#{name} where id=#{id}")
    void updateOne(ShiroUser shiroUser);

    @Delete("DELETE FROM shiro_user WHERE id =#{id}")
    void deleteOne(Long id);
}
