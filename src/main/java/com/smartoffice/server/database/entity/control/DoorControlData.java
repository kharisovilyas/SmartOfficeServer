package com.smartoffice.server.database.entity.control;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "Door_Control")
public class DoorControlData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "control_id")
    @Getter
    @Setter
    private Integer controlId;

    @Column(name = "door_status")
    @Getter
    @Setter
    private String doorStatus;

    @Column(name = "control_time")
    @Getter
    @Setter
    private LocalDateTime controlTime;

    @Column(name = "room_id")
    @Getter
    @Setter
    private Integer roomId;

    @Column(name = "rental_id")
    @Getter
    @Setter
    private Integer rentalId;
}
