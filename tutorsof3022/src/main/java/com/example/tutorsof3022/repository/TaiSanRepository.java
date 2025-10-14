package com.example.tutorsof3022.repository;

import com.example.tutorsof3022.model.TaiSan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaiSanRepository extends JpaRepository<TaiSan, Integer> {
    public List<TaiSan> findTaiSansByTenContains(String ten);

    // JPQL
    @Query("SELECT ts FROM TaiSan ts WHERE ts.ten LIKE %:ten%")
    public List<TaiSan> searchTaiSanTheoTen(@Param("ten") String ten);

    // SQL
    @Query(value = "SELECT * FROM TaiSan WHERE ten LIKE %:ten%", nativeQuery = true)
    public List<TaiSan> searchTaiSanTheoTenSQL(@Param("ten") String ten);
}
