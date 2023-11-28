package com.smartoffice.server.features.repository.qr;

import com.smartoffice.server.database.entity.qr.QRLogData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QRLogRepository extends CrudRepository<QRLogData, Long> {
}
