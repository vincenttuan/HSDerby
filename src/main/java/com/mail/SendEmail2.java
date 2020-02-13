/** *********************************************************
 * 1. 在 pom.xml 中加入 :
 * <dependency>
 * <groupId>com.sun.mail</groupId>
 * <artifactId>javax.mail</artifactId>
 * <version>1.6.2</version>
 * </dependency>
 *
2. 申請應用程式密碼 https://security.google.com/settings/security/apppasswords
**********************************************************
 */
package com.mail;

import java.io.File;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

public class SendEmail2 {

    public static void main(String[] args) throws Exception {
        File file = new File("src/main/java/com/mail/content.html");
        String content = new Scanner(file).useDelimiter("\\A").next();
        System.out.println(content);
        
        file = new File("src/main/java/com/mail/emails.txt");
        String emails = new Scanner(file).useDelimiter("\\A").next();
        System.out.println(emails);
        
        sendEmail(content, emails);
        
    }
    
    public static void sendEmail(String content, String emails) throws Exception {
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
