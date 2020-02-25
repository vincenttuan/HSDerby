package com.web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UploadFileController {
    
    @GetMapping("/")
    public String input() {
        return "uploadfile";
    }
    
    @PostMapping("/submit")
    @ResponseBody
    public String submit(@RequestParam("file") MultipartFile file) {
        return "Upload OK !";
    }
    
    
}
