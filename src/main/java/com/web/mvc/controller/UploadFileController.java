package com.web.mvc.controller;

import com.web.mvc.entity.Member;
import com.web.mvc.repository.spec.LoginDao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    LoginDao dao;
    
    @GetMapping("/")
    public String input() {
        return "uploadfile";
    }
    
    @PostMapping("/submit")
    @ResponseBody
    public String submit(@RequestParam("file") MultipartFile file) {
        StringBuilder sb = new StringBuilder();
        File f = null;
        try {
            f = File.createTempFile("tmp", null);
            file.transferTo(f);
            f.deleteOnExit(); //使用完成刪除檔案
            FileReader fr = new FileReader(f);
            
            char[] buffer = new char[1];
            while (fr.read(buffer) != -1) {                
                sb.append(buffer);
            }
            
            // 將字串透過 \n 切分
            String[] rows = sb.toString().split("\n");
            for(String row : rows) {
                System.out.println(row);
                // a01,aaa,a01@java.com,1
                String[] array = row.split(",");
                String username = array[0].trim();
                String password = array[1].trim();
                String email = array[2].trim();
                Integer priority = Integer.valueOf(array[3].trim());
                
                Member member = new Member();
                member.setUsername(username);
                member.setPassword(password);
                member.setEmail(email);
                member.setPriority(priority);
                member.setCode(Integer.toHexString(member.hashCode()));
                member.setPass(Boolean.TRUE);
                
                // 存入資料庫
                dao.save(member);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Upload OK !";
    }
    
    
}
