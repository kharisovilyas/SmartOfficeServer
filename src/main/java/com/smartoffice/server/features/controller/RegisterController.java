package com.smartoffice.server.features.controller;

import com.smartoffice.server.features.service.UserService;
import com.smartoffice.server.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void registerUser(@RequestBody User user){
        userService.registerUser(user);
    }

}
