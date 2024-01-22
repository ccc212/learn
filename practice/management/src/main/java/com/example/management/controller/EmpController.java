package com.example.management.controller;

import com.example.management.pojo.Emp;
import com.example.management.pojo.PageBean;
import com.example.management.pojo.Result;
import com.example.management.servise.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
    public Result query(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer pageSize){
        log.info("分页查询,参数:{},{}",page,pageSize);

        PageBean pageBean = empService.query(page,pageSize);

        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable Integer ids){
        log.info("根据id删除员工:{}",ids);

        empService.delete(ids);

        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Emp emp){
        log.info("添加员工:{}",emp);

        empService.add(emp);

        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据id查询员工:{}",id);
        return Result.success(empService.getById(id));
    }
}
