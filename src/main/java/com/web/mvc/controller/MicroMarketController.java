package com.web.mvc.controller;

import com.google.gson.Gson;
import com.web.mvc.entity.MicroMarket;
import com.web.mvc.repository.spec.MicroMarketDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/micro_market")
public class MicroMarketController {
    
    @Autowired
    MicroMarketDao dao;
    
    @RequestMapping("/input")
    public String input(Model model) {
        MicroMarket microMarket = new MicroMarket();
        model.addAttribute("microMarket", microMarket);
        model.addAttribute("list", dao.queryMicroMarket());
        model.addAttribute("action", "add");
        model.addAttribute("readonly", "false");
        return "micro_market"; // 轉跳到 /WEB-INF/jsp/micro_market.jsp
    }
    
    @RequestMapping("/add")
    public String add(@ModelAttribute MicroMarket mm) {
        dao.saveMicroMarket(mm);
        return "redirect:./input";
    }
    
    @RequestMapping("/get/{code}")
    public String get(@PathVariable("code") String code, Model model) {
        MicroMarket microMarket = dao.getMicroMarket(code);
        
        model.addAttribute("microMarket", microMarket);
        model.addAttribute("list", dao.queryMicroMarket());
        model.addAttribute("action", "update");
        model.addAttribute("readonly", "true");
        return "micro_market"; // 轉跳到 /WEB-INF/jsp/micro_market.jsp
        
    }
    
    @RequestMapping("/update")
    public String update(@ModelAttribute MicroMarket microMarket) {
        dao.updateMicroMarket(microMarket);
        return "redirect:./input";
    }
    
    @RequestMapping("/delete/{code}")
    public String delete(@PathVariable("code") String code) {
        dao.deleteMicroMarket(code);
        return "redirect:../input";
    }
    
}
