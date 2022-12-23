package com.parcel.service;

import com.parcel.model.api.request.CreateTripRequest;
import com.parcel.model.domain.order.DtoTrip;
import com.parcel.model.domain.order.OrderStatus;
import com.parcel.model.domain.user.DtoUser;
import com.parcel.repository.TripRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;
    private final UserService userService;

    public TripService(TripRepository tripRepository, UserService userService){
        this.tripRepository = tripRepository;
        this.userService = userService;
    }

    public List<DtoTrip> fetchTrips(){
        return tripRepository.findAll();
    }

    public DtoTrip createTrip(CreateTripRequest request){
        DtoUser driver = userService.fetchUser(request.getDriverId());

        DtoTrip trip = DtoTrip.builder()
                .driver(driver)
                .status(OrderStatus.INPROGRESS)
                .build();
        return tripRepository.save(trip);
    }
}
