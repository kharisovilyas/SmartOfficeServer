package com.smartoffice.server.features.controller;

import com.smartoffice.server.database.dto.users.UserDTO;
import com.smartoffice.server.features.response.ApiResponse;
import com.smartoffice.server.features.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    private final UserService userService;
    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerUser(@RequestBody UserDTO user){
        return userService.registerUser(user);
    }
}
