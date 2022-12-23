package com.parcel.model.api.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ForumResponse {
    @Schema(description = "Forum id", example = "1")
    private Long id;

    @Schema(description = "Forum name", example = "Berlin")
    private String forumName;

    @Schema(description = "Is forum manager only", example = "True")
    private Boolean isManager;

//    @Schema(description = "Forum comments", example = "Many comments")
//    private List<DtoComments> comments;
}
