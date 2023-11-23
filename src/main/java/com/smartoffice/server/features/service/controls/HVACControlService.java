package com.smartoffice.server.features.service.controls;

import com.smartoffice.server.database.dto.control.HVACControlDTO;
import com.smartoffice.server.database.entity.control.HVACControlData;
import com.smartoffice.server.database.entity.rooms.RoomData;
import com.smartoffice.server.features.repository.RoomRepository;
import com.smartoffice.server.features.repository.controls.HVACControlRepository;
import com.smartoffice.server.features.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class  HVACControlService {

    private final HVACControlRepository hvacControlRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public  HVACControlService(HVACControlRepository hvacControlRepository, RoomRepository roomRepository) {
        this.hvacControlRepository = hvacControlRepository;
        this.roomRepository = roomRepository;
    }

    public ResponseEntity<ApiResponse> updateHVACControl(HVACControlDTO  hvacControlDTO) {
        HVACControlData existingHVACControl =  hvacControlRepository.findByControlId(hvacControlDTO.getControlId());

        if (existingHVACControl != null) {
            // Если запись существует, обновляем данные
            existingHVACControl.setTemperature(hvacControlDTO.getTemperature());
            existingHVACControl.setControlTime(hvacControlDTO.getControlTime());
            hvacControlRepository.save(existingHVACControl);
            RoomData roomData = roomRepository.findByRoomName(hvacControlDTO.getRoomName());
            if (roomData != null) {
                existingHVACControl.setRoom(roomData);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Room not found"));
            }
            existingHVACControl.setRoom(roomData);
            return ResponseEntity.ok(new ApiResponse(" HVAC Control data successfully updated"));
        } else {
            // Если запись не существует, создаем новую запись
            HVACControlData newHvacControlData = mapToHvacControlEntity(hvacControlDTO);
            RoomData roomData = roomRepository.findByRoomName(hvacControlDTO.getRoomName());
            if (roomData != null) {
                newHvacControlData.setRoom(roomData);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Room not found"));
            }
            newHvacControlData.setRoom(roomData);
            hvacControlRepository.save(newHvacControlData);
            return ResponseEntity.ok(new ApiResponse(" HVAC Control data successfully added"));
        }
    }

    public List< HVACControlDTO> getAllHVACControl() {
        List< HVACControlData> companies = StreamSupport.stream(hvacControlRepository.findAll().spliterator(), true).toList();
        // Преобразуем список компаний в список DTO
        return companies.stream()
                .map(this::mapToHVACControlDTO)
                .toList();
    }

    private  HVACControlDTO mapToHVACControlDTO(HVACControlData hvacControlData) {
        HVACControlDTO hvacControlDTO = new  HVACControlDTO();
        hvacControlDTO.setControlId(hvacControlDTO.getControlId());
        hvacControlDTO.setControlTime(hvacControlDTO.getControlTime());
        hvacControlDTO.setRoom(hvacControlDTO.getRoom());
        return  hvacControlDTO;
    }

    private  HVACControlData mapToHvacControlEntity(HVACControlDTO  HVACControlDTO) {
        // Здесь может быть логика маппинга DTO на сущность
        // Например, использование ModelMapper или вручную установка полей
        HVACControlData  HVACControlData = new  HVACControlData();
        HVACControlData.setControlId( HVACControlDTO.getControlId());

        HVACControlData.setControlTime( HVACControlDTO.getControlTime());
        return  HVACControlData;
    }
}