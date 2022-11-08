package com.parcel.model.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class CreateCommissionRequest {

    @NonNull
    @Size(max = 20)
    @Schema(description = "Commission destination", example = "Berlin")
    private String destination;
    @NonNull
    @Size(max = 50)
    @Schema(description = "Commission delivery date", example = "2022-12-24 15:30:00")
    private String deliveryDate;
    @NonNull
    @Schema(description = "Commission shipment id", example = "1")
    private Long shipmentId;
    @NonNull
    @Schema(description = "Commission user id", example = "1")
    private Long userId;
    @NonNull
    @Schema(description = "Commission vehicle id", example = "1")
    private Long vehicleId;

}
