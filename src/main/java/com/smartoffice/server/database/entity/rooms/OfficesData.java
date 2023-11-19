package com.smartoffice.server.database.entity.rooms;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Offices")
public class OfficesData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "office_id")
    @Getter
    @Setter
    private Long office_id;

    @Column(name = "office_name")
    @Getter
    @Setter
    private String officeName;

    @Column(name = "capacity")
    @Getter
    @Setter
    private Integer capacity;

    @Column(name = "floor")
    @Getter
    @Setter
    private Integer floor;

    @Column(name = "rental_id")
    @Getter
    @Setter
    private Long rentalId;

    @Column(name = "company_id")
    @Getter
    @Setter
    private Long companyId;

    @Column(name = "room_id")
    @Getter
    @Setter
    private Long roomId;
}
