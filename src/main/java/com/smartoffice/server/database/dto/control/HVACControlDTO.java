package com.smartoffice.server.database.dto.control;

import com.smartoffice.server.database.entity.rooms.RoomData;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class HVACControlDTO {
    private Long controlId;
    private Double temperature;
    private Double humidity;
    private LocalDateTime controlTime;
    private String roomName;
    private RoomData room;
}
