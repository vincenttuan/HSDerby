package com.web.mvc.controller;

import com.web.mvc.repository.spec.ChartDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chart")
public class ChartController {
    
    @Autowired
    private ChartDao dao;
    
    @RequestMapping("/product/quantity/{chart}")
    public String queryProductQuantity(Model model, @PathVariable("chart") String chart) {
        List list = dao.queryProductQuantity();
        model.addAttribute("list", list);
        model.addAttribute("h", 1000);
        model.addAttribute("w", 1500);
        model.addAttribute("chart", chart); //BarChart, ColumnChart, PieChart, LineChart
        return "chart_product";
    }
    
}
