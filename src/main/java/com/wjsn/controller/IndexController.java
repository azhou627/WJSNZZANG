package com.wjsn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：zhoujiaqian
 * @date ：Created in 2020/9/26 21:28
 * @description：
 */

@Controller
public class IndexController {

    @RequestMapping("/income")
    public String getIncome(){
        return "income";
    }

    @RequestMapping("/data")
    public String getData(){
        return "data";
    }

    @RequestMapping("/addIncome")
    public String getAddIncome(){
        return "addIncome";
    }

}
