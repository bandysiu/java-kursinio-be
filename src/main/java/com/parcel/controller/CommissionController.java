package com.parcel.controller;

import com.parcel.model.api.request.CreateCommissionRequest;
import com.parcel.model.api.response.CommissionResponse;
import com.parcel.service.CommissionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/commission")
public class CommissionController {

    private final CommissionService commissionService;

    @Autowired
    public CommissionController(CommissionService  commissionService) {this.commissionService = commissionService;}

    @PostMapping(path = "/create")
    @Operation(summary = "Create new commission in database")
    public Long createCommission(@Validated @RequestBody CreateCommissionRequest request){
        return commissionService.createCommission(request).getId();
    }

    @GetMapping("/commissions")
    @Operation(summary = "Get commissions from database")
    public List<CommissionResponse> fetchCommissions(@RequestParam(required = false) Long id){
        return commissionService.fetchCommissions(id).stream()
                .map(p -> new CommissionResponse(p.getId(), p.getDestination(), p.getDeliveryDate().toString(), p.getShipment().getId(), p.getDriver().getId(), p.getVehicle().getId()))
                .collect(Collectors.toList());
    }
}
