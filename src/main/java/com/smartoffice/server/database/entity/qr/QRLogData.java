package com.smartoffice.server.database.entity.qr;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "QR_Log")
public class QRLogData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    @Getter
    @Setter
    private Integer logId;

    @Column(name = "scanner_id")
    @Getter
    @Setter
    private Integer scannerId;

    @Column(name = "user_id")
    @Getter
    @Setter
    private Integer userId;

    @Column(name = "scan_time")
    @Getter
    @Setter
    private LocalDateTime scanTime;
}
