package com.oa.service.impl;

import com.oa.dao.DealRecordDao;
import com.oa.dao.EmployeeDao;
import com.oa.dao.ExpenseReportDao;
import com.oa.dao.ExpenseReportItemDao;
import com.oa.entity.DealRecord;
import com.oa.entity.Employee;
import com.oa.entity.ExpenseReport;
import com.oa.entity.ExpenseReportItem;
import com.oa.global.Contant;
import com.oa.service.ExpenseReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author lcyang
 * @Date 2018/7/19 9:49
 * @Description
 */
@Service("expenseReportService")
public class ExpenseReportServiceImpl implements ExpenseReportService {
    @Autowired
    private ExpenseReportDao expenseReportDao;
    @Autowired
    private ExpenseReportItemDao expenseReportItemDao;
    @Autowired
    private DealRecordDao dealRecordDao;
    @Autowired
    private EmployeeDao employeeDao;

    public void save(ExpenseReport expenseReport, List<ExpenseReportItem> expenseReportItems) {
        expenseReport.setCreateTime(new Date());
        expenseReport.setNextDealNum(expenseReport.getCreateNum());
        expenseReport.setStatus(Contant.CLAIMVOUCHER_CREATED);
        expenseReportDao.insert(expenseReport);
        for (ExpenseReportItem item:expenseReportItems){
            item.setExpenseReportId(expenseReport.getId());
            expenseReportItemDao.insert(item);
        }
    }

    public ExpenseReport get(int id) {
        return expenseReportDao.select(id);
    }

    public List<ExpenseReportItem> getItems(int expenseReportId) {
        return expenseReportItemDao.selectByExpenseReport(expenseReportId);
    }

    public List<DealRecord> getRecords(int expenseReportId) {
        return dealRecordDao.selectByExpenseReport(expenseReportId);
    }

    public List<ExpenseReport> getForSelf(String num) {
        return expenseReportDao.selectByCreateNum(num);
    }

    public List<ExpenseReport> getForDeal(String num) {
        return expenseReportDao.selectByNextDealNum(num);
    }

    public void update(ExpenseReport expenseReport, List<ExpenseReportItem> expenseReportItems) {
        expenseReport.setNextDealNum(expenseReport.getCreateNum());
        expenseReport.setStatus(Contant.CLAIMVOUCHER_CREATED);
        expenseReportDao.update(expenseReport);

        List<ExpenseReportItem> olds =  expenseReportItemDao.selectByExpenseReport(expenseReport.getId());
        for (ExpenseReportItem old:olds){
            boolean isHave=false;
           for (ExpenseReportItem item:expenseReportItems){
               if (item.getId()==old.getId()){
                   isHave=true;
                   break;
               }
           }
           if (!isHave){
               expenseReportItemDao.delete(old.getId());
           }
        }
        for (ExpenseReportItem item:expenseReportItems){
            /** 为item设置报销单Id，否则修改数据时新增item会报空指针异常 **/
            item.setExpenseReportId(expenseReport.getId());
            if (item.getId()>0 && item.getId()!=null){
                expenseReportItemDao.update(item);
            }else {
                expenseReportItemDao.insert(item);
            }
        }
    }

    /** 提交 **/
    public void submit(int id) {
        ExpenseReport expenseReport = expenseReportDao.select(id);
        Employee employee = employeeDao.select(expenseReport.getCreateNum());

        expenseReport.setStatus(Contant.CLAIMVOUCHER_SUBMIT);
        expenseReport.setNextDealNum(employeeDao.selectByDepartmentAndPost(employee.getDepartmentNum(),Contant.POST_FM).get(0).getNum());
        expenseReportDao.update(expenseReport);

        /** 保存记录 **/
        DealRecord dealRecord = new DealRecord();
        dealRecord.setDealNum(employee.getNum());
        dealRecord.setDealTime(new Date());
        dealRecord.setDealResult(Contant.CLAIMVOUCHER_SUBMIT);
        dealRecord.setDealWay(Contant.DEAL_SUBMIT);
        dealRecord.setExpenseReportId(id);
        dealRecord.setComment("无");
        dealRecordDao.insert(dealRecord);
    }

    /** 审核 **/
    // TODO
    public void check(DealRecord dealRecord) {
        ExpenseReport expenseReport = expenseReportDao.select(dealRecord.getExpenseReportId());
        Employee employee = employeeDao.select(dealRecord.getDealNum());
        dealRecord.setDealTime(new Date());
        /** 根据处理方式判断 **/
        /** 通过审核 **/
        if (dealRecord.getDealWay().equals(Contant.DEAL_PASS)){
            if (expenseReport.getTotalAmount()<=Contant.LIMIT_CHECK || employee.getPost().equals(Contant.POST_GM)){
                expenseReport.setStatus(Contant.CLAIMVOUCHER_APPROVED);
                expenseReport.setNextDealNum(employeeDao.selectByDepartmentAndPost(null,Contant.POST_CASHIER).get(0).getNum());
                dealRecord.setDealResult(Contant.CLAIMVOUCHER_APPROVED);
            }else {
                expenseReport.setStatus(Contant.CLAIMVOUCHER_RECHECK);
                expenseReport.setNextDealNum(employeeDao.selectByDepartmentAndPost(null,Contant.POST_GM).get(0).getNum());
                dealRecord.setDealResult(Contant.CLAIMVOUCHER_RECHECK);
            }
        }
        /** 打回 **/
        else if (dealRecord.getDealWay().equals(Contant.DEAL_BACK)){
            expenseReport.setStatus(Contant.CLAIMVOUCHER_BACK);
            expenseReport.setNextDealNum(expenseReport.getCreateNum());
            dealRecord.setDealResult(Contant.CLAIMVOUCHER_BACK);
        }
        /** 打款 **/
        else if (dealRecord.getDealWay().equals(Contant.DEAL_PAID)){
            expenseReport.setStatus(Contant.CLAIMVOUCHER_PAID);
            expenseReport.setNextDealNum(null);
            dealRecord.setDealResult(Contant.CLAIMVOUCHER_PAID);
        }
        /** 拒绝 **/
        else if (dealRecord.getDealWay().equals(Contant.DEAL_REJECT)){
            expenseReport.setStatus(Contant.CLAIMVOUCHER_TERMINATED);
            expenseReport.setNextDealNum(null);
            dealRecord.setDealResult(Contant.CLAIMVOUCHER_TERMINATED);
        }
        expenseReportDao.update(expenseReport);
        dealRecordDao.insert(dealRecord);
    }
}
