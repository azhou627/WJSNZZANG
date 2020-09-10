package com.wjsn.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ：zhoujiaqian
 * @date ：Created in 2020/8/22 15:16
 * @description： 用户实体类
 */

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "qq",length = 30)
    private String qq;    //qq号

    @Column(name = "income", length = 30)
    private Double income;   //个人总集资

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
