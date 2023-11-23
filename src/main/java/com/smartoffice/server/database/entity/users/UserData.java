package com.smartoffice.server.database.entity.users;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "User_Data")
public class UserData {
    @Id
    @Column(name = "user_id", unique = true)
    private Long userId;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private UserInfoData userInfo;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}