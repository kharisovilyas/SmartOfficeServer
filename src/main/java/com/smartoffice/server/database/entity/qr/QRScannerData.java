package com.smartoffice.server.database.entity.qr;
import com.smartoffice.server.database.entity.rooms.RoomData;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "QR_Scanner")
@Data
public class QRScannerData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scanner_id")
    private Long scannerId;

    @Column(name = "scanner_name")
    private String scannerName;

    @Column(name = "location")
    private String location;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomData room;
}
