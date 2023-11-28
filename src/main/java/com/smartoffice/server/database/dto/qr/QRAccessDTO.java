package com.smartoffice.server.database.dto.qr;

import com.smartoffice.server.database.entity.control.DoorControlData;
import com.smartoffice.server.database.entity.rooms.RoomData;
import com.smartoffice.server.database.entity.users.UserData;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class QRAccessDTO {
    private Long accessId;
    private UserData user;
    private List<DoorControlData> doors = new ArrayList<>();
    private String qrCode;
    private String accessStatus;
    private LocalDateTime expirationTime;
    private RoomData room;
}
