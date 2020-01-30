package com.web.mvc.controller;

import com.web.mvc.entity.Customer;
import com.web.mvc.repository.spec.CustomerDao;
import com.web.mvc.repository.spec.DiscountCodeDao;
import com.web.mvc.repository.spec.MicroMarketDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    
    @Autowired
    private CustomerDao dao;
    
    @Autowired
    private DiscountCodeDao dao_dc;
    
    @Autowired
    private MicroMarketDao dao_mm;
    
    @RequestMapping("/input")
    public String input(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        model.addAttribute("list", dao.queryCustomer());
        model.addAttribute("list_dc", dao_dc.queryDiscountCode());
        model.addAttribute("list_mm", dao_mm.queryMicroMarket());
        model.addAttribute("action", "add");
        model.addAttribute("readonly", "false");
        return "customer"; // 轉跳到 /WEB-INF/jsp/customer.jsp
    }
    
    @RequestMapping(value="/add",produces = "application/json;charset=utf-8")
    //@ResponseBody
    public String add(@ModelAttribute Customer customer) {
        dao.saveCustomer(customer);
        return "redirect:./input";
        //return customer + "";
    }
    
    @RequestMapping("/get/{id}")
    public String get(@PathVariable("id") Integer id, Model model) {
        Customer customer = dao.getCustomer(id);
        model.addAttribute("customer", customer);
        model.addAttribute("list", dao.queryCustomer());
        model.addAttribute("list_dc", dao_dc.queryDiscountCode());
        model.addAttribute("list_mm", dao_mm.queryMicroMarket());
        model.addAttribute("action", "update");
        model.addAttribute("readonly", "true");
        return "customer"; // 轉跳到 /WEB-INF/jsp/customer.jsp
        
    }
    
    @RequestMapping("/update")
    public String update(@ModelAttribute Customer customer) {
        dao.updateCustomer(customer);
        return "redirect:./input";
    }
    
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        dao.deleteCustomer(id);
        return "redirect:../input";
    }
    
}
