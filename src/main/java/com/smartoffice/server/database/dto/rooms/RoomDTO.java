package com.smartoffice.server.database.dto.rooms;

import com.smartoffice.server.database.entity.schedule.ScheduleData;
import lombok.Data;

import java.util.List;

@Data
public class RoomDTO {
    private Long roomId;
    private String roomName;
    private Integer capacity;
    private Integer floor;
}
