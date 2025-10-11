package com.example.sd20203.buoi10.controller;

import com.example.sd20203.buoi10.model.DanhMuc;
import com.example.sd20203.buoi10.model.SanPham;
import com.example.sd20203.buoi10.repository.SanPhamRepository;
import com.example.sd20203.buoi10.service.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        System.out.println("Tim kiem JPQL:");
        sanPhamRepository.timKiemSanPhamTheoKhoangGia(9F, 11F).forEach(sp -> System.out.println(sp.getTen()));
        System.out.println("Tim kiem SQL:");
        sanPhamRepository.timKiemSanPhamTheoKhoangGiaSQL(4F, 16F).forEach(sp -> System.out.println(sp.getTen()));
        return "/sanPham/hienThi";
    }

    @PostMapping("/them")
    public String themSanPham(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("sanPham", sanPhamRepository.findById(id).get());
        return "/sanPham/viewUpdate";
    }

    @PostMapping("/sua")
    public String sua(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("/xoa")
    public String xoaSanPham(@RequestParam("id") Integer id) {
        sanPhamRepository.deleteById(id);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("/phan-trang")
    public String phanTrang(@RequestParam(name = "page", defaultValue = "0", required = false) Integer page, Model model) {
        int pageSize = 2;
        Sort sort = Sort.by(Sort.Direction.DESC, "ten");
        Pageable pageable = PageRequest.of(page, pageSize, sort);
        model.addAttribute("page", sanPhamRepository.findAll(pageable));
        return "/sanPham/phanTrang";
    }

    @GetMapping("/tim-kiem")
    public String timKiemTenGia(@RequestParam(name = "ten", required = false) String ten
                                , Model model) {
        model.addAttribute("listSanPham", sanPhamRepository.findSanPhamsByTenContains(ten));
        return "/sanPham/hienThi";
    }
}
