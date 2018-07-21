package com.oa.dao;

import com.oa.entity.ExpenseReportItem;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author lcyang
 * @Date 2018/7/18 19:22
 * @Description
 */
@Repository("expenseReportItemDao")
public interface ExpenseReportItemDao {
    void insert(ExpenseReportItem expenseReportItem);
    void update(ExpenseReportItem expenseReportItem);
    void delete(int id);
    List<ExpenseReportItem> selectByExpenseReport(int expenseReportId);
}
