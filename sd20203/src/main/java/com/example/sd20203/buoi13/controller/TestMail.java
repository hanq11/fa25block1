package com.example.sd20203.buoi13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test-mail")
public class TestMail {
    @Autowired
    JavaMailSender javaMailSender;

    @GetMapping("/send")
    @ResponseBody
    public void sendMail() {
        String[] email = {"dinhquangduy20042007@gmail.com","fooddie076@gmail.com","ngocbachbui77@gmail.com","beanmtd@gmail.com","tonyduy17727@gmail.com","daogiahien83@gmail.com","cokhacminhduc@gmail.com","truonglelamquyet12@gmail.com","hongduc07@gmail.com","trongnd24082007@gmail.com","phamquochuy29062007@gmail.com","duongtn1806@gmail.com","magelova32@gmail.com","hongvan21017@gmail.com","congkhiem3009@gmail.com","dungbgbg07@gmail.com","khanhhn0402@gmail.com","hoangflong2012@gmail.com","tieuhan2610@gmail.com","anhtv071207@gmail.com","vup8851@gmail.com","hieunt120907@gmail.com","yue202246@gmail.com","huyphu28062007@gmail.com","son.p72@gmail.com","anhndh285@gmail.com","nguyenhaidanglklh@gmail.com","ngyuendangminhtu@gmail.com","phamkhanhhung25112007@gmail.com","hungbe0of@gmail.com","dattien172007@gmail.com","knowone1167@gmail.com","anbach4865@gmail.com","bopdangchoi@gmail.com"};
        for(String e: email) {
            try {
                SimpleMailMessage sms = new SimpleMailMessage();
                sms.setFrom("duongtn1806@gmail.com");
                sms.setTo(e);
                sms.setSubject("Hello world");
                sms.setText("SD20203");
                javaMailSender.send(sms);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }
}
