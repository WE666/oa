package com.oa.controller;

import com.oa.entity.Department;
import com.oa.service.DepartmentService;
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
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        map.put("list",departmentService.getAll());
        return "department_list";
    }
    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
        map.put("department",new Department());
        return "department_add";
    }
    @RequestMapping("/add")
    public String add(Department department){
        departmentService.add(department);
        return "redirect:list";
    }
    @RequestMapping(value = "/to_update",params = "num")
    public String toUpdate(String num,Map<String,Object> map){
        map.put("department",departmentService.get(num));
        return "department_update";
    }
    @RequestMapping("/update")
    public String update(Department department){
        departmentService.edit(department);
        return "redirect:list";
    }
    @RequestMapping(value = "/remove",params = "num")
    public String remove(String num){
        departmentService.remove(num);
        return "redirect:list";
    }
}
