package com.smartoffice.server.features.controller.user;

import com.smartoffice.server.database.dto.users.UserDTO;
import com.smartoffice.server.features.response.ApiResponse;
import com.smartoffice.server.features.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final UserService userService;
    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> loginUser(@RequestBody UserDTO user){
        return userService.loginUser(user);
    }



}
