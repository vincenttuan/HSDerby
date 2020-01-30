package com.web.mvc.controller;

import com.web.mvc.entity.DiscountCode;
import com.web.mvc.repository.spec.DiscountCodeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/discount_code")
public class DiscountCodeController {
    
    @Autowired
    private DiscountCodeDao dao;
    
    @RequestMapping("/input")
    public String input(Model model) {
        DiscountCode discountCode = new DiscountCode();
        
        model.addAttribute("discountCode", discountCode);
        model.addAttribute("list", dao.queryDiscountCode());
        model.addAttribute("action", "add");
        model.addAttribute("readonly", "false");
        return "discount_code"; // 轉跳到 /WEB-INF/jsp/discount_code.jsp
    }
    
    @RequestMapping("/add")
    public String add(@ModelAttribute DiscountCode discountCode) {
        dao.saveDiscountCode(discountCode);
        return "redirect:./input";
    }
    
    @RequestMapping("/get/{code}")
    public String get(@PathVariable("code") String code, Model model) {
        DiscountCode discountCode = dao.getDiscountCode(code);
        
        model.addAttribute("discountCode", discountCode);
        model.addAttribute("list", dao.queryDiscountCode());
        model.addAttribute("action", "update");
        model.addAttribute("readonly", "true");
        return "discount_code";
        
    }
    
    @RequestMapping("/update")
    public String update(@ModelAttribute DiscountCode discountCode) {
        dao.updateDiscountCode(discountCode);
        return "redirect:./input";
    }
    
    @RequestMapping("/delete/{code}")
    public String delete(@PathVariable("code") String code) {
        dao.deleteDiscountCode(code);
        return "redirect:../input";
    }
    
}
