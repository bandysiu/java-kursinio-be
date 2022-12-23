package com.parcel.model.api.update;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
public class UpdateForumBody {
    @NonNull
    @Schema(description = "Forum id", example = "2")
    private Long id;
    @NonNull
    @Schema(description = "Forum name", example = "nickname")
    private String forumName;
    @NonNull
    @Schema(description = "Forum manager access", example = "true")
    private Boolean isManager;
}
