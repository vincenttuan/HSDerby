package com.web.mvc.controller;

import com.web.mvc.repository.spec.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
    
    @Autowired
    MemberDao dao;
    
    @RequestMapping("/query")
    public String query(Model model) {
        model.addAttribute("list", dao.query());
        return "member";
    }
    
}
