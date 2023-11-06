package com.smartoffice.server.database.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "UserInfo")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long user_info_id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Getter
    @Setter
    private String first_name;
    @Getter
    @Setter
    private String last_name;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private int age;
}
