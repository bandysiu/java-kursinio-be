package com.parcel.repository;

import com.parcel.model.domain.DtoTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository<DtoTest, Long> {
    List<DtoTest> findAllById(Long id);
}
