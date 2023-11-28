package com.smartoffice.server.database.dto.qr;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
public class QRLogDTO {
    private Long logId;
    private Long scannerId;
    private Long userId;
    private LocalDateTime scanTime;
}
