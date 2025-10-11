package com.example.tutorsof3022.repository;

import com.example.tutorsof3022.model.TaiSan;
import org.hibernate.boot.archive.internal.JarProtocolArchiveDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiSanRepository extends JpaRepository<TaiSan, Integer> {
}
