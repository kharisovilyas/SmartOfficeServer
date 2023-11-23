package com.smartoffice.server.database.entity.rooms;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Offices")
public class OfficesData {
    @Id
    @Column(name = "office_id")
    private Long officeId;

    @Column(name = "office_name")
    private String officeName;

    @Column(name = "company_id", unique = true)
    private Long companyId;

    @Column(name = "room_id")
    private Long roomId;
}