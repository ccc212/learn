package com.example.management.controller;

import com.example.management.pojo.Emp;
import com.example.management.pojo.PageBean;
import com.example.management.pojo.Result;
import com.example.management.servise.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("分页查询, 参数: {},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
        //调用service分页查询
        PageBean pageBean = empService.query(page,pageSize,name,gender,begin,end);
        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
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

    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("更新员工:{}",emp);
        empService.update(emp);
        return Result.success();
    }
}
