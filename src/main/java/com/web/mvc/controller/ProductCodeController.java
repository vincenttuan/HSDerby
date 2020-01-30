package com.web.mvc.controller;

import com.web.mvc.entity.ProductCode;
import com.web.mvc.repository.spec.DiscountCodeDao;
import com.web.mvc.repository.spec.ProductCodeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product_code")
public class ProductCodeController {
    
    @Autowired
    private ProductCodeDao dao;
    
    @Autowired
    private DiscountCodeDao dao_dc;
    
    @RequestMapping("/input")
    public String input(Model model) {
        ProductCode productCode = new ProductCode();
        
        model.addAttribute("productCode", productCode);
        model.addAttribute("list", dao.queryProductCode());
        model.addAttribute("list_dc", dao_dc.queryDiscountCode());
        model.addAttribute("action", "add");
        model.addAttribute("readonly", "false");
        return "product_code"; 
    }
    
    @RequestMapping("/add")
    public String add(@ModelAttribute ProductCode productCode) {
        dao.saveProductCode(productCode);
        return "redirect:./input";
    }
    
    @RequestMapping("/get/{code}")
    public String get(@PathVariable("code") String code, Model model) {
        ProductCode productCode = dao.getProductCode(code);
        
        model.addAttribute("productCode", productCode);
        model.addAttribute("list", dao.queryProductCode());
        model.addAttribute("list_dc", dao_dc.queryDiscountCode());
        model.addAttribute("action", "update");
        model.addAttribute("readonly", "true");
        return "product_code";
        
    }
    
    @RequestMapping("/update")
    public String update(@ModelAttribute ProductCode productCode) {
        dao.updateProductCode(productCode);
        return "redirect:./input";
    }
    
    @RequestMapping("/delete/{code}")
    public String delete(@PathVariable("code") String code) {
        dao.deleteProductCode(code);
        return "redirect:../input";
    }
    
}
