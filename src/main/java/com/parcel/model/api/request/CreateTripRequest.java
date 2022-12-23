package com.parcel.model.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class CreateTripRequest {
    @NonNull
    @Schema(description = "Driver", example = "1")
    private Long driverId;
    @NonNull
    @Schema(description = "Commission", example = "1")
    private Long commissionId;
}
