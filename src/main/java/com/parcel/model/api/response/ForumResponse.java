package com.parcel.model.api.response;

import com.parcel.model.domain.forum.DtoComments;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ForumResponse {
    @Schema(description = "Forum id", example = "1")
    private Long id;

    @Schema(description = "Forum name", example = "Berlin")
    private String forumName;

    @Schema(description = "Forum comments", example = "Many comments")
    private List<DtoComments> comments;
}
