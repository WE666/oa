package com.oa.service.impl;

import com.oa.dao.DepartmentDao;
import com.oa.entity.Department;
import com.oa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lcyang
 * @Date 2018/7/15 12:01
 * @Description
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentDao departmentDao;

    public void add(Department department) {
        departmentDao.insert(department);
    }

    public void edit(Department department) {
        departmentDao.update(department);
    }

    public void remove(String num) {
        departmentDao.delete(num);
    }

    public Department get(String num) {
        return departmentDao.select(num);
    }

    public List<Department> getAll() {
        return departmentDao.selectAll();
    }
}
