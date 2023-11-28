package com.smartoffice.server.database.entity.control;

import javax.persistence.*;

import com.smartoffice.server.database.entity.qr.QRAccessData;
import com.smartoffice.server.database.entity.rooms.RoomData;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "Door_Control")
public class DoorControlData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "control_id")
    private Long controlId;

    @Column(name="control_name")
    private String controlName;

    @Column(name = "door_status")
    private String doorStatus;

    @Column(name = "control_time")
    private LocalDateTime controlTime;

    @ManyToMany(mappedBy = "doors")
    private List<QRAccessData> qrAccessList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    private RoomData room;
}
