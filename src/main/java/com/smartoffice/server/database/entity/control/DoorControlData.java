package com.smartoffice.server.database.entity.control;

import javax.persistence.*;

import com.smartoffice.server.database.entity.rooms.RoomData;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "Door_Control")
public class DoorControlData {
    @Id
    @Column(name = "control_id")
    private Long controlId;

    @Column(name = "door_status")
    private String doorStatus;

    @Column(name = "control_time")
    private LocalDateTime controlTime;

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    private RoomData room;
}
