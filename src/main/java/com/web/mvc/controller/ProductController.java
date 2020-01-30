package com.web.mvc.controller;

import com.web.mvc.entity.Product;
import com.web.mvc.repository.spec.ManufacturerDao;
import com.web.mvc.repository.spec.ProductCodeDao;
import com.web.mvc.repository.spec.ProductDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    private ProductDao dao;
    
    @Autowired
    private ManufacturerDao dao_mf;
    
    @Autowired
    private ProductCodeDao dao_pc;
    
    @RequestMapping("/input")
    public String input(Model model) {
        Product product = new Product();
        
        model.addAttribute("product", product);
        model.addAttribute("list", dao.queryProduct());
        model.addAttribute("list_mf", dao_mf.queryManufacturer());
        model.addAttribute("list_pc", dao_pc.queryProductCode());
        model.addAttribute("action", "add");
        model.addAttribute("readonly", "false");
        return "product"; 
    }
    
    @RequestMapping("/add")
    public String add(@ModelAttribute Product product) {
        dao.saveProduct(product);
        return "redirect:./input";
    }
    
    @RequestMapping("/get/{id}")
    public String get(@PathVariable("id") Integer id, Model model) {
        Product product = dao.getProduct(id);
        
        model.addAttribute("product", product);
        model.addAttribute("list", dao.queryProduct());
        model.addAttribute("list_mf", dao_mf.queryManufacturer());
        model.addAttribute("list_pc", dao_pc.queryProductCode());
        model.addAttribute("action", "update");
        model.addAttribute("readonly", "true");
        return "product";
        
    }
    
    @RequestMapping("/update")
    public String update(@ModelAttribute Product product) {
        dao.updateProduct(product);
        return "redirect:./input";
    }
    
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        dao.deleteProduct(id);
        return "redirect:../input";
    }
    
}
