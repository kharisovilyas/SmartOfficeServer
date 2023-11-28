package com.smartoffice.server.features.service.qr;

import com.smartoffice.server.database.dto.qr.QRScannerDTO;
import com.smartoffice.server.database.entity.qr.QRScannerData;
import com.smartoffice.server.database.entity.rooms.RoomData;
import com.smartoffice.server.features.repository.qr.QRScannerRepository;
import com.smartoffice.server.features.repository.room.RoomRepository;
import com.smartoffice.server.features.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;
@Service
public class QRScannerService {
    private final QRScannerRepository qrScannerRepository;
    private final RoomRepository roomRepository;

    public QRScannerService(QRScannerRepository qrScannerRepository, RoomRepository roomRepository) {
        this.qrScannerRepository = qrScannerRepository;
        this.roomRepository = roomRepository;
    }

    public List<QRScannerDTO> getQRScanners(){
        List<QRScannerData> qrScanners = StreamSupport.stream(qrScannerRepository.findAll().spliterator(), true).toList();
        // Преобразуем список компаний в список DTO
        return qrScanners.stream()
                .map(this::mapToScannerDTO)
                .toList();
    }

    public ResponseEntity<ApiResponse> updateQRScanner(QRScannerDTO qrScannerDTO) {
        QRScannerData existingQrScannerData = qrScannerRepository.findByScannerName(qrScannerDTO.getScannerName());
        if(existingQrScannerData != null){
            existingQrScannerData.setLocation(qrScannerDTO.getLocation());
            RoomData existingRoomData = roomRepository.findByRoomName(qrScannerDTO.getRoomName());
            if (existingRoomData != null) {
                existingQrScannerData.setRoom(existingRoomData);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Room not found"));
            }
            qrScannerRepository.save(existingQrScannerData);
            return ResponseEntity.ok(new ApiResponse("Data successfully updated"));
            //значит обновляем все поля, кроме name,
        }else{
            RoomData roomData = roomRepository.findByRoomName(qrScannerDTO.getRoomName());
            if (roomData != null) {
                QRScannerData newQRScannerData = mapToScannerData(qrScannerDTO);
                newQRScannerData.setRoom(roomData);
                qrScannerRepository.save(newQRScannerData);
                return ResponseEntity.ok(new ApiResponse("Data successfully added"));
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Room not found"));
            }
        }
    }

    private QRScannerDTO mapToScannerDTO(QRScannerData qrScannerData) {
        QRScannerDTO qrScannerDTO = new QRScannerDTO();
        qrScannerDTO.setLocation(qrScannerData.getLocation());
        qrScannerDTO.setScannerName(qrScannerData.getScannerName());
        qrScannerDTO.setRoomName(qrScannerData.getRoom().getRoomName());
        return qrScannerDTO;
    }

    private QRScannerData mapToScannerData(QRScannerDTO qrScannerDTO) {
        QRScannerData qrScannerData = new QRScannerData();
        qrScannerData.setScannerName(qrScannerDTO.getScannerName());
        qrScannerData.setLocation(qrScannerData.getLocation());
        return qrScannerData;
    }


}
