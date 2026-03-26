package com.aayush.socialmediaplatform.userservice.repository;

import com.aayush.socialmediaplatform.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRespository extends JpaRepository<User,Long> {

    Optional<User> getUserByEmail(String email);

    Optional<User> getUserByUserName(String username);
}
