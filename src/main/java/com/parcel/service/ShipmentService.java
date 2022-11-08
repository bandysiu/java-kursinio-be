package com.parcel.service;

import com.parcel.model.api.request.CreateShipmentRequest;
import com.parcel.model.domain.order.DtoShipment;
import com.parcel.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;

    @Autowired
    public ShipmentService(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public DtoShipment createShipment(CreateShipmentRequest request) {
        DtoShipment shipment = DtoShipment.builder()
                .description(request.getDescription())
                .weight(request.getWeight())
                .build();
        return shipmentRepository.save(shipment);
    }

    public List<DtoShipment> fetchShipments(Long id) {
        if (id != null) {
            return shipmentRepository.findAllById(id);
        } else {
            return shipmentRepository.findAll();
        }
    }

    public DtoShipment fetchShipment(Long id){
        return shipmentRepository.findShipmentById(id);
    }
}
