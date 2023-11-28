package com.smartoffice.server.database.dto.control;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smartoffice.server.database.entity.rooms.RoomData;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class LightingControlDTO {
    private Long controlId;
    private String controlName;
    private Integer brightness;
    private Integer colorTemperature;
    private LocalDateTime controlTime;
    private String roomName;
    @JsonIgnore
    private RoomData room;
}
