package com.oa.service.impl;

import com.oa.dao.EmployeeDao;
import com.oa.entity.Employee;
import com.oa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lcyang
 * @Date 2018/7/17 11:25
 * @Description
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public void add(Employee employee) {
        employee.setPassword("000000");
        employeeDao.insert(employee);
    }

    public void edit(Employee employee) {
        employeeDao.update(employee);
    }

    public void remove(String num) {
        employeeDao.delete(num);
    }

    public Employee get(String num) {
        return employeeDao.select(num);
    }

    public List<Employee> getAll() {
        return employeeDao.selectAll();
    }
}
