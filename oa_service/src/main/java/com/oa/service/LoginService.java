package com.oa.service;

import com.oa.entity.Employee;

public interface LoginService {
    Employee login(String num,String password);
    void changePassword(Employee employee);
}
