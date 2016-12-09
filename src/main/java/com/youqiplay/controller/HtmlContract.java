package com.youqiplay.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/12/8.
 */
@Controller
public class HtmlContract {

//    @Value("${com.youqiplay.cdn.login.css}")
//    private String loginCss;

    @RequestMapping("/login")
    public String login() {
        return "forward:/viewCF/login.html";
    }

    //    @RequestMapping("/css/login")
//    public String cssLogin() {
//        System.out.println(loginCss);
//        return "forward:/"+loginCss;
//    }
    @RequestMapping("/index.do")
    public String index() {
        return "forward:/viewCF/index.html";
    }


}
