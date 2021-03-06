package com.oa.controller;

import com.oa.entity.Employee;
import com.oa.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @Author lcyang
 * @Date 2018/7/18 17:39
 * @Description
 */
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpSession session, @RequestParam String num, @RequestParam String password){
        Employee employee = loginService.login(num,password);
        if (employee==null){
            return "redirect:to_login";
        }
        session.setAttribute("employee",employee);
        return "redirect:self";
    }
    @RequestMapping("/self")
    public String self(){
        return "self";
    }
    @RequestMapping("/quit")
    public String quit(HttpSession session){
        session.setAttribute("employee",null);
        return "redirect:to_login";
    }

    @RequestMapping("/to_change_password")
    public String toChangePassword(){
        return "change_password";
    }

    @RequestMapping("/change_password")
    public String changePassword(HttpSession session, @RequestParam String old, @RequestParam String new1,@RequestParam String new2){
        Employee employee = (Employee) session.getAttribute("employee");
        if (employee.getPassword().equals(old)){
            if (new1.equals(new2)){
                employee.setPassword(new1);
                loginService.changePassword(employee);
                return "redirect:self";
            }
        }
        return "redirect:to_change_password";
    }
}
