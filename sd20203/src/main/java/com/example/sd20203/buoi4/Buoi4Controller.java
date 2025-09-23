package com.example.sd20203.buoi4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/buoi4")
public class Buoi4Controller {
    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        Student student = new Student(1, "Gia Hien", 9.5f);
        model.addAttribute("student", student);

        return "/buoi4/hienThi";
    }
}
