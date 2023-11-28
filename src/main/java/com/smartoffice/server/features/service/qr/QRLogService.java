package com.smartoffice.server.features.service.qr;

import com.smartoffice.server.database.dto.qr.QRLogDTO;
import com.smartoffice.server.database.entity.qr.QRLogData;
import com.smartoffice.server.features.repository.qr.QRLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class QRLogService {
    private final QRLogRepository qrLogRepository;

    public QRLogService(QRLogRepository qrLogRepository) {
        this.qrLogRepository = qrLogRepository;
    }

    public List<QRLogDTO> getQRLogs() {
        List<QRLogData> qrLogs = StreamSupport.stream(qrLogRepository.findAll().spliterator(), true).toList();
        // Преобразуем список компаний в список DTO
        return qrLogs.stream()
                .map(this::mapToLogDTO)
                .toList();
    }

    private QRLogDTO mapToLogDTO(QRLogData qrLogData) {
        return null;
    }

    private QRLogData mapToLogData(QRLogDTO qrLogDTO) {
        return null;
    }
}
