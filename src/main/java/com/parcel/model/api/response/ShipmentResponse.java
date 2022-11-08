package com.parcel.model.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShipmentResponse {

    @Schema(description = "Shipment id", example = "1")
    private Long id;

    @Schema(description = "Short shipment description", example = "Baking goods")
    private String description;

    @Schema(description = "Shipment weight", example = "2000kg")
    private String weight;
}
