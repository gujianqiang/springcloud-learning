package me.gu.springcloud.dao;

import me.gu.springcloud.entity.SysDept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {

    public boolean addDept(SysDept sysDept);

    public SysDept queryById(Long id);

    public List<SysDept> queryAll();
}
