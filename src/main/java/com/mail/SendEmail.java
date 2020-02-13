/***********************************************************
1. 在 pom.xml 中加入 :
<dependency>
    <groupId>com.sun.mail</groupId>
    <artifactId>javax.mail</artifactId>
    <version>1.6.2</version>
</dependency>

2. 申請應用程式密碼
https://security.google.com/settings/security/apppasswords
***********************************************************/

package com.mail;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

public class SendEmail {

    public static void main(String[] args) throws MessagingException {
        // 
        final String username = "vincenttuan@gmail.com";
        final String password = "授權密碼";
        
        // 
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        // 
        Session session;
        session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        // 
        Message message = new MimeMessage(session);
        // 
        message.setFrom(new InternetAddress("from@gmail.com"));
        
        message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse("vincenttuan@gmail.com, vincentjava@yahoo.com.tw")
        );
        
        // 
        message.setSubject("HS 測試信件");
        
        // 
        //message.setText("Dear Mail Crawler,\n\n Please do not spam my email!");
        
        // 
        message.setContent("Dear 顧客您好,"
                + "<p /><a href='http://localhost:8080/HSDerby/'>HS HSDerby 網址</a>"
                + "<p /> Please do not spam my email!", "text/html;charset=utf-8");
        
        // 
        Transport.send(message);

        System.out.println("信件發送成功 !");

    }

}
