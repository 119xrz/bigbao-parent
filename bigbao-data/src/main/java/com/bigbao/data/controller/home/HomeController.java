package com.bigbao.data.controller.home;

import com.bigbao.data.beans.HistoryBean;
import com.bigbao.data.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RequestMapping("/home")
@Controller
public class HomeController {

    @Autowired
    HistoryService historyService;

    @GetMapping("/index")
    @ResponseBody
    public String index(HttpServletRequest request){
        return "Hello Data!!!";
    }

    @GetMapping("/query")
    @ResponseBody
    public Object query(HttpServletRequest request){

        return historyService.findAll();
    }

    @GetMapping("save")
    @ResponseBody
    public String save(HttpServletRequest request){
        HistoryBean historyBean = new HistoryBean();
        historyBean.setKeyword("123123123123");
        historyBean.setHitRuleCount(1);
        historyBean.setNodeCount(1);
        historyBean.setRiskLevel(1);
        historyBean.setRiskNodeCount(1);
        historyBean.setSelectDate(new Date());
        historyService.saveHistory(historyBean);
        return "success";
    }
}
