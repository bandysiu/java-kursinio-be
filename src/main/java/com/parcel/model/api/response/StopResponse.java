package com.parcel.model.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StopResponse {
    @Schema(description = "Stop id", example = "1")
    private Long id;

    @Schema(description = "Trip id", example = "1")
    private Long tripId;

    @Schema(description = "Stop time", example = "kazkokia data krc")
    private String date;

    @Schema(description = "Stop reason", example = "Chill kmr")
    private String reason;
}
