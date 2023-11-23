package com.smartoffice.server.database.dto.control;
import com.smartoffice.server.database.entity.rooms.RoomData;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class DoorControlDTO {
    private Long controlId;
    private String doorStatus;
    private LocalDateTime controlTime;
    private RoomData room;
    private String roomName;
}
