package com.oa.controller;

import com.oa.dto.ExpenseReportInfo;
import com.oa.entity.DealRecord;
import com.oa.entity.Employee;
import com.oa.global.Contant;
import com.oa.service.ExpenseReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author lcyang
 * @Date 2018/7/19 10:12
 * @Description
 */
@Controller
@RequestMapping("/expense_report")
public class ExpenseReportController {
    @Autowired
    private ExpenseReportService expenseReportService;

    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
        map.put("types", Contant.getTypes());
        map.put("info",new ExpenseReportInfo());
        return "expense_report_add";
    }
    @RequestMapping("/add")
    /** 不加注解的话要和上面的info保持一致 **/
    public String add(HttpSession session, ExpenseReportInfo info){
        Employee employee = (Employee)session.getAttribute("employee");
        info.getExpenseReport().setCreateNum(employee.getNum());
        expenseReportService.save(info.getExpenseReport(),info.getItems());
        return "redirect:detail?id="+info.getExpenseReport().getId();
    }
    @RequestMapping("/detail")
    public String detail(Map<String,Object> map,int id){
        map.put("expenseReport",expenseReportService.get(id));
        map.put("items",expenseReportService.getItems(id));
        map.put("records",expenseReportService.getRecords(id));
        return "expense_report_detail";
    }
    @RequestMapping("/self")
    public String self(Map<String,Object> map,HttpSession session){
        Employee employee = (Employee)session.getAttribute("employee");
        map.put("list",expenseReportService.getForSelf(employee.getNum()));
        return "expense_report_self";
    }
    @RequestMapping("/deal")
    public String deal(Map<String,Object> map,HttpSession session){
        Employee employee = (Employee)session.getAttribute("employee");
        map.put("list",expenseReportService.getForDeal(employee.getNum()));
        return "expense_report_deal";
    }
    @RequestMapping("/to_update")
    public String toUpdate(int id,Map<String,Object> map){
        map.put("type", Contant.getTypes());
        ExpenseReportInfo info = new ExpenseReportInfo();
        info.setExpenseReport(expenseReportService.get(id));
        info.setItems(expenseReportService.getItems(id));
        map.put("info",info);
        return "expense_report_update";
    }
    @RequestMapping("/update")
    /** 不加注解的话要和上面的info保持一致 **/
    public String Update(HttpSession session, ExpenseReportInfo info){
        Employee employee = (Employee)session.getAttribute("employee");
        info.getExpenseReport().setCreateNum(employee.getNum());
        expenseReportService.update(info.getExpenseReport(),info.getItems());
        return "redirect:deal";
    }
    @RequestMapping("/submit")
    public String submit(int id){
        expenseReportService.submit(id);
        return "redirect:deal";
    }
    @RequestMapping("/to_check")
    public String toCheck(int id,Map<String,Object> map){
        map.put("expenseReport",expenseReportService.get(id));
        map.put("items",expenseReportService.getItems(id));
        map.put("records",expenseReportService.getRecords(id));
        DealRecord dealRecord =new DealRecord();
        dealRecord.setExpenseReportId(id);
        map.put("record",dealRecord);
        return "expense_report_check";
    }
    @RequestMapping("/check")
    public String Check(HttpSession session, DealRecord dealRecord){
        Employee employee = (Employee)session.getAttribute("employee");
        dealRecord.setDealNum(employee.getNum());
        expenseReportService.check(dealRecord);
        return "redirect:deal";
    }
}
