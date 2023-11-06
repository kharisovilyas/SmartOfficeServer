package com.smartoffice.server.features.service;

import com.smartoffice.server.features.exception.UserAlreadyExistsException;
import com.smartoffice.server.features.repository.UserRepository;
import com.smartoffice.server.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistsException("User with this username already exists");
        } else {
            // Пользователь с таким именем пользователя не существует, сохраните его
            userRepository.save(user);
        }
    }
}

