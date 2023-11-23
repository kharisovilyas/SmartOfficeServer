package com.smartoffice.server.database.dto.users;

import lombok.Data;

@Data
public class UserDTO {
    private String userId;
    private String email;
    private String password;
    private String firstName;
    private String surname;
    private String patronymic;
    private String birthday;
    private int age;
    private String companyName;
}
