package com.example.rear.service.impl;

import com.example.rear.mapper.SelfMapper;
import com.example.rear.pojo.Self;
import com.example.rear.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class SelfServiceImpl implements SelfService {
    @Autowired
    private SelfMapper selfMapper;

    @Override
    public Self register(Self self) {
        self.setIsAdmin((short) 0);
        self.setEntrydate(LocalDate.now());
        self.setLastLoginTime(LocalDateTime.now());
        selfMapper.insertSelf(self);
        return self;
    }

    @Override
    public Self findByUsername(String username) {
        Self self = selfMapper.findByUsername(username);
        return self;
    }
}
