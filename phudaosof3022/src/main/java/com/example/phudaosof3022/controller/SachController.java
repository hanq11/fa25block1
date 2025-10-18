package com.example.phudaosof3022.controller;

import com.example.phudaosof3022.model.Sach;
import com.example.phudaosof3022.model.TacGia;
import com.example.phudaosof3022.repository.SachRepository;
import com.example.phudaosof3022.repository.TacGiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SachController {
    @Autowired
    SachRepository sachRepository;

    @Autowired
    TacGiaRepository tacGiaRepository;

    @ModelAttribute("listTacGia")
    public List<TacGia> getListTacGia() {
        return tacGiaRepository.findAll();
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("listSach", sachRepository.findAll());
//        model.addAttribute("listTacGia", tacGiaRepository.findAll());
        return "hienThi";
    }

    @PostMapping("/them")
    public String themSach(Sach sach) {
        sachRepository.save(sach);
        return "redirect:/hien-thi";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("sach", sachRepository.findById(id).get());
        return "viewUpdate";
    }

    @PostMapping("/update")
    public String update(Sach sach) {
        sachRepository.save(sach);
        return "redirect:/hien-thi";
    }

    @GetMapping("/xoa")
    public String xoaSach(@RequestParam("id") Integer id) {
        sachRepository.deleteById(id);
        return "redirect:/hien-thi";
    }
}
