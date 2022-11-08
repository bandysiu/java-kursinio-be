package com.parcel.service;

import com.parcel.model.api.request.CreateUserRequest;
import com.parcel.model.domain.user.DtoUser;
import com.parcel.model.domain.user.UserPosition;
import com.parcel.model.domain.user.UserStatus;
import com.parcel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public DtoUser createUser(CreateUserRequest request) {
        DtoUser user = DtoUser.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .login(request.getLogin())
                .password(request.getPassword())
                .position(UserPosition.USER)
                .salary("0")
                .status(UserStatus.FREE)
                .build();

        return userRepository.save(user);
    }

    public List<DtoUser> fetchUsers(Long id, String login, String email, UserPosition position, UserStatus status) {
        if (id != null) {
            return this.userRepository.findAllById(id);
        } else if (login != null) {
            return this.userRepository.findAllByLogin(login);
        } else if (email != null) {
            return this.userRepository.findAllByEmail(email);
        } else if (position != null) {
            return this.userRepository.findAllByPosition(position);
        } else if (status != null) {
            return this.userRepository.findAllByStatus(status);
        } else {
            return this.userRepository.findAll();
        }
    }

    public DtoUser fetchUser(Long id) {
        return userRepository.findUserById(id);
    }

    public void updateUserInformation(String login, String newLogin, String newEmail, String newPassword) {
        if (newLogin != null) {
            DtoUser dtoUser = userRepository.findByLogin(login);
            dtoUser.setLogin(newLogin);
            userRepository.save(dtoUser);
        } else if (newEmail != null) {
            DtoUser dtoUser = userRepository.findByLogin(login);
            dtoUser.setEmail(newEmail);
            userRepository.save(dtoUser);
        } else if (newPassword != null) {
            DtoUser dtoUser = userRepository.findByLogin(login);
            dtoUser.setPassword(newPassword);
            userRepository.save(dtoUser);
        }
    }

    public void deleteUserByLogin(String login) {
        DtoUser dtoUser = userRepository.findByLogin(login);
        userRepository.deleteById(dtoUser.getId());
    }
}
