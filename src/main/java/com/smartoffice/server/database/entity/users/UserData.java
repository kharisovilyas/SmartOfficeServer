package com.smartoffice.server.database.entity.users;


import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "User_Data")
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @Getter
    @Setter
    private Long userId;

    @Column(name = "email")
    @Getter
    @Setter
    private String email;

    @Column(name = "password")
    @Getter
    @Setter
    private String password;

    @Column(name = "first_name")
    @Getter
    @Setter
    private String firstName;

    @Column(name = "surname")
    @Getter
    @Setter
    private String surname;

    @Column(name = "patronymic")
    @Getter
    @Setter
    private String patronymic;

    @Column(name = "birthday")
    @Getter
    @Setter
    private String birthday;

    @Column(name = "age")
    @Getter
    @Setter
    private int age;

    @Column(name = "company_id")
    @Getter
    @Setter
    private Long company;
}

