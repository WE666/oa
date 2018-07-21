package com.oa.dao;

import com.oa.entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository("employeeDao")
public interface EmployeeDao {
    void insert(Employee employee);
    void update(Employee employee);
    void delete(String num);
    Employee select(String num);
    List<Employee> selectAll();
    /** 根据部门和职位查询出部门经理  参数注解便于映射文件调用**/
    List<Employee> selectByDepartmentAndPost(@Param("num") String num, @Param("post") String post);
}
