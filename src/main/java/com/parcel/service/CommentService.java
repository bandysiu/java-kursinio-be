package com.parcel.service;

import com.parcel.model.api.request.CreateCommentRequest;
import com.parcel.model.domain.forum.DtoComments;
import com.parcel.model.domain.forum.DtoForum;
import com.parcel.model.domain.user.DtoUser;
import com.parcel.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserService userService;
    private final ForumService forumService;

    @Autowired
    public CommentService(CommentRepository commentRepository,
                          UserService userService,
                          ForumService forumService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.forumService = forumService;
    }

    public DtoComments createComment(CreateCommentRequest request) {

        DtoUser user = userService.fetchUser(request.getUserId());

        DtoComments comment = DtoComments.builder()
                .comment(request.getComment())
                .forumId(request.getForumId())
                .date(LocalDate.now())
                .user(user)
                .build();

        return commentRepository.save(comment);
    }

    public List<DtoComments> fetchComments(Long id, Long userId, Long forumId) {
        if (id != null) {
            return commentRepository.findAllById(id);
        } else if (userId != null) {
            return commentRepository.findAllByUserId(userId);
        } else if (forumId != null) {
            return commentRepository.findAllByForumId(forumId);
        }
        return commentRepository.findAll();
    }

    public void deleteCommentById(Long id) {
        commentRepository.deleteById(id);
    }
}
