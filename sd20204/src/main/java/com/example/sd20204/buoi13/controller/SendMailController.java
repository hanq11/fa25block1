package com.example.sd20204.buoi13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/send-mail")
public class SendMailController {
    @Autowired
    JavaMailSender javaMailSender;

    @GetMapping("/send")
    @ResponseBody
    public void sendMail() {
        String[] list = {"hoangbvph32141@fpt.edu.vn","hainv17082004@gmail.com","ducanh0962092979@gmail.com","fxxng.0910@gmail.com","thanganh0606@gmail.com","nguyenthanhdan0310@gmail.com","kietnguyen23117@gmail.com","dinhtung2517@gmail.com","plonggiang220407@gmail.com","khuatanhngoc6@gmail.com","cd5501733@gmail.com","tuankiet121107@gmail.com","suncake1952@gmail.com","vuquanghanoi2608@gmail.com","giakhanhnguyen0401@gmail.com","tongankhang0407@gmail.com","doanbaokhanh14052004@gmail.com","goldakai21@gmail.com","baopngth03747@gmail.com","dan2007hito@gmail.com","miyanoakemi0509@gmail.com","nguyenhieuphong2k7@gmail.com","phongvth0910@gmail.com","trunghieu0811307@gmail.com","tmy3807@gmail.com","tunguyen12122007@gmail.com","letuanh819@gmail.com","thanhan123ap@gmail.com","dangtranminhphu93@gmail.com","thienhuong200720132019@gmail.com"};
        for(String mail: list) {
            try {
                SimpleMailMessage sms = new SimpleMailMessage();
//                sms.setFrom("");
                sms.setTo(mail);
                sms.setSubject("Hello World");
                sms.setText("SD20204");
                javaMailSender.send(sms);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
