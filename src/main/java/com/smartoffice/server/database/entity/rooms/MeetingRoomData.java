package com.smartoffice.server.database.entity.rooms;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Meeting_Room")
public class MeetingRoomData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meetingroom_id")
    @Getter
    @Setter
    private Integer meetingRoomId;

    @Column(name = "meetingroom_name")
    @Getter
    @Setter
    private String meetingRoomName;

    @Column(name = "capacity")
    @Getter
    @Setter
    private Integer capacity;

    @Column(name = "room_id")
    @Getter
    @Setter
    private Long roomId;

    @Column(name = "rental_id")
    @Getter
    @Setter
    private Long rentalId;
}
