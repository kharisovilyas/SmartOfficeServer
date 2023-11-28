package com.smartoffice.server.database.entity.qr;
import com.smartoffice.server.database.entity.users.UserData;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Data
@Table(name = "QR_Log")
public class QRLogData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private Long logId;

    @ManyToOne
    @JoinColumn(name = "scanner_id")
    private QRScannerData scanner;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserData user;

    @Column(name = "scan_time")
    private LocalDateTime scanTime;
}
