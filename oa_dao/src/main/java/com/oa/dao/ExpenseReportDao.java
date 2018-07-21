package com.oa.dao;

import com.oa.entity.ExpenseReport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author lcyang
 * @Date 2018/7/18 19:21
 * @Description
 */
@Repository("expenseReportDao")
public interface ExpenseReportDao {
    void insert(ExpenseReport expenseReport);
    void update(ExpenseReport expenseReport);
    void delete(int id);
    ExpenseReport select(int id);
    List<ExpenseReport> selectByCreateNum(String cnum);
    List<ExpenseReport> selectByNextDealNum(String dnum);


}
