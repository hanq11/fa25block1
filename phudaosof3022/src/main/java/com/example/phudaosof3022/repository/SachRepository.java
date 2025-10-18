package com.example.phudaosof3022.repository;

import com.example.phudaosof3022.model.Sach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SachRepository extends JpaRepository<Sach, Integer> {
}
