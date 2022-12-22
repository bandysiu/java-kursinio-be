package com.parcel.model.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class CreateCommentRequest {
    @NonNull
    @Size(min = 1, max = 255)
    @Schema(description = "Comment", example = "This is an amazing app")
    private String comment;

    @NonNull
    @Schema(description = "User Id", example = "13")
    private Long userId;

    @NonNull
    @Schema(description = "Forum Id", example = "2")
    private Long forumId;
}
