package com.parcel.controller;

import com.parcel.model.api.request.CreateUserRequest;
import com.parcel.model.api.response.UserResponse;
import com.parcel.model.domain.user.UserPosition;
import com.parcel.model.domain.user.UserStatus;
import com.parcel.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/registration")
    @ApiResponse(
            responseCode = "200",
            description = "User was created successfully",
            content = @Content(schema = @Schema(implementation = Long.class))
    )
    @Operation(summary = "Create new user in database")
    public Long createUser(@Validated @RequestBody CreateUserRequest request) {
        return userService.createUser(request).getId();
    }

    @GetMapping(value = "/users")
    @Operation(summary = "Get users from database")
    public List<UserResponse> fetchUsers(@RequestParam(required = false) Long id,
                                         @RequestParam(required = false) String login,
                                         @RequestParam(required = false) String email,
                                         @RequestParam(required = false) UserPosition position,
                                         @RequestParam(required = false) UserStatus status) {
        return userService.fetchUsers(id, login, email, position, status).stream()
                .map(p -> new UserResponse(p.getId(), p.getFirstName(), p.getLastName(), p.getEmail(), p.getLogin(), p.getPassword(), p.getPosition(), p.getSalary(), p.getStatus()))
                .collect(Collectors.toList());
    }

    @PutMapping(path = "/update")
    @Operation(summary = "Update user information")
    @ApiResponse(
            responseCode = "201",
            description = "User was updated successfully",
            content = @Content(schema = @Schema(implementation = Long.class))
    )
    public void updateUserLogin(@RequestParam String login,
                                @RequestParam(required = false) String newLogin,
                                @RequestParam(required = false) String newEmail,
                                @RequestParam(required = false) String newPassword) {
        this.userService.updateUserInformation(login, newLogin, newEmail, newPassword);
    }

    @DeleteMapping(path = "/delete/{id}")
    @Operation(summary = "Delete user from database")
    @ApiResponse(
            responseCode = "200",
            description = "User was deleted successfully",
            content = @Content(schema = @Schema(implementation = Long.class))
    )
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

}