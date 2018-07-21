package com.oa.entity;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

/**
 * @Author lcyang
 * @Date 2018/7/18 19:08
 * @Description 处理记录
 */
public class DealRecord {
    private Integer id;
    /** 报销单编号 **/
    private Integer expenseReportId;
    /** 处理人工号 **/
    private String dealNum;
    /** 处理时间 **/
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date dealTime;
    /** 处理方式 **/
    private String dealWay;
    /** 处理结果 **/
    private String dealResult;
    /** 处理时的备注 **/
    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExpenseReportId() {
        return expenseReportId;
    }

    public void setExpenseReportId(Integer expenseReportId) {
        this.expenseReportId = expenseReportId;
    }

    public String getDealNum() {
        return dealNum;
    }

    public void setDealNum(String dealNum) {
        this.dealNum = dealNum;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public String getDealWay() {
        return dealWay;
    }

    public void setDealWay(String dealWay) {
        this.dealWay = dealWay;
    }

    public String getDealResult() {
        return dealResult;
    }

    public void setDealResult(String dealResult) {
        this.dealResult = dealResult;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    /** 在表现层展现处理人 **/
    private Employee dealer;

    public Employee getDealer() {
        return dealer;
    }

    public void setDealer(Employee dealer) {
        this.dealer = dealer;
    }
}
