package com.example.rear.controller;

import com.example.rear.pojo.Result;
import com.example.rear.pojo.Self;
import com.example.rear.service.SelfService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private SelfService selfService;

    @PostMapping("/login")
    public Result login(@RequestBody Self self) {
        log.info("登录: {}",self);
        return Result.success();
    }
}
