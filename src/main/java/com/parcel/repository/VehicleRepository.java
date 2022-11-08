package com.parcel.repository;

import com.parcel.model.domain.DtoVehicle;
import com.parcel.model.domain.VehicleStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<DtoVehicle, Long> {
    List<DtoVehicle> findAllById(Long id);
    List<DtoVehicle> findAllByBrand(String brand);
    List<DtoVehicle> findAllByStatus(VehicleStatus status);
    DtoVehicle findVehicleById(Long id);
}
