package com.parcel.repository;

import com.parcel.model.domain.order.DtoTrip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<DtoTrip, Long> {
    List<DtoTrip> findAllById(Long id);
}
