package com.web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home")
public class HomeController {
    
    @RequestMapping("/john")
    @ResponseBody
    public String john() {
        return "Hello John";
    }
    
    @RequestMapping(value = {"/mary/100", "/mary/200", "/mary/300"})
    @ResponseBody
    public String mary() {
        return "Hello Mary";
    }
    
    @RequestMapping("/tom/*")
    @ResponseBody
    public String tom() {
        return "Hello Tom";
    }
    
    @RequestMapping("/pow/{num}")
    @ResponseBody
    public Double pow(@PathVariable("num") double num) {
        return Math.pow(num, 2);
    }
    
    @RequestMapping("/bmi/{h}/{w}")
    @ResponseBody
    public Double bmi(@PathVariable("h") double h, @PathVariable("w") double w) {
        return w / Math.pow(h/100, 2);
    }
    
    @RequestMapping("/bmi_report/{h}/{w}")
    public String bmiReport(@PathVariable("h") double h, @PathVariable("w") double w) {
        double bmi = w / Math.pow(h/100, 2);
        
        return "bmi_report"; // 會去指向 /WEB-INF/jsp/bmi_report.jsp
    }
    
    
}
