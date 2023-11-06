package com.smartoffice.server.features.service;

import com.smartoffice.server.database.dto.UserDTO;
import com.smartoffice.server.features.response.ApiResponse;
import com.smartoffice.server.features.response.exception.InvalidPasswordException;
import com.smartoffice.server.features.response.exception.UserAlreadyExistsException;
import com.smartoffice.server.features.response.exception.UserNotFoundException;
import com.smartoffice.server.features.repository.UserRepository;
import com.smartoffice.server.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<ApiResponse> registerUser(UserDTO userDTO) {
        if (userRepository.findByUsername(userDTO.getUsername()) != null) {
            throw new UserAlreadyExistsException();
        } else {
            User user = new User();
            user.setUsername(userDTO.getUsername());
            user.setPassword(userDTO.getPassword());
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            userRepository.save(user);
            return ResponseEntity.ok(new ApiResponse("Welcome to Smart Office!"));
        }
    }

    public ResponseEntity<ApiResponse> loginUser(UserDTO userDTO) {
        User existingUser = userRepository.findByUsername(userDTO.getUsername());
        if (existingUser != null) {
            // Пользователь с таким именем существует, вы можете выполнить проверку пароля
            if (passwordEncoder.matches(userDTO.getPassword(), existingUser.getPassword())) {
                return ResponseEntity.ok(new ApiResponse("Entry completed successfully."));
            } else {
                throw new InvalidPasswordException();
            }
        } else {
            throw new UserNotFoundException(userDTO.getUsername());
        }
    }

}

