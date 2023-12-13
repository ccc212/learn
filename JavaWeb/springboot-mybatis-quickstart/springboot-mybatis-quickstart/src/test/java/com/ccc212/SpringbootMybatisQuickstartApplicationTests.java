package com.ccc212;

import com.ccc212.mapper.UserMapper;
import com.ccc212.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest//springboot整合单元测试的注解
class SpringbootMybatisQuickstartApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testListUser(){
        List<User> userList=userMapper.list();
        userList.stream().forEach(user -> {
            System.out.println(user);
        });
    }

}
