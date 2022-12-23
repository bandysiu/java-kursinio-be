package com.parcel.model.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class CreateTestRequest {
    @NonNull
    @Size(min = 1, max = 255)
    @Schema(description = "Test text", example = "Tate")
    private String text;

    @NonNull
    @Schema(description = "Test number", example = "1")
    private Long number;
}
