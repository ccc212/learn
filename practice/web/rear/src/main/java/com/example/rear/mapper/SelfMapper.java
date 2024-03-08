package com.example.rear.mapper;

import com.example.rear.pojo.Self;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SelfMapper {
    @Insert("insert into self(username,password,gender,image,entrydate,is_admin,last_login_time,email)" +
            "values(#{username}, #{password}, #{gender}, #{image}, #{entrydate}, #{isAdmin}, #{lastLoginTime}, #{email})")
    void insertSelf(Self self);

    @Select("select * from self where username = #{username}")
    Self findByUsername(String username);

    @Select("select * from self where username = #{username} and password = #{password}")
    Self authenticate(Self self);
}
