package com.parcel.model.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
public class CreateVehicleRequest {
    @NonNull
    @Schema(description = "Vehicle brand", example = "Volvo")
    private String brand;
    @NonNull
    @Schema(description = "Vehicle year", example = "2003")
    private String year;
    @NonNull
    @Schema(description = "Vehicle price", example = "12000")
    private String price;
}
