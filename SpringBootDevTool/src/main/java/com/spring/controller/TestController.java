package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        int a=31;
        int b=55;
        int c=90;
        return "<h1>Testing!! /t sum of a and b and c is "+(a+b+c)+"</h1>";
    }

}
