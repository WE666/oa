package com.oa.service.impl;

import com.oa.dao.EmployeeDao;
import com.oa.entity.Employee;
import com.oa.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author lcyang
 * @Date 2018/7/18 17:31
 * @Description
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private EmployeeDao employeeDao;

    public Employee login(String num, String password) {
        Employee employee = employeeDao.select(num);
        if (employee!=null&&employee.getPassword().equals(password)){
            return employee;
        }
        return null;
    }

    public void changePassword(Employee employee) {
        employeeDao.update(employee);
    }
}
