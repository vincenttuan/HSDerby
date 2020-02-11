package com.web.mvc.controller;

import com.web.mvc.entity.Product;
import com.web.mvc.repository.spec.ProductDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductInStockController {
    
    @Autowired
    private ProductDao dao;
    
    @RequestMapping("/product_in_stock")
    public String inStock(Model model) {
        List<Product> products = dao.queryProduct();
        model.addAttribute("products", products);
        return "product_in_stock";
    }
    
}
