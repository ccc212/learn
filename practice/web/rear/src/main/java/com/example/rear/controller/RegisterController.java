package com.example.rear.controller;

import com.example.rear.pojo.Result;
import com.example.rear.pojo.Self;
import com.example.rear.service.SelfService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "注册")
@Slf4j
@RestController
public class RegisterController {

    @Autowired
    private SelfService selfService;

    @PostMapping("/register")
    @Operation(summary = "注册")
    public Result register(@RequestBody Self self){
        log.info("员工注册: {}", self);

        if(self.getUsername() == ""){
            return Result.error("用户名不能为空");
        }
        else if(self.getEmail() == ""){
            return Result.error("邮箱不能为空");
        }
        else if(self.getPassword() == ""){
            return Result.error("密码不能为空");
        }


        // 检查用户名是否已经存在
        Self existingSelf = selfService.findByUsername(self.getUsername());
        if(existingSelf != null) {
            return Result.error("用户名已存在");
        }

        // 注册新员工
        Self registeredSelf = selfService.register(self);
        log.info("注册:{}",registeredSelf);

        return Result.success("注册成功");
    }

}
