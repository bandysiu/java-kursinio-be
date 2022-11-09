package com.parcel.model.domain.order;

import com.parcel.model.domain.DtoVehicle;
import com.parcel.model.domain.user.DtoUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@Entity(name = "Commissions")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DtoCommission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMISSION_ID", nullable = false)
    private Long id;

    @Column(name = "DESTINATION", nullable = false)
    private String destination;

    @Column(name = "DELIVERY_DATE", nullable = false)
    private Timestamp deliveryDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SHIPMENT_ID")
    private DtoShipment shipment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private DtoUser driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VEHICLE_ID")
    private DtoVehicle vehicle;

}
