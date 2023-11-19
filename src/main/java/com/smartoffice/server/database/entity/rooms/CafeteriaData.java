package com.smartoffice.server.database.entity.rooms;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Cafeteria")
public class CafeteriaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cafeteria_id")
    @Getter
    @Setter
    private Long cafeteriaId;

    @Column(name = "cafeteria_name")
    @Getter
    @Setter
    private String cafeteriaName;

    @Column(name = "capacity")
    @Getter
    @Setter
    private Integer capacity;

    @Column(name = "rental_id")
    @Getter
    @Setter
    private Long rentalId;

    @Column(name = "room_id")
    @Getter
    @Setter
    private Long roomId;
}
