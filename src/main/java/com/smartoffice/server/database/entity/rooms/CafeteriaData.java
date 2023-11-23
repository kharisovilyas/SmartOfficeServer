package com.smartoffice.server.database.entity.rooms;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "Cafeteria")
public class CafeteriaData {
    @Id
    @Column(name = "cafeteria_id")
    private Long cafeteriaId;

    @Column(name = "cafeteria_name")
    private String cafeteriaName;

    @Column(name = "room_id")
    private Long roomId;
}