package com.smartoffice.server.features.controller;

import com.smartoffice.server.database.dto.UserDTO;
import com.smartoffice.server.features.response.ApiResponse;
import com.smartoffice.server.features.service.UserService;
import com.smartoffice.server.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerUser(@RequestBody UserDTO user){
        return userService.registerUser(user);
    }
    @PostMapping("/login")
    public ResponseEntity<ApiResponse> loginUser(@RequestBody UserDTO user){
        return userService.loginUser(user);
    }

}
