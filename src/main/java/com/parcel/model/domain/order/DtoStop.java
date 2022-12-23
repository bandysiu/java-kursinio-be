package com.parcel.model.domain.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity(name = "Stops")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DtoStop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STOP_ID", nullable = false)
    private Long id;

    @Column(name = "TRIP_ID",nullable = false)
    private Long tripId;

    @Column(name = "STOP_TIME", nullable = false)
    private Timestamp stopTime;

    @Column(name = "REASON", nullable = false)
    private String reason;
}
