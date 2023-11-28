package com.smartoffice.server.features.service.qr;

import com.smartoffice.server.database.dto.qr.QRAccessDTO;
import com.smartoffice.server.database.entity.qr.QRAccessData;
import com.smartoffice.server.features.repository.qr.QRAccessRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;
@Service
public class QRAccessService {
    private final QRAccessRepository qrAccessRepository;

    public QRAccessService(QRAccessRepository qrAccessRepository) {
        this.qrAccessRepository = qrAccessRepository;
    }

    public List<QRAccessDTO> getQRAccesses() {
        List<QRAccessData> companies = StreamSupport.stream(qrAccessRepository.findAll().spliterator(), true).toList();
        // Преобразуем список компаний в список DTO
        return companies.stream()
                .map(this::mapToAccessDTO)
                .toList();
    }

    private QRAccessDTO mapToAccessDTO(QRAccessData qrAccessData) {
        return null;
    }

    private QRAccessData mapToAccessData(QRAccessDTO qrAccessDTO) {
        return null;
    }
}
