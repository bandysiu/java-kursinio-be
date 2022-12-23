package com.parcel.model.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentsResponse {
    @Schema(description = "Comment id", example = "1")
    private Long id;

    @Schema(description = "Date", example = "2022-10-12")
    private String date;

    @Schema(description = "User login", example = "2")
    private String userLogin;

    @Schema(description = "Forum id", example = "13")
    private Long forumId;

    @Schema(description = "Comment", example = "Good job")
    private String comment;
}