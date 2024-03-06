package com.example.rear.controller;

import com.example.rear.pojo.Result;
import com.example.rear.pojo.Self;
import com.example.rear.service.SelfService;
import com.example.rear.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class RegisterController {

    @Autowired
    private SelfService selfService;

    @PostMapping("/register")
    public Result register(@RequestBody Self self){
        log.info("员工注册: {}", self);

        // 检查用户名是否已经存在
        Self existingSelf = selfService.findByUsername(self.getUsername());
        if(existingSelf != null) {
            return Result.error("用户名已存在");
        }

        // 注册新员工
        Self registeredSelf = selfService.register(self);

        System.out.println(registeredSelf);

        // 注册成功，生成令牌
        if (registeredSelf != null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", registeredSelf.getId());
            claims.put("username", registeredSelf.getUsername());

            String jwt = JwtUtils.generateJwt(claims); //jwt包含了当前注册的员工信息
            return Result.success(jwt);
        }

        // 注册失败
        return Result.error("注册失败，请稍后重试");
    }

}
