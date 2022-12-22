package com.parcel.service;

import com.parcel.model.api.request.CreateForumRequest;
import com.parcel.model.domain.forum.DtoForum;
import com.parcel.repository.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumService {

    private final ForumRepository forumRepository;
    @Autowired
    public ForumService(ForumRepository forumRepository){
        this.forumRepository = forumRepository;
    }
    public List<DtoForum> fetchForum(Long id) {
        return forumRepository.findAllById(id);
    }

    public DtoForum createForum(CreateForumRequest request) {

        DtoForum forum = DtoForum.builder()
                .forumName(request.getForumName())
                .build();

        return forumRepository.save(forum);
    }

    public void updateForumName(Long id, String name){
        if(name != null){
            DtoForum forum = forumRepository.findByForumId(id);
            forum.setForumName(name);
            forumRepository.save(forum);
        }
    }

    public void deleteForumById(Long id) {
        forumRepository.deleteById(id);
    }

}
