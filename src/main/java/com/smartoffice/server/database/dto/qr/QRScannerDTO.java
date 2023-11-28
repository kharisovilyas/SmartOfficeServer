package com.smartoffice.server.database.dto.qr;

import com.smartoffice.server.database.entity.rooms.RoomData;
import lombok.Data;

@Data
public class QRScannerDTO {
    private Long scannerId;
    private String scannerName;
    private String location;
    private String roomName;
    private RoomData room;
}
