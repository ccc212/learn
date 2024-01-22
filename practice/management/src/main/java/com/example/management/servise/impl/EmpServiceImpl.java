package com.example.management.servise.impl;

import com.example.management.mapper.EmpMapper;
import com.example.management.pojo.Emp;
import com.example.management.pojo.PageBean;
import com.example.management.servise.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean query(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Emp>empList = empMapper.list();
        Page<Emp>p = (Page<Emp>) empList;
        return new PageBean(p.getTotal(),p.getResult());
    }

    @Override
    public void delete(Integer ids) {
        empMapper.delete(ids);
    }

    @Override
    public void add(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.add(emp);
    }

    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }
}
