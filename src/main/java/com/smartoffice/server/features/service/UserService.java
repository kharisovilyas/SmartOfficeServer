package com.smartoffice.server.features.service;

import com.smartoffice.server.database.dto.users.UserDTO;
import com.smartoffice.server.database.entity.company.CompanyData;
import com.smartoffice.server.features.repository.*;
import com.smartoffice.server.features.response.ApiResponse;
import com.smartoffice.server.features.response.exception.user.InvalidPasswordException;
import com.smartoffice.server.features.response.exception.user.UserAlreadyExistsException;
import com.smartoffice.server.features.response.exception.user.UserNotFoundException;
import com.smartoffice.server.features.repository.UserRepository;
import com.smartoffice.server.database.entity.users.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, CompanyRepository companyRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<ApiResponse> registerUser(UserDTO userDTO) {
        if (userRepository.findByEmail(userDTO.getEmail()) != null) {
            throw new UserAlreadyExistsException();
        } else {
            UserData user = new UserData();
            user.setEmail(userDTO.getEmail());
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            user.setFirstName(userDTO.getFirstName());
            user.setSurname(userDTO.getSurname());
            user.setPatronymic(userDTO.getPatronymic());
            user.setBirthday(userDTO.getBirthday());
            user.setAge(userDTO.getAge());
            // Сохраняем пользователя
            userRepository.save(user);
            // Создаем новую компанию и связываем ее с пользователем
            CompanyData company = new CompanyData();
            company.setCompanyName(userDTO.getCompanyName());
            company.setNumberOfEmployees(1); // Предположим, что начальное количество сотрудников в компании равно 1
            companyRepository.save(company);

            // Обновляем пользователя с идентификатором компании
            user.setCompany(company.getCompanyId());
            userRepository.save(user);
            return ResponseEntity.ok(new ApiResponse("Welcome to Smart Office!"));
        }
    }

    public ResponseEntity<ApiResponse> loginUser(UserDTO userDTO) {
        UserData existingUser = userRepository.findByEmail(userDTO.getEmail());
        if (existingUser != null) {
            // Пользователь с таким именем существует, вы можете выполнить проверку пароля
            if (passwordEncoder.matches(userDTO.getPassword(), existingUser.getPassword())) {
                return ResponseEntity.ok(new ApiResponse("Entry completed successfully."));
            } else {
                throw new InvalidPasswordException();
            }
        } else {
            throw new UserNotFoundException(userDTO.getEmail());
        }
    }

}


