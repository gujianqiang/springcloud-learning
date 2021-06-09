package me.gu.springcloud.controller;

import me.gu.springcloud.entity.SysDept;
import me.gu.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    final DeptService deptService;

    @Autowired
    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody SysDept sysDept) {
        return deptService.addDept(sysDept);
    }

    @GetMapping("/dept/get/{id}")
    public SysDept get(@PathVariable("id") Long id) {
        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<SysDept> queryAll() {
        return deptService.queryAll();
    }

}
