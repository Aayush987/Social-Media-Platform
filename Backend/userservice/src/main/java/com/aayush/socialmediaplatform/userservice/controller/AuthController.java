package com.aayush.socialmediaplatform.userservice.controller;

import com.aayush.socialmediaplatform.userservice.dto.requestdto.UserRegistrationDTO;
import com.aayush.socialmediaplatform.userservice.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final UserServiceImpl userService;

    @GetMapping("/test")
    public String test() {
        return "This endpoint is working";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @RequestBody UserRegistrationDTO user) {
        return userService.registerUser(user);
    }



}
