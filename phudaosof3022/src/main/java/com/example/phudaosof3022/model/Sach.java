package com.example.phudaosof3022.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sach")
public class Sach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_sach")
    private String tenSach;

    @Column(name = "nam_xuat_ban")
    private Integer namXuatBan;

    @Column(name = "dang_cho_muon")
    private Boolean dangChoMuon;

    @ManyToOne
    @JoinColumn(name = "tac_gia_id", referencedColumnName = "id")
    private TacGia tacGia;
}
