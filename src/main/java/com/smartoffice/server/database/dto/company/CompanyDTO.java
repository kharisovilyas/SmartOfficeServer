package com.smartoffice.server.database.dto.company;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

public class CompanyDTO {
    @Getter
    @Setter
    private Long companyId;

    @Getter
    @Setter
    private String companyName;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private Integer numberOfEmployees;

    @Getter
    @Setter
    private LocalDateTime foundationDate;
}
