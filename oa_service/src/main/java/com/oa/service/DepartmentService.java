package com.oa.service;

import com.oa.entity.Department;

import java.util.List;

public interface DepartmentService {
    void add(Department department);
    void edit(Department department);
    void remove(String num);
    Department get(String num);
    List<Department> getAll();
}
