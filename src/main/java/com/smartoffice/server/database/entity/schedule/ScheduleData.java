package com.smartoffice.server.database.entity.schedule;

import com.smartoffice.server.database.entity.rooms.RoomData;
import com.smartoffice.server.database.entity.users.UserData;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Schedule")
public class ScheduleData {
    @Id
    @Column(name = "schedule_id")
    private Long scheduleId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserData user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private RoomData room;
}