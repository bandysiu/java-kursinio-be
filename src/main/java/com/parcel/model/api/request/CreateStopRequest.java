package com.parcel.model.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class CreateStopRequest {
    @NonNull
    @Schema(description = "Trip id", example = "1")
    private Long tripId;
    @NonNull
    @Schema(description = "Stop time", example = "kazkoks laikas")
    private String time;
    @NonNull
    @Schema(description = "Stop reason", example = "Pachillint noriu")
    private String reason;
}
