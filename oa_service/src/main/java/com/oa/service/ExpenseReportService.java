package com.oa.service;

import com.oa.entity.DealRecord;
import com.oa.entity.ExpenseReport;
import com.oa.entity.ExpenseReportItem;

import java.util.List;

public interface ExpenseReportService {
    /** 保存报销单中包含条目信息 **/
    void save(ExpenseReport expenseReport, List<ExpenseReportItem> expenseReportItems);
    /** 查询报销单 **/
    ExpenseReport get(int id);
    /** 查询报销单条目信息 **/
    List<ExpenseReportItem> getItems(int expenseReportId);
    /** 查询审核记录 **/
    List<DealRecord> getRecords(int expenseReportId);

    /** 查询个人报销单 **/
    List<ExpenseReport> getForSelf(String num);
    /** 查询待处理报销单 **/
    List<ExpenseReport> getForDeal(String num);

    /** 修改报销单 **/
    void update(ExpenseReport expenseReport, List<ExpenseReportItem> expenseReportItems);

    /** 提交报销单 **/
    void submit(int id);

    /** 审核报销单 **/
    void check(DealRecord dealRecord);
}
