package com.smartoffice.server.features.repository.qr;

import com.smartoffice.server.database.entity.qr.QRScannerData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QRScannerRepository extends CrudRepository<QRScannerData, Long> {

    QRScannerData findByScannerName(String scannerName);
}
