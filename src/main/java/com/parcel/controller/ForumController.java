package com.parcel.controller;

import com.parcel.model.api.request.CreateForumRequest;
import com.parcel.model.api.request.CreateShipmentRequest;
import com.parcel.model.api.response.ForumResponse;
import com.parcel.model.api.response.ShipmentResponse;
import com.parcel.model.api.response.TestResponse;
import com.parcel.model.api.update.UpdateForumBody;
import com.parcel.model.api.update.UpdateUserBody;
import com.parcel.service.ForumService;
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
@RequestMapping(path = "api/forum")
public class ForumController {
    private final ForumService forumService;

    @Autowired
    public ForumController(ForumService forumService){
        this.forumService = forumService;
    }

    @PostMapping(path = "/create")
    @Operation(summary = "Create new forum in database")
    public Long createForum(@Validated @RequestBody CreateForumRequest request){
        return forumService.createForum(request).getId();
    }

    @GetMapping(value = "/tests")
    @Operation(summary = "Get tests from database")
    public List<ForumResponse> fetchForums() {
        return forumService.fetchForums().stream()
                .map(p -> new ForumResponse(p.getId(), p.getName(), p.getIsManager()))
                .collect(Collectors.toList());
    }

    @PutMapping(path = "/update")
    @Operation(summary = "Update forum information")
    @ApiResponse(
            responseCode = "201",
            description = "User was updated successfully",
            content = @Content(schema = @Schema(implementation = Long.class))
    )
    public void updateUserManager(@Validated @RequestBody UpdateForumBody request) {
        this.forumService.updateForum(request);
    }

    @DeleteMapping(path = "/delete")
    @Operation(summary = "Delete forum from database")
    @ApiResponse(
            responseCode = "200",
            description = "User was deleted successfully",
            content = @Content(schema = @Schema(implementation = Long.class))
    )
    public ResponseEntity<Void> deleteUser(@RequestParam Long id) {
        forumService.deleteForumById(id);
        return ResponseEntity.noContent().build();
    }
}
