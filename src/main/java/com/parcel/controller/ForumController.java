package com.parcel.controller;

import com.parcel.model.api.request.CreateForumRequest;
import com.parcel.model.api.request.CreateShipmentRequest;
import com.parcel.model.api.response.ForumResponse;
import com.parcel.model.api.response.ShipmentResponse;
import com.parcel.service.ForumService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Long createShipment(@Validated @RequestBody CreateForumRequest request){
        return forumService.createForum(request).getId();
    }

    @GetMapping(value = "/comments")
    @Operation(summary = "Get comments from database")
    public List<ForumResponse> fetch(@RequestParam(required = false) Long id){
        return forumService.fetchForum(id).stream()
                .map(p -> new ForumResponse(p.getId(), p.getForumName(), p.getComments()))
                .collect(Collectors.toList());
    }
}
