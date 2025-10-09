package com.example.sd20203.buoi10.controller;

import com.example.sd20203.buoi10.model.DanhMuc;
import com.example.sd20203.buoi10.model.SanPham;
import com.example.sd20203.buoi10.repository.SanPhamRepository;
import com.example.sd20203.buoi10.service.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/san-pham")
public class SanPhamController {
    @Autowired
    SanPhamRepository sanPhamRepository;

    @Autowired
    DanhMucService danhMucService;

    @ModelAttribute("listDanhMuc")
    List<DanhMuc> getListDanhMuc() {
        return danhMucService.getAllDanhMuc();
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("listSanPham", sanPhamRepository.findAll());
//        model.addAttribute("listDanhMuc", danhMucService.getAllDanhMuc());
        return "/sanPham/hienThi";
    }

    @PostMapping("/them")
    public String themSanPham(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
        return "redirect:/san-pham/hien-thi";
    }
}
