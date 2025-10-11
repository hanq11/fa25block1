package com.example.tutorsof3022.controller;

import com.example.tutorsof3022.model.NhanVien;
import com.example.tutorsof3022.model.TaiSan;
import com.example.tutorsof3022.repository.NhanVienRepository;
import com.example.tutorsof3022.repository.TaiSanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tai-san")
public class TaiSanController {
    @Autowired
    TaiSanRepository taiSanRepository;

    @Autowired
    NhanVienRepository nhanVienRepository;

    @ModelAttribute("listNhanVien")
    public List<NhanVien> getListNhanVien() {
        return nhanVienRepository.findAll();
    }
    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("listTaiSan"
                , taiSanRepository.findAll());
        return "/taiSan/hienThi";
    }

    @PostMapping("/them")
    public String themTaiSan(TaiSan taiSan) {
        taiSanRepository.save(taiSan);
        return "redirect:/tai-san/hien-thi";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable("id") Integer id
                    , Model model) {
        model.addAttribute("taiSan", taiSanRepository.findById(id).get());
        return "/taiSan/viewUpdate";
    }

    @PostMapping("/sua")
    public String suaTaiSan(TaiSan taiSan) {
        taiSanRepository.save(taiSan);
        return "redirect:/tai-san/hien-thi";
    }

    @GetMapping("/xoa")
    public String xoaTaiSan(@RequestParam("id") Integer id) {
        taiSanRepository.deleteById(id);
        return "redirect:/tai-san/hien-thi";
    }
}
