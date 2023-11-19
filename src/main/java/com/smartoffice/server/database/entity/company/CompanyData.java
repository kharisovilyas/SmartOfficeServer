package com.smartoffice.server.database.entity.company;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "Company")
public class CompanyData {
    @Id
    @Column(name = "company_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long companyId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "description")
    private String description;

    @Column(name = "number_of_employees")
    private Integer numberOfEmployees;

    @Column(name = "foundation_date")
    private LocalDateTime foundationDate;
}
