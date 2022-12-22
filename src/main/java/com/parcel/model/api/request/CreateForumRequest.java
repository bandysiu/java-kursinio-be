package com.parcel.model.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class CreateForumRequest {
    @NonNull
    @Size(min = 3, max = 20)
    @Schema(description = "Forum name", example = "Forum 1")
    private String forumName;
}
