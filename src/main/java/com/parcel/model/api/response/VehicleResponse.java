package com.parcel.model.api.response;

import com.parcel.model.domain.VehicleStatus;
import com.parcel.service.VehicleService;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VehicleResponse {

    @Schema(description = "Vehicle id", example = "1")
    private Long id;

    @Schema(description = "Vehicle brand", example = "Volvo")
    private String brand;

    @Schema(description = "Vehicle year", example = "2003")
    private String year;

    @Schema(description = "Vehicle price", example = "12000")
    private String price;

    @Schema(description = "Vehicle status", example = "WORKING")
    private VehicleStatus status;

}
