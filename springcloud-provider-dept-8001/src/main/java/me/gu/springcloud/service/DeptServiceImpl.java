package me.gu.springcloud.service;

import me.gu.springcloud.dao.DeptDao;
import me.gu.springcloud.entity.SysDept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    final DeptDao deptDao;

    @Autowired
    public DeptServiceImpl(DeptDao deptDao) {
        this.deptDao = deptDao;
    }


    @Override
    public boolean addDept(SysDept sysDept) {
        return deptDao.addDept(sysDept);
    }

    @Override
    public SysDept queryById(Long id) {
        return deptDao.queryById(id);
    }

    @Override
    public List<SysDept> queryAll() {
        return deptDao.queryAll();
    }
}
