package com.smartoffice.server.database.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "UserInfo")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_info_id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String first_name;
    private String last_name;
    private String email;
    private int age;
    // Геттеры и сеттеры
}
