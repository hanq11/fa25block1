package com.example.sd20301nguyenvv4.buoi5.controller;

import com.example.sd20301nguyenvv4.buoi5.service.SinhVienService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi"
})
public class SinhVienServlet extends HttpServlet {

    SinhVienService sinhVienService = new SinhVienService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(request, response);
        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhSach", sinhVienService.getAll());
        request.getRequestDispatcher("/buoi5/hien-thi.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
