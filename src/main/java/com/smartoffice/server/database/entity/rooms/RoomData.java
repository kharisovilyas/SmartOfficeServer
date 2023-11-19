package com.smartoffice.server.database.entity.rooms;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Room")
public class RoomData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @Getter
    @Setter
    private Long roomId;

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Column(name = "capacity")
    @Getter
    @Setter
    private Integer capacity; // вместимость

    //добавить текущее количество людей.

    @Column(name = "rental_id")
    @Getter
    @Setter
    private Long rentalId;
}
