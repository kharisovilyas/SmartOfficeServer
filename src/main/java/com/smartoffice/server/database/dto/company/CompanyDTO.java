package com.smartoffice.server.database.dto.company;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Data
public class CompanyDTO {
    private Long companyId;
    private String companyName;
    private String description;
    private Integer numberOfEmployees;
    private LocalDateTime foundationDate;
}
