package com.smartoffice.server.database.entity.qr;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "QR_Scanner")
public class QRScannerData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scanner_id")
    @Getter
    @Setter
    private Integer scannerId;

    @Column(name = "scanner_name")
    @Getter
    @Setter
    private String scannerName;

    @Column(name = "location")
    @Getter
    @Setter
    private String location;
}
