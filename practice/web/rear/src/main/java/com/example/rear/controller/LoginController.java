package com.example.rear.controller;

import com.example.rear.pojo.Result;
import com.example.rear.pojo.Self;
import com.example.rear.service.SelfService;
import com.example.rear.utils.JwtUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Tag(name = "登录")
@Slf4j
@RestController
public class LoginController {
    @Autowired
    private SelfService selfService;

    @PostMapping("/login")
    @Operation(summary = "登录")
    public Result login(@RequestBody Self self) {
        log.info("登录: {}",self);

        if(self.getUsername() == ""){
            return Result.error("用户名不能为空");
        }
        else if(self.getPassword() == ""){
            return Result.error("密码不能为空");
        }

        // 进行身份验证
        Self authenticatedSelf = selfService.authenticate(self);

        if (authenticatedSelf != null) {
            // 登录成功，生成JWT令牌
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", authenticatedSelf.getId());
            claims.put("username", authenticatedSelf.getUsername());
            String jwtToken = JwtUtils.generateJwt(claims);
            Result result = Result.success(jwtToken);
            result.setMsg("登录成功");
            return result;
        } else {
            // 登录失败
            return Result.error("用户名或密码错误");
        }
    }
}
