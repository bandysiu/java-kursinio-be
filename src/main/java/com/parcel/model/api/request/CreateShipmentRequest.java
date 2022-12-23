package com.parcel.model.api.request;

import com.parcel.model.domain.order.OrderStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class CreateShipmentRequest {

    @NonNull
    @Size(max = 30)
    @Schema(description = "Short shipment description", example = "Baking goods")
    private String description;
    @NonNull
    @Schema(description = "Shipment weight", example = "2000kg")
    private String weight;
    @NonNull
    @Schema(description = "Status", example = "FREE")
    private OrderStatus status;
}
