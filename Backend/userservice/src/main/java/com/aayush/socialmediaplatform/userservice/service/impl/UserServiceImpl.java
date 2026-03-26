package com.aayush.socialmediaplatform.userservice.service.impl;

import com.aayush.socialmediaplatform.userservice.dto.requestdto.UserRegistrationDTO;
import com.aayush.socialmediaplatform.userservice.entity.User;
import com.aayush.socialmediaplatform.userservice.exception.UserEmailExists;
import com.aayush.socialmediaplatform.userservice.repository.UserRespository;
import com.aayush.socialmediaplatform.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ModelMapper modelmapper;
    private final UserRespository userRepository;

    @Override
    public String registerUser(UserRegistrationDTO registerUser) {
        Optional<User> existingUser = userRepository.getUserByEmail(registerUser.getEmail());

        if (existingUser.isPresent()) {
            throw new UserEmailExists("User with this email already exists");
        }

        User user = modelmapper.map(registerUser, User.class);
        userRepository.save(user);

        return "User Registered Successfully";
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
