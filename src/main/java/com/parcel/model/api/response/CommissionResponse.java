package com.parcel.model.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class CommissionResponse {
    @Schema(description = "Commission id", example = "1")
    private Long id;

    @Schema(description = "Commission destination", example = "Berlin")
    private String destination;

    @Schema(description = "Commission delivery date", example = "2022-12-24 16:20:00")
    private String deliveryDate;

    @Schema(description = "Commission shipment id", example = "1")
    private Long shipmentId;

    @Schema(description = "Commission status", example = "FREE")
    private String status;

    @Schema(description = "Commission vehicle id", example = "1")
    private Long vehicleId;
}
