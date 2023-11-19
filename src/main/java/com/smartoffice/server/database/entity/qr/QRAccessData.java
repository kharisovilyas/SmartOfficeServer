package com.smartoffice.server.database.entity.qr;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "QR_Access")
public class QRAccessData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "access_id")
    @Getter
    @Setter
    private Long accessId;

    @Column(name = "user_id", unique = true)
    @Getter
    @Setter
    private Long userId;

    //добавить doorId !

    @Column(name = "qr_code", unique = true)
    @Getter
    @Setter
    String qrCode;

    @Column(name = "access_status")
    @Getter
    @Setter
    private String accessStatus;

    @Column(name = "expiration_time")
    @Getter
    @Setter
    private LocalDateTime expirationTime;

    @Column(name = "room_id")
    @Getter
    @Setter
    private Long roomId;
}
