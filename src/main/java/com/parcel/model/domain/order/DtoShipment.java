package com.parcel.model.domain.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "Shipments")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DtoShipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SHIPMENT_ID", nullable = false)
    private Long id;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "WEIGHT", nullable = false)
    private String weight;

    @Column(name = "STATUS", nullable = false)
    private OrderStatus status;

    @OneToOne(mappedBy = "shipment")
    private DtoCommission commission;

}
