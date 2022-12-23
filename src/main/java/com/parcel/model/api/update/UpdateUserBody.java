package com.parcel.model.api.update;

import com.parcel.model.domain.user.UserPosition;
import com.parcel.model.domain.user.UserStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
public class UpdateUserBody {
    @NonNull
    @Schema(description = "User login", example = "nickname")
    private String login;
    @NonNull
    @Schema(description = "User first name", example = "Andrew")
    private String firstName;
    @NonNull
    @Schema(description = "User last name", example = "Tate")
    private String lastName;
    @NonNull
    @Email
    @Schema(description = "User email", example = "andrew@gmail.com")
    private String email;
    @NonNull
    @Schema(description = "User salary", example = "3000")
    private String salary;
    @NonNull
    @Schema(description = "User position", example = "MANAGER")
    private UserPosition position;
    @NonNull
    @Schema(description = "User status", example = "FREE")
    private UserStatus status;
}
