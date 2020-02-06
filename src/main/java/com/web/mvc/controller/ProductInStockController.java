package com.web.mvc.controller;

import com.web.mvc.entity.Product;
import com.web.mvc.repository.spec.ProductDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class ProductInStockController {
    
    @Autowired
    private ProductDao dao;
    
    public String inStock(Model model) {
        List<Product> products = dao.queryProduct();
        model.addAttribute("products", products);
        return "product_in_stock";
    }
    
}
