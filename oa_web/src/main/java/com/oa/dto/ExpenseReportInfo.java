package com.oa.dto;

import com.oa.entity.ExpenseReport;
import com.oa.entity.ExpenseReportItem;

import java.util.List;

/**
 * @Author lcyang
 * @Date 2018/7/19 10:08
 * @Description
 */
public class ExpenseReportInfo {
    private ExpenseReport expenseReport;
    private List<ExpenseReportItem> items;

    public ExpenseReport getExpenseReport() {
        return expenseReport;
    }

    public void setExpenseReport(ExpenseReport expenseReport) {
        this.expenseReport = expenseReport;
    }

    public List<ExpenseReportItem> getItems() {
        return items;
    }

    public void setItems(List<ExpenseReportItem> items) {
        this.items = items;
    }
}
