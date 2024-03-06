package com.example.rear.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Self {
    private Integer id; //ID
    private String username; //用户名
    private String password; //密码
    private Short gender; //性别 , 1 男, 2 女
    private String image; //头像url
    private LocalDate entrydate; //加入日期
    private Short isAdmin; //是否为管理员
    private LocalDateTime lastLoginTime; //最近登录时间
}
