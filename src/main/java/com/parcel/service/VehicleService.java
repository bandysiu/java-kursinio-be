package com.parcel.service;

import com.parcel.model.api.request.CreateVehicleRequest;
import com.parcel.model.domain.vehicle.DtoVehicle;
import com.parcel.model.domain.vehicle.VehicleStatus;
import com.parcel.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public DtoVehicle createVehicle(CreateVehicleRequest request) {
        DtoVehicle vehicle = DtoVehicle.builder()
                .brand(request.getBrand())
                .year(request.getYear())
                .price(request.getPrice())
                .status(VehicleStatus.FREE)
                .build();

        return vehicleRepository.save(vehicle);
    }

    public List<DtoVehicle> fetchVehicles(Long id, String brand, VehicleStatus status) {
        if (id != null) {
            return this.vehicleRepository.findAllById(id);
        } else if (brand != null) {
            return this.vehicleRepository.findAllByBrand(brand);
        } else if (status != null) {
            return this.vehicleRepository.findAllByStatus(status);
        } else {
            return this.vehicleRepository.findAll();
        }
    }

    public DtoVehicle fetchVehicle(Long id){
        return vehicleRepository.findVehicleById(id);
    }
}
