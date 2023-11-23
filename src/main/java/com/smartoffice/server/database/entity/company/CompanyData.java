package com.smartoffice.server.database.entity.company;

import com.smartoffice.server.database.entity.users.UserInfoData;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "Company")
public class CompanyData {
    @Id
    @Column(name = "company_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    private List<UserInfoData> employees;

    @Column(name = "company_name", unique = true)
    private String companyName;

    @Column(name = "description")
    private String description;

    @Column(name = "number_of_employees")
    private Integer numberOfEmployees;

    @Column(name = "foundation_date")
    private LocalDateTime foundationDate;
}
