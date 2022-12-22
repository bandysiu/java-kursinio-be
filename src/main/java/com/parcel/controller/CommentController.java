package com.parcel.controller;

import com.parcel.model.api.request.CreateCommentRequest;
import com.parcel.model.api.response.CommentsResponse;
import com.parcel.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/comment")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @PostMapping(path = "/create")
    @Operation(summary = "Create new comment in database")
    public Long createShipment(@Validated @RequestBody CreateCommentRequest request){
        return commentService.createComment(request).getId();
    }

    @GetMapping(value = "/comments")
    @Operation(summary = "Get comments from database")
    public List<CommentsResponse> fetch(@RequestParam(required = false) Long id,
                                     @RequestParam(required = false) Long userId,
                                     @RequestParam(required = false) Long forumId){
        return commentService.fetchComments(id, userId, forumId).stream()
                .map(p -> new CommentsResponse(p.getId(), p.getComment(), p.getForum().getId(), p.getUser().getId()))
                .collect(Collectors.toList());
    }

}
