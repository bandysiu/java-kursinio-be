package com.parcel.controller;

import com.parcel.model.api.request.CreateVehicleRequest;
import com.parcel.model.api.response.VehicleResponse;
import com.parcel.model.domain.vehicle.VehicleStatus;
import com.parcel.service.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/create")
    @Operation(summary = "Create new vehicle in database")
    public Long createVehicle(@Validated @RequestBody CreateVehicleRequest request) {
        return vehicleService.createVehicle(request).getId();
    }

    @GetMapping(value = "/vehicles")
    @Operation(summary = "Get vehicles from database")
    public List<VehicleResponse> fetchVehicles(@RequestParam(required = false) Long id,
                                               @RequestParam(required = false) String brand,
                                               @RequestParam(required = false) VehicleStatus status) {
        return vehicleService.fetchVehicles(id, brand, status).stream()
                .map(p -> new VehicleResponse(p.getId(), p.getBrand(), p.getYear(), p.getPrice(), p.getStatus()))
                .collect(Collectors.toList());
    }
}
