package com.parcel.controller;

import com.parcel.model.api.request.CreateForumRequest;
import com.parcel.model.api.request.CreateTripRequest;
import com.parcel.model.api.response.ForumResponse;
import com.parcel.model.api.response.TripResponse;
import com.parcel.service.TripService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/trip")
public class TripController {
    private final TripService service;

    @Autowired
    public TripController(TripService service){
        this.service = service;
    }

    @PostMapping(path = "/create")
    @Operation(summary = "Create new trip in database")
    public Long createTrip(@Validated @RequestBody CreateTripRequest request){
        return service.createTrip(request).getId();
    }

    @GetMapping(value = "/trips")
    @Operation(summary = "Get trips from database")
    public List<TripResponse> fetchForums() {
        return service.fetchTrips().stream()
                .map(p -> new TripResponse(p.getId(), p.getCommissionId(), p.getDriver().getId(), p.getStatus().toString()))
                .collect(Collectors.toList());
    }
}
