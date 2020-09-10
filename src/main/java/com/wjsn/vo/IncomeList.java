package com.wjsn.vo;

import java.util.Date;

/**
 * @author ：zhoujiaqian
 * @date ：Created in 2020/8/23 21:48
 * @description： 涨幅VO
 */
public class IncomeList {
    private String date;   //日期
    private Double income;   //涨幅

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }
}
