package com.ccc212.spingbootwebreqresp.dao;

import com.ccc212.spingbootwebreqresp.pojo.Emp;

import java.util.List;

public interface EmpDao {
    //获取员工列表数据
    public List<Emp> listEmp();
}
