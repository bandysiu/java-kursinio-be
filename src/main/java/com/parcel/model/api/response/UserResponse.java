package com.parcel.model.api.response;

import com.parcel.model.domain.user.UserPosition;
import com.parcel.model.domain.user.UserStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {
    @Schema(description = "User id", example = "1")
    private Long id;

    @Schema(description = "User first name", example = "Andrew")
    private String firstName;

    @Schema(description = "User last name", example = "Tate")
    private String lastName;

    @Schema(description = "User email", example = "andrew@gmail.com")
    private String email;

    @Schema(description = "User login", example = "nickname9000")
    private String login;

    @Schema(description = "User password", example = "password123")
    private String password;

    @Schema(description = "User working position", example = "Manager")
    private UserPosition position;

    @Schema(description = "User salary", example = "9000")
    private String salary;

    @Schema(description = "User working status", example = "WORKING")
    private UserStatus status;
}