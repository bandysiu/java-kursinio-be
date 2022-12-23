package com.parcel.service;

import com.parcel.model.api.request.CreateForumRequest;
import com.parcel.model.api.update.UpdateForumBody;
import com.parcel.model.api.update.UpdateUserBody;
import com.parcel.model.domain.DtoTest;
import com.parcel.model.domain.forum.DtoForum;
import com.parcel.model.domain.user.DtoUser;
import com.parcel.repository.ForumRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ForumService {

    private final ForumRepository forumRepository;

    public ForumService(ForumRepository forumRepository){
        this.forumRepository = forumRepository;
    }

    public DtoForum createForum(CreateForumRequest request){
        DtoForum forum = DtoForum.builder()
                .name(request.getForumName())
                .isManager(request.getIsManager())
                .build();
        return forumRepository.save(forum);
    }

    public List<DtoForum> fetchForums(){
        return forumRepository.findAll();
    }

    public void updateForum(UpdateForumBody request){
        DtoForum forum = forumRepository.findForumById(request.getId());
        forum.setName(request.getForumName());
        forum.setIsManager(request.getIsManager());

        forumRepository.save(forum);
    }

    public DtoForum fetchForum(Long id){
        return forumRepository.findForumById(id);
    }

    public void deleteForumById(Long id) {
        forumRepository.deleteById(id);
    }

}
