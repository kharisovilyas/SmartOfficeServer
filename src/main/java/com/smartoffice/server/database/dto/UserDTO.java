package com.smartoffice.server.database.dto;

import lombok.Getter;
import lombok.Setter;

public class UserDTO {
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;
}