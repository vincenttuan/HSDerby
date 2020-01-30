package com.web.mvc.controller;

import com.web.mvc.entity.Manufacturer;
import com.web.mvc.entity.MicroMarket;
import com.web.mvc.repository.spec.ManufacturerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manufacturer")
public class ManufacturerController {
    
    @Autowired
    ManufacturerDao dao;
    
    @RequestMapping("/input")
    public String input(Model model) {
        Manufacturer manufacturer = new Manufacturer();
        model.addAttribute("manufacturer", manufacturer);
        model.addAttribute("list", dao.queryManufacturer());
        model.addAttribute("action", "add");
        model.addAttribute("readonly", "false");
        return "manufacturer";
    }
    
    @RequestMapping("/add")
    public String add(@ModelAttribute Manufacturer manufacturer) {
        dao.saveManufacturer(manufacturer);
        return "redirect:./input";
    }
    
    @RequestMapping("/get/{id}")
    public String get(@PathVariable("id") Integer id, Model model) {
        Manufacturer manufacturer = dao.getManufacturer(id);
        
        model.addAttribute("manufacturer", manufacturer);
        model.addAttribute("list", dao.queryManufacturer());
        model.addAttribute("action", "update");
        model.addAttribute("readonly", "true");
        return "manufacturer";
        
    }
    
    @RequestMapping("/update")
    public String update(@ModelAttribute Manufacturer manufacturer) {
        dao.updateManufacturer(manufacturer);
        return "redirect:./input";
    }
    
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        dao.deleteManufacturer(id);
        return "redirect:../input";
    }
    
}
