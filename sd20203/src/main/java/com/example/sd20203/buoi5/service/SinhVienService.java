package com.example.sd20203.buoi5.service;

import com.example.sd20203.buoi5.model.SinhVien;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SinhVienService {
    private List<SinhVien> danhSach = null;

    public SinhVienService() {
        danhSach = new ArrayList(Arrays.asList(
                new SinhVien(1, "Nguyen Van A", 4.5f, true),
                new SinhVien(2, "Nguyen Van B", 4.5f, false),
                new SinhVien(3, "Nguyen Thi C", 4.5f, false)
        ));
    }

    public List<SinhVien> getAll() {
        return danhSach;
    }
    public SinhVien getDetail(Integer id) {
        for(SinhVien sv: danhSach) {
            if(sv.getId() == id) {
                return sv;
            }
        }
        return null;
    }
    public void addSinhVien(SinhVien sinhVien) {
        danhSach.add(sinhVien);
    }
    public void updateSinhVien(SinhVien sinhVien) {
        int updateIndex = -1;
        for(int i = 0; i < danhSach.size(); i++) {
            if(sinhVien.getId() == danhSach.get(i).getId()) {
                updateIndex = i;
            }
        }
        danhSach.set(updateIndex, sinhVien);
    }
    public void deleteSinhVien(Integer id) {
        danhSach.removeIf(sv -> sv.getId() == id);
    }
}
