package com.smartoffice.server.features.service.controls;

import com.smartoffice.server.database.dto.control.HVACControlDTO;
import com.smartoffice.server.database.dto.sensors.SensorDataDTO;
import com.smartoffice.server.database.entity.control.HVACControlData;
import com.smartoffice.server.database.entity.rooms.RoomData;
import com.smartoffice.server.features.repository.controls.HVACControlRepository;
import com.smartoffice.server.features.repository.room.RoomRepository;
import com.smartoffice.server.features.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class HVACControlService {

    private final HVACControlRepository hvacControlRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public HVACControlService(HVACControlRepository hvacControlRepository, RoomRepository roomRepository) {
        this.hvacControlRepository = hvacControlRepository;
        this.roomRepository = roomRepository;
    }

    public ResponseEntity<ApiResponse> updateHVACControl(HVACControlDTO hvacControlDTO) {
        HVACControlData existingHVACControl = hvacControlRepository.findByControlName(hvacControlDTO.getControlName());
        if (existingHVACControl != null) {
            // Если запись существует, обновляем данные
            existingHVACControl.setTemperature(hvacControlDTO.getTemperature());
            existingHVACControl.setControlName(hvacControlDTO.getControlName());
            existingHVACControl.setHumidity(hvacControlDTO.getHumidity());

            RoomData roomData = roomRepository.findByRoomName(hvacControlDTO.getRoomName());
            if (roomData != null) {
                existingHVACControl.setRoom(roomData);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Room not found"));
            }

            hvacControlRepository.save(existingHVACControl);
            return ResponseEntity.ok(new ApiResponse("HVAC Control data successfully updated"));
        } else {
            // Если запись не существует, создаем новую запись
            HVACControlData newHvacControlData = mapToHvacControlEntity(hvacControlDTO);
            RoomData roomData = roomRepository.findByRoomName(hvacControlDTO.getRoomName());
            if (roomData != null) {
                newHvacControlData.setRoom(roomData);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Room not found"));
            }

            hvacControlRepository.save(newHvacControlData);
            return ResponseEntity.ok(new ApiResponse("HVAC Control data successfully added"));
        }
    }


    public List<HVACControlDTO> getAllHVACControl() {
        List<HVACControlData> companies = StreamSupport.stream(hvacControlRepository.findAll().spliterator(), true).toList();
        // Преобразуем список компаний в список DTO
        return companies.stream()
                .map(this::mapToHVACControlDTO)
                .toList();
    }

    private HVACControlDTO mapToHVACControlDTO(HVACControlData hvacControlData) {
        HVACControlDTO hvacControlDTO = new HVACControlDTO();
        hvacControlDTO.setControlTime(hvacControlData.getControlTime());
        hvacControlDTO.setHumidity(hvacControlData.getHumidity());
        hvacControlDTO.setControlName(hvacControlData.getControlName());
        hvacControlDTO.setTemperature(hvacControlData.getTemperature());
        hvacControlDTO.setRoom(hvacControlData.getRoom());
        return hvacControlDTO;
    }

    private HVACControlData mapToHvacControlEntity(HVACControlDTO hvacControlDTO) {
        HVACControlData hvacControlData = new HVACControlData();
        hvacControlData.setControlId(hvacControlDTO.getControlId()); // Установка controlId
        hvacControlData.setControlName(hvacControlDTO.getControlName());
        hvacControlData.setTemperature(hvacControlDTO.getTemperature());
        hvacControlData.setHumidity(hvacControlDTO.getHumidity());
        hvacControlData.setControlTime(hvacControlDTO.getControlTime());
        return hvacControlData;
    }

    public HVACControlDTO getHVACControlData(String hvacName) {
        HVACControlData existingHVACControl = hvacControlRepository.findByControlName(hvacName);
        if (existingHVACControl != null) {
            return mapToHVACControlDTO(existingHVACControl);
        }else{
            return new HVACControlDTO();
        }
    }
}