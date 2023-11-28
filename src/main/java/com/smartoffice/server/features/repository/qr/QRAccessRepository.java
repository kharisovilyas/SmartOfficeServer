package com.smartoffice.server.features.repository.qr;

import com.smartoffice.server.database.entity.qr.QRAccessData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QRAccessRepository extends CrudRepository<QRAccessData, Long> {
}
