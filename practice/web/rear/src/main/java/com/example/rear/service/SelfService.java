package com.example.rear.service;

import com.example.rear.pojo.Self;

public interface SelfService {

    Self findByUsername(String username);

    Self register(Self self);

    Self authenticate(Self username);
}
