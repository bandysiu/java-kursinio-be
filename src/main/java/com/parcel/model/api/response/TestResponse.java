package com.parcel.model.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TestResponse {
    @Schema(description = "Test id", example = "1")
    private Long id;

    @Schema(description = "Test text", example = "Andrew")
    private String text;

    @Schema(description = "Test number", example = "1")
    private Long number;
}
