package com.example.sd20301nguyenvv4.buoi5.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SinhVien {
    private Integer id;
    private String ten;
    private Float diem;
    private Boolean gioiTinh;
}
