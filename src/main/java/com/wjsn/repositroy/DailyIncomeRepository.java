package com.wjsn.repositroy;

import com.wjsn.entity.DailyIncome;
import com.wjsn.vo.DayIncomeResult;
import com.wjsn.vo.MonthIncomeResult;
import com.wjsn.vo.WeekIncomeResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author ：zhoujiaqian
 * @date ：Created in 2020/8/22 16:01
 * @description： 油管日集资
 */

@Repository
public interface DailyIncomeRepository extends JpaRepository<DailyIncome, Long> {
    //返回集资列表
    @Transactional
    @Modifying
    @Query(value = "select * from dailyincome order by date desc , id desc",nativeQuery = true)
    List<DailyIncome> getAllData();

    //返回日涨幅
    @Transactional
    @Modifying
    @Query(value = "select date , sum(income) as income from dailyincome group by date order by date",nativeQuery = true)
    List<DayIncomeResult> getDayData();

    //返回月涨幅
    @Transactional
    @Modifying
    @Query(value = "select DATE_FORMAT(date,'%u') as week,sum(income) as income from dailyincome where DATE_FORMAT(date,'%Y')=2020  group by week order by week",nativeQuery = true)
    List<WeekIncomeResult> getWeekData();

    //返回月涨幅
    @Transactional
    @Modifying
    @Query(value = "select DATE_FORMAT(date,'%Y-%m') as month,sum(income) as income from dailyincome where DATE_FORMAT(date,'%Y')=2020  group by month order by month",nativeQuery = true)
    List<MonthIncomeResult> getMonthData();
}
