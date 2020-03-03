package com.web.mvc.controller;

import com.web.mvc.entity.Member;
import com.web.mvc.repository.spec.LoginDao;
import com.web.mvc.validator.MemberValidator;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {
    
    @Autowired
    LoginDao dao;
    
    @Autowired
    MemberValidator validator;
    
    @RequestMapping("/input")
    public String input(Model model) {
        Member member = new Member();
        model.addAttribute("member", member);
        return "login";
    }
    
    @RequestMapping("/in")
    public String login(@ModelAttribute Member member) {
        boolean check = dao.login(member.getUsername(), member.getPassword(), member.getBase64());
        if(check)
            return "index";
        else
            return "login";
    }
    
    
    @RequestMapping("/save")
    public String save(@ModelAttribute Member member, BindingResult result) {
        validator.validate(member, result);
        if(result.hasErrors()) {
            return "login";
        }
        
        String code = Integer.toHexString(member.hashCode());
        member.setCode(code);
        member.setPriority(1);
        member.setPass(Boolean.FALSE);
        dao.save(member);
        try {
            sendEmail(member.getEmail(), member.getUsername(), member.getCode());
        } catch (Exception e) {
            System.out.println("Email 發送失敗, " + e);
        }
        return "redirect:./input";
    }
    
    @RequestMapping("/verify/{username}/{code}")
    @ResponseBody
    public String verify(@PathVariable("username") String username, @PathVariable("code") String code) {
        boolean check = dao.verifyEmailCode(username, code);
        return "verify: " + check;
    }
    
    
    public void sendEmail(String emails, String uname, String code) throws Exception {
        String url = "http://localhost:8080/HSDerby/mvc/login/verify/%s/%s";
        url = String.format(url, uname, code);
        
        String content = "<html><a href='%s'>Email確認授權</a></html>";
        content = String.format(content, url);
        
        // Gmail 與 授權碼(非 Google 密碼)
        final String username = "vincenttuan@gmail.com";
        final String password = "bngqelfxvxkkqejo";

        // smpt 設定資訊
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        // 會話建立與 smtp 溝通
        Session session;
        session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        
        // 建立 Email 實體
        Message message = new MimeMessage(session);
        
        // 發文者 一定會是你的 username
        InternetAddress ia = new InternetAddress("from@gmail.com");
        ia.setPersonal("HaHaHa");
        message.setFrom(ia);
        
        // 受文者
        message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(emails)
        );
        
        // Email 抬頭
        message.setSubject("HS 測試信件");

        // Email 內容純文字
        //message.setText("Dear Mail Crawler,\n\n Please do not spam my email!");
        
        // Email 內容 HTML
        message.setContent(content, "text/html;charset=utf-8");

        // 發送 email
        Transport.send(message);

        System.out.println("信件發送成功 !");
    }
    
}
