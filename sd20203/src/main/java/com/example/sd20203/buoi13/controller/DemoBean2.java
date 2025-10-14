package com.example.sd20203.buoi13.controller;

import com.example.sd20203.buoi13.model.CapSach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo-bean-2")
public class DemoBean2 {
    @Qualifier("B2")
    @Autowired
    CapSach capSach;

    @GetMapping("/test")
    @ResponseBody
    public CapSach getCapSach2() {
        return capSach;
    }
}
