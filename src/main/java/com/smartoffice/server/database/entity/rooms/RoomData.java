package com.smartoffice.server.database.entity.rooms;

import javax.persistence.*;

import com.smartoffice.server.database.entity.schedule.ScheduleData;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Room")
public class RoomData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long roomId;

    @Column(name = "room_name")
    private String roomName;

    @OneToMany(mappedBy = "room")
    private List<ScheduleData> schedules;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "floor")
    private Integer floor;
}