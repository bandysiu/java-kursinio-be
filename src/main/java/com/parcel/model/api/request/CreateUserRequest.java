package com.parcel.model.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class CreateUserRequest {

    @NonNull
    @Size(min = 3, max = 20)
    @Schema(description = "User first name", example = "Andrew")
    private String firstName;
    @NonNull
    @Size(min = 3, max = 20)
    @Schema(description = "User last name", example = "Tate")
    private String lastName;
    @NonNull
    @Email
    @Schema(description = "User email", example = "andrew@gmail.com")
    private String email;
    @NonNull
    @Size(min = 3, max = 20)
    @Schema(description = "User login", example = "nickname9000")
    private String login;
    @NonNull
    @Size(min = 3, max = 20)
    @Schema(description = "User Password", example = "password123")
    private String password;
}