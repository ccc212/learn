package com.example.management.mapper;

import com.example.management.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select * from dept")
    List<Dept> list();

    @Select("delete from dept where id = #{id}")
    void delete(Integer id);

    @Select("insert into dept(name, create_time, update_time) value(#{name},#{createTime},#{updateTime})")
    void add(Dept dept);

    @Select("select * from dept where id = #{id}")
    Dept get(Integer id);

    @Select("update dept set name = #{name},create_time = #{createTime},update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}
