package com.oa.controller;

import com.oa.entity.Department;
import com.oa.entity.Employee;
import com.oa.global.Contant;
import com.oa.service.DepartmentService;
import com.oa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @Author lcyang
 * @Date 2018/7/15 13:00
 * @Description
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        map.put("list",employeeService.getAll());
        return "employee_list";
    }
    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
        map.put("employee",new Employee());
        map.put("dlist",departmentService.getAll());
        map.put("plist", Contant.getPosts());
        return "employee_add";
    }
    @RequestMapping("/add")
    public String add(Employee employee){
        employeeService.add(employee);
        return "redirect:list";
    }
    @RequestMapping(value = "/to_update",params = "num")
    public String toUpdate(String num,Map<String,Object> map){
        map.put("employee",employeeService.get(num));
        map.put("dlist",departmentService.getAll());
        map.put("plist", Contant.getPosts());
        return "employee_update";
    }
    @RequestMapping("/update")
    public String update(Employee employee){
        employeeService.edit(employee);
        return "redirect:list";
    }
    @RequestMapping(value = "/remove",params = "num")
    public String remove(String num){
        employeeService.remove(num);
        return "redirect:list";
    }
}
