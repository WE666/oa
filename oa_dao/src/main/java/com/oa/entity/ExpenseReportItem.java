package com.oa.entity;

/**
 * @Author lcyang
 * @Date 2018/7/18 19:04
 * @Description 报销单条目
 */
public class ExpenseReportItem {
    private Integer id;
    /** 报销单编号 **/
    private Integer expenseReportId;
    /** 花销类型 **/
    private String item;
    /** 报销单金额 **/
    private Double amount;
    /** 说明 **/
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

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
