package com.example.sd20203.buoi1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {
    @GetMapping("/hello") // Handle mapping
    public String hello(Model model) { // controller
        model.addAttribute("ten", "SD20203");
        return "/buoi1/hello";
    }
}
