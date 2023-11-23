package com.smartoffice.server.features.service.user;

import com.smartoffice.server.database.dto.users.UserDTO;
import com.smartoffice.server.database.entity.company.CompanyData;
import com.smartoffice.server.database.entity.users.UserInfoData;
import com.smartoffice.server.features.repository.company.CompanyRepository;
import com.smartoffice.server.features.repository.user.UserInfoRepository;
import com.smartoffice.server.features.response.ApiResponse;
import com.smartoffice.server.features.response.exception.user.InvalidPasswordException;
import com.smartoffice.server.features.response.exception.user.UserAlreadyExistsException;
import com.smartoffice.server.features.response.exception.user.UserNotFoundException;
import com.smartoffice.server.features.repository.user.UserDataRepository;
import com.smartoffice.server.database.entity.users.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final Integer REGISTER_USER_COUNT = 1;
    private final UserDataRepository userDataRepository;
    private final UserInfoRepository userInfoRepository;
    private final CompanyRepository companyRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserDataRepository userRepository, UserInfoRepository userInfoRepository,
                       CompanyRepository companyRepository, PasswordEncoder passwordEncoder
    ) {
        this.userDataRepository = userRepository;
        this.userInfoRepository = userInfoRepository;
        this.companyRepository = companyRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<ApiResponse> registerUser(UserDTO userDTO) {
        if (userDataRepository.findByEmail(userDTO.getEmail()) != null) {
            throw new UserAlreadyExistsException();
        }
        CompanyData company = companyRepository.findByCompanyName(userDTO.getCompanyName());
        if (company != null) {
            UserData userData = new UserData();
            UserInfoData userInfo = new UserInfoData();
            userData.setEmail(userDTO.getEmail());
            userData.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            userInfo.setFirstName(userDTO.getFirstName());
            userInfo.setSurname(userDTO.getSurname());
            userInfo.setPatronymic(userDTO.getPatronymic());
            userInfo.setBirthday(userDTO.getBirthday());
            userInfo.setAge(userDTO.getAge());
            company.setNumberOfEmployees(company.getNumberOfEmployees() + REGISTER_USER_COUNT);
            userInfo.setCompany(company);
            userInfoRepository.save(userInfo);
            userData.setUserId(userInfo.getUserId());
            userDataRepository.save(userData);
            company.getEmployees().add(userInfo);
            companyRepository.save(company);
        } else {
            return ResponseEntity.ok(new ApiResponse("Your company is not registered"));
        }
        return ResponseEntity.ok(new ApiResponse("Welcome to Smart Office!"));
    }


    public ResponseEntity<ApiResponse> loginUser(UserDTO userDTO) {
        UserData existingUser = userDataRepository.findByEmail(userDTO.getEmail());
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


