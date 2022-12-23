package com.parcel.service;

import com.parcel.model.api.request.CreateStopRequest;
import com.parcel.model.domain.order.DtoStop;
import com.parcel.repository.StopRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class StopService {

    private final StopRepository stopRepository;

    public StopService(StopRepository stopRepository){
        this.stopRepository = stopRepository;
    }

    public List<DtoStop> fetchStops(){
        return stopRepository.findAll();
    }

    public DtoStop createStop(CreateStopRequest request){

        DtoStop stop = DtoStop.builder()
                .stopTime(Timestamp.valueOf(request.getTime()))
                .tripId(request.getTripId())
                .reason(request.getReason())
                .build();
        return stopRepository.save(stop);
    }
}
