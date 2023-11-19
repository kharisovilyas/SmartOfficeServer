package com.smartoffice.server.database.dto.users;

import lombok.Getter;
import lombok.Setter;

public class UserDTO {
    @Getter
    @Setter
    private String userId;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String surname;

    @Getter
    @Setter
    private String patronymic;

    @Getter
    @Setter
    private String birthday;

    @Getter
    @Setter
    private int age;

    @Getter
    @Setter
    private String companyName;
}
