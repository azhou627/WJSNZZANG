package com.wjsn.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author ：zhoujiaqian
 * @date ：Created in 2020/8/22 15:21
 * @description：油管日集资
 */

@Entity
@Table(name = "dailyincome")
public class DailyIncome {
    @Id
    @Column(name = "id")
    private long id;        //集资id

    @Column(name = "qq",length = 30)
    private String qq;      //qq号

    @Column(name = "income",length = 50)
    private Double income;   //单笔集资

    @Column(name = "date")
    private Date date;      //日期

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
