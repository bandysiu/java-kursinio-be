package com.parcel.repository;

import com.parcel.model.domain.order.DtoShipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShipmentRepository extends JpaRepository<DtoShipment, Long> {
    List<DtoShipment> findAllById(Long id);
    DtoShipment findShipmentById(Long id);
}
