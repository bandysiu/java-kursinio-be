package com.parcel.repository;

import com.parcel.model.domain.user.DtoUser;
import com.parcel.model.domain.user.UserPosition;
import com.parcel.model.domain.user.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<DtoUser, Long> {

    List<DtoUser> findAllById(Long id);
    List<DtoUser> findAllByLogin(String login);
    List<DtoUser> findAllByEmail(String email);
    List<DtoUser> findAllByPosition(UserPosition position);
    List<DtoUser> findAllByStatus(UserStatus status);
    DtoUser findByLogin(String login);
    DtoUser findUserById(Long id);
}