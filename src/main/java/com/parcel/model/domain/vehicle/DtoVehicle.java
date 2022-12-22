package com.parcel.model.domain.vehicle;

import com.parcel.model.domain.order.DtoCommission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "Vehicles")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DtoVehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VEHICLE_ID", nullable = false)
    private Long id;

    @Column(name = "VEHICLE_BRAND", nullable = false)
    private String brand;

    @Column(name = "VEHICLE_YEAR", nullable = false)
    private String year;

    @Column(name = "VEHICLE_PRICE", nullable = false)
    private String price;

    @Column(name = "STATUS", nullable = false)
    private VehicleStatus status;

    @OneToMany(mappedBy = "vehicle")
    private List<DtoCommission> commissions;

}
