package com.example.sd20203.buoi3;

import com.example.sd20203.buoi2.LoginRequest;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/buoi3")
public class Buoi3Controller {
    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute(new Date());
        model.addAttribute("now", new Date());
        return "/buoi3/hienThi";
    }

    @ModelAttribute("thoiGian")
    public Date getThoiGian() {
        return new Date();
    }

    @GetMapping("/url1")
    public String url1(Model model, @RequestParam("message") String message) {
        model.addAttribute("message", message);
        return "/buoi3/demoForwardRedirect";
    }

    @GetMapping("/url3")
    public String url3(Model model) {
        model.addAttribute("message", "From url3");
        return "forward:/buoi3/url1";
    }

    @GetMapping("/url2")
    public String url2(RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("message", "From url2");
        return "redirect:/buoi3/url1";
    }

    @ResponseBody
    @GetMapping("/xin-chao")
    public String xinChao() {
        return "Xin chao cac ban";
    }

    @ResponseBody
    @GetMapping("/danh-sach")
    public List<LoginRequest> getDanhSach() {
        return Arrays.asList(
                new LoginRequest("admin", "123"),
                new LoginRequest("admin1", "1234"),
                new LoginRequest("admin2", "1235"),
                new LoginRequest("admin3", "1236")

        );
    }
}
