package com.parcel.repository;

import com.parcel.model.domain.order.DtoStop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StopRepository extends JpaRepository<DtoStop, Long> {
    List<DtoStop> findAllById(Long id);
}
