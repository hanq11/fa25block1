package com.example.sd20204.buoi10.controller;

import com.example.sd20204.buoi10.model.DanhMuc;
import com.example.sd20204.buoi10.service.DanhMucService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/danh-muc")
public class DanhMucController {
    @Autowired
    DanhMucService danhMucService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("danhSach", danhMucService.getAllDanhMuc());
        return "/danhMuc/hienThi";
    }

    @PostMapping("/them")
    public String them(DanhMuc danhMuc) {
        danhMucService.addDanhMuc(danhMuc);
        return "redirect:/danh-muc/hien-thi";
    }

    @GetMapping("/sua/{id}")
    public String viewUpdate(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("danhMuc", danhMucService.getDanhMucById(id));
        return "/danhMuc/viewUpdate";
    }

    @PostMapping("/sua")
    public String suaDanhMuc(DanhMuc danhMuc) {
        danhMucService.updateDanhMuc(danhMuc);
        return "redirect:/danh-muc/hien-thi";
    }

    @GetMapping("/xoa")
    public String xoaDanhMuc(@RequestParam("id") Integer id) {
        danhMucService.deleteDanhMuc(id);
        return "redirect:/danh-muc/hien-thi";
    }
}
