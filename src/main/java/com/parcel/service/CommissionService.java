package com.parcel.service;

import com.parcel.model.api.request.CreateCommissionRequest;
import com.parcel.model.domain.DtoVehicle;
import com.parcel.model.domain.order.DtoCommission;
import com.parcel.model.domain.order.DtoShipment;
import com.parcel.model.domain.user.DtoUser;
import com.parcel.repository.CommissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CommissionService {

    private final CommissionRepository commissionRepository;
    private final ShipmentService shipmentService;
    private final UserService userService;
    private final VehicleService vehicleService;

    @Autowired
    public CommissionService(CommissionRepository commissionRepository,
                             ShipmentService shipmentService,
                             UserService userService,
                             VehicleService vehicleService) {
        this.commissionRepository = commissionRepository;
        this.shipmentService = shipmentService;
        this.userService = userService;
        this.vehicleService = vehicleService;
    }

    public DtoCommission createCommission(CreateCommissionRequest request){

        DtoShipment shipment = shipmentService.fetchShipment(request.getShipmentId());
        DtoUser user = userService.fetchUser(request.getUserId());
        DtoVehicle vehicle = vehicleService.fetchVehicle(request.getVehicleId());

        DtoCommission commission = DtoCommission.builder()
                .destination(request.getDestination())
                .deliveryDate(Timestamp.valueOf(request.getDeliveryDate()))
                .shipment(shipment)
                .driver(user)
                .vehicle(vehicle)
                .build();

        return commissionRepository.save(commission);
    }

    public List<DtoCommission> fetchCommissions(Long id){
        if(id != null) {
            return commissionRepository.findAllById(id);
        } else {
            return commissionRepository.findAll();
        }
    }

    public void deleteCommissionById(Long id) {
        commissionRepository.deleteById(id);
    }
}
