package me.gu.springcloud.service;

import me.gu.springcloud.entity.SysDept;

import java.util.List;

public interface DeptService {

    public boolean addDept(SysDept sysDept);

    public SysDept queryById(Long id);

    public List<SysDept> queryAll();
}
