package com.oa.dao;

import com.oa.entity.DealRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author lcyang
 * @Date 2018/7/18 19:22
 * @Description
 */
@Repository("dealRecordDao")
public interface DealRecordDao {
    void insert(DealRecord dealRecord);
    List<DealRecord> selectByExpenseReport(int expenseReportId);
}
