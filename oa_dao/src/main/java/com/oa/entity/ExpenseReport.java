package com.oa.entity;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

/**
 * @Author lcyang
 * @Date 2018/7/18 18:48
 * @Description 报销单
 */
public class ExpenseReport {
    private Integer id;
    /** 事由 **/
    private String cause;
    /** 创建者工号 **/
    private String createNum;
    /** 创建时间 **/
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date createTime;
    /** 待处理人工号 **/
    private String nextDealNum;
    /** 报销单总金额 **/
    private Double totalAmount;
    /** 报销单状态 **/
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getCreateNum() {
        return createNum;
    }

    public void setCreateNum(String createNum) {
        this.createNum = createNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNextDealNum() {
        return nextDealNum;
    }

    public void setNextDealNum(String nextDealNum) {
        this.nextDealNum = nextDealNum;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    /** 创建者 **/
    private Employee creater;
    /** 处理人 **/
    private Employee dealer;

    public Employee getCreater() {
        return creater;
    }

    public void setCreater(Employee creater) {
        this.creater = creater;
    }

    public Employee getDealer() {
        return dealer;
    }

    public void setDealer(Employee dealer) {
        this.dealer = dealer;
    }
}
