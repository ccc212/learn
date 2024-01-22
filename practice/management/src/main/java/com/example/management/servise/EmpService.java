package com.example.management.servise;

import com.example.management.pojo.Emp;
import com.example.management.pojo.PageBean;

public interface EmpService {

    PageBean query(Integer page, Integer pageSize);

    void delete(Integer ids);

    void add(Emp emp);

    Emp getById(Integer id);
}
