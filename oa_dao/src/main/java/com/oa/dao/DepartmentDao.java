package com.oa.dao;

import com.oa.entity.Department;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository("departmentDao")
public interface DepartmentDao {
    void insert(Department department);
    void update(Department department);
    void delete(String num);
    Department select(String num);
    List<Department> selectAll();
}
