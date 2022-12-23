package com.parcel.controller;

import com.parcel.model.api.request.CreateForumRequest;
import com.parcel.model.api.request.CreateStopRequest;
import com.parcel.model.api.response.ForumResponse;
import com.parcel.model.api.response.StopResponse;
import com.parcel.service.StopService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/stop")
public class StopController {
    private final StopService service;

    @Autowired
    public StopController(StopService service){
        this.service = service;
    }

    @PostMapping(path = "/create")
    @Operation(summary = "Create new stop in database")
    public Long createStop(@Validated @RequestBody CreateStopRequest request){
        return service.createStop(request).getId();
    }

    @GetMapping(value = "/stops")
    @Operation(summary = "Get tests from database")
    public List<StopResponse> fetchStops() {
        return service.fetchStops().stream()
                .map(p -> new StopResponse(p.getId(), p.getTripId(), p.getStopTime().toString(), p.getReason()))
                .collect(Collectors.toList());
    }
}
