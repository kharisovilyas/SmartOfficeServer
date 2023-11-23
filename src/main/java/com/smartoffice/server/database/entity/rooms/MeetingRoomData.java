package com.smartoffice.server.database.entity.rooms;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "Meeting_Room")
public class MeetingRoomData {
    @Id
    @Column(name = "meetingroom_id")
    private Long meetingroomId;

    @Column(name = "meetingroom_name")
    private String meetingroomName;

    @Column(name = "room_id")
    private Long roomId;
}