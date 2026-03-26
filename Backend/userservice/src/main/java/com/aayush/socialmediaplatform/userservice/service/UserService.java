package com.aayush.socialmediaplatform.userservice.service;

import com.aayush.socialmediaplatform.userservice.dto.requestdto.UserRegistrationDTO;
import com.aayush.socialmediaplatform.userservice.entity.User;
import jakarta.validation.Valid;

import java.util.List;

public interface UserService {
    String registerUser(@Valid UserRegistrationDTO user);

    List<User> getAllUsers();
}
