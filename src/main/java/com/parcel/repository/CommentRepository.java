package com.parcel.repository;

import com.parcel.model.domain.forum.DtoComments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<DtoComments, Long> {
    List<DtoComments> findAllById(Long id);
    List<DtoComments> findAllByUserId(Long userId);
    List<DtoComments> findAllByForumId(Long forumId);
}
