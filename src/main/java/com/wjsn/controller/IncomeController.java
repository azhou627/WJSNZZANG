package com.wjsn.controller;

import com.wjsn.entity.DailyIncome;
import com.wjsn.entity.User;
import com.wjsn.repositroy.DailyIncomeRepository;
import com.wjsn.repositroy.UserRepository;
import com.wjsn.util.JsonResult;
import com.wjsn.vo.IncomeList;
import com.wjsn.vo.DayIncomeResult;
import com.wjsn.vo.MonthIncomeResult;
import com.wjsn.vo.WeekIncomeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ：zhoujiaqian
 * @date ：Created in 2020/8/22 16:03
 * @description：油管集资
 */

@RestController
@RequestMapping("/income")
public class IncomeController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    DailyIncomeRepository dailyIncomeRepository;

    @GetMapping("/addincome.html")
    public String add(){
        return "/addincome";
    }

    //添加单笔集资记录
    @RequestMapping("/addincome")
    public JsonResult addIncome(HttpServletRequest request) throws ParseException {
        DailyIncome dailyIncome = new DailyIncome();
        dailyIncome.setQq(request.getParameter("qq"));
        dailyIncome.setIncome(Double.valueOf(request.getParameter("income")));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        Date date = simpleDateFormat.parse(request.getParameter("date"));
        dailyIncome.setDate(date);
        dailyIncomeRepository.save(dailyIncome);
        if(userRepository.findByQq(dailyIncome.getQq()) == null){
            User u = new User();
            u.setQq(dailyIncome.getQq());
            u.setIncome(dailyIncome.getIncome());
            userRepository.save(u);
        } else {
            userRepository.updateByQq(dailyIncome.getQq(),dailyIncome.getIncome());
        }
        List<DailyIncome> result = dailyIncomeRepository.getAllData();
        return new JsonResult(result);
    }

    //获取个人集资排名
    @RequestMapping("/getRank")
    public JsonResult getRank(){
        List<User> users = userRepository.findAllByOrderByIncomeDesc();
        for (User u : users){
            StringBuffer str = new StringBuffer(u.getQq());
            str.replace(1,5,"****");
            u.setQq(String.valueOf(str));
        }
        return new JsonResult(users);
    }

    //获取每天的涨幅
    @RequestMapping("/day")
    public JsonResult getDay(){
        List<IncomeList> result = new ArrayList<>();
        List<DayIncomeResult> dayList = dailyIncomeRepository.getDayData();
        for (DayIncomeResult in : dayList){
            IncomeList incomeList = new IncomeList();
            incomeList.setDate(in.getDate());
            incomeList.setIncome(in.getIncome());
            result.add(incomeList);
        }
        return new JsonResult(result);
    }

    //获取每周涨幅
    @RequestMapping("/week")
    public JsonResult getWeek(){
        List<IncomeList> result = new ArrayList<>();
        List<WeekIncomeResult> weekList = dailyIncomeRepository.getWeekData();
        for (WeekIncomeResult in : weekList){
            IncomeList incomeList = new IncomeList();
            incomeList.setDate(in.getWeek());
            incomeList.setIncome(in.getIncome());
            result.add(incomeList);
        }
        return new JsonResult(result);
    }

    //获取月涨幅
    @RequestMapping("/month")
    public JsonResult getMonth(){
        List<IncomeList> result = new ArrayList<>();
        List<MonthIncomeResult> monthList = dailyIncomeRepository.getMonthData();
        for (MonthIncomeResult in : monthList){
            IncomeList incomeList = new IncomeList();
            incomeList.setDate(in.getMonth());
            incomeList.setIncome(in.getIncome());
            result.add(incomeList);
        }
        return new JsonResult(result);
    }
}
