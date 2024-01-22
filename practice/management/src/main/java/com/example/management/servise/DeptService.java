package com.example.management.servise;

import com.example.management.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> list();

    void delete(Integer id);

    void add(Dept dept);

    Dept get(Integer id);

    void update(Dept dept);
}
