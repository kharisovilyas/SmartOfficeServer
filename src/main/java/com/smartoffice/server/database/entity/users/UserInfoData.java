package com.smartoffice.server.database.entity.users;

import com.smartoffice.server.database.entity.company.CompanyData;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "User_Info")
public class UserInfoData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @OneToOne(mappedBy = "userInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private UserData userData;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyData company;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "age")
    private Integer age;
}
