package com.bigbao.data.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/home")
@Controller
public class HomeController {

    @GetMapping("/index")
    @ResponseBody
    public String index(HttpServletRequest request){
        return "Hello Data!!!";
    }
}
