package com.smartoffice.server.database.entity;


import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "_User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long user_id;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;
}

