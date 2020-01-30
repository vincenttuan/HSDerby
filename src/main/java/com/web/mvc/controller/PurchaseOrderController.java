package com.web.mvc.controller;

import com.web.mvc.entity.PurchaseOrder;
import com.web.mvc.repository.spec.CustomerDao;
import com.web.mvc.repository.spec.ProductDao;
import com.web.mvc.repository.spec.PurchaseOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/purchase_order")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderDao dao;
    
    @Autowired
    private CustomerDao dao_c;
    
    @Autowired
    private ProductDao dao_p;
    
    @RequestMapping("/input")
    public String input(Model model) {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        
        model.addAttribute("purchaseOrder", purchaseOrder);
        model.addAttribute("list", dao.queryPurchaseOrder());
        model.addAttribute("list_c", dao_c.queryCustomer());
        model.addAttribute("list_p", dao_p.queryProduct());
        model.addAttribute("action", "add");
        model.addAttribute("readonly", "false");
        return "purchase_order"; 
    }
    
    @RequestMapping("/add")
    public String add(@ModelAttribute PurchaseOrder purchaseOrder) {
        dao.savePurchaseOrder(purchaseOrder);
        return "redirect:./input";
    }
    
    @RequestMapping("/get/{num}")
    public String get(@PathVariable("num") Integer num, Model model) {
        PurchaseOrder purchaseOrder = dao.getPurchaseOrder(num);
        
        model.addAttribute("purchaseOrder", purchaseOrder);
        model.addAttribute("list", dao.queryPurchaseOrder());
        model.addAttribute("list_c", dao_c.queryCustomer());
        model.addAttribute("list_p", dao_p.queryProduct());
        model.addAttribute("action", "update");
        model.addAttribute("readonly", "true");
        return "purchase_order";
        
    }
    
    @RequestMapping("/update")
    public String update(@ModelAttribute PurchaseOrder purchaseOrder) {
        dao.updatePurchaseOrder(purchaseOrder);
        return "redirect:./input";
    }
    
    @RequestMapping("/delete/{num}")
    public String delete(@PathVariable("num") Integer num) {
        dao.deletePurchaseOrder(num);
        return "redirect:../input";
    }
    


}
