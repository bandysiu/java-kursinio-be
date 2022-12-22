package com.parcel.repository;

import com.parcel.model.domain.forum.DtoForum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ForumRepository extends JpaRepository<DtoForum, Long> {
    List<DtoForum> findAllById(Long id);
    DtoForum findByForumId(Long id);

}
