package com.wjsn.vo;

import lombok.Data;

/**
 * @author ：zhoujiaqian
 * @date ：Created in 2020/11/15 21:20
 * @description：
 */
public class UserVo {
    private long id;
    private  String qq;
    private Double income;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }
}
