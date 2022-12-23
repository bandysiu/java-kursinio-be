package com.parcel.model.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TripResponse {

    @Schema(description = "Trip id", example = "1")
    private Long id;

    @Schema(description = "Commission id", example = "1")
    private Long commissionId;

    @Schema(description = "Trip driver id", example = "1")
    private Long driverId;

    @Schema(description = "Trip status", example = "INPROGRESS")
    private String status;
}
