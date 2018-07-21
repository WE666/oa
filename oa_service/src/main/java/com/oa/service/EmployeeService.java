package com.oa.service;

import com.oa.entity.Employee;
import java.util.List;

public interface EmployeeService {
    void add(Employee employee);
    void edit(Employee employee);
    void remove(String num);
    Employee get(String num);
    List<Employee> getAll();
}
