package com.smartoffice.server.database.entity.rooms;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Restroom")
public class RestroomData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restroom_id")
    @Getter
    @Setter
    private Long restroomId;

    @Column(name = "restroom_name")
    @Getter
    @Setter
    private String restroomName;

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
