package com.smartoffice.server.features.service.controls;

import com.smartoffice.server.database.dto.control.LightingControlDTO;
import com.smartoffice.server.database.entity.control.LightingControlData;
import com.smartoffice.server.database.entity.rooms.RoomData;
import com.smartoffice.server.features.repository.room.RoomRepository;
import com.smartoffice.server.features.repository.sensor.LightingControlRepository;
import com.smartoffice.server.features.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LightingControlService {

    private final LightingControlRepository lightingControlRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public LightingControlService(LightingControlRepository lightingControlRepository, RoomRepository roomRepository) {
        this.lightingControlRepository = lightingControlRepository;
        this.roomRepository = roomRepository;
    }

    public ResponseEntity<ApiResponse> updateLightingControl(LightingControlDTO lightingControlDTO) {
        LightingControlData existingLightingControl = lightingControlRepository.findByControlId(lightingControlDTO.getControlId());

        if (existingLightingControl != null) {
            // Если запись существует, обновляем данные
            existingLightingControl.setControlTime(lightingControlDTO.getControlTime());
            existingLightingControl.setColorTemperature(lightingControlDTO.getColorTemperature());
            existingLightingControl.setBrightness(lightingControlDTO.getBrightness());

            RoomData roomData = roomRepository.findByRoomName(lightingControlDTO.getRoomName());
            if (roomData != null) {
                existingLightingControl.setRoom(roomData);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Room not found"));
            }

            lightingControlRepository.save(existingLightingControl);
            return ResponseEntity.ok(new ApiResponse("Lighting Control data successfully updated"));
        } else {
            // Если запись не существует, создаем новую запись
            LightingControlData newLightingControl = mapToLightingControlEntity(lightingControlDTO);
            RoomData roomData = roomRepository.findByRoomName(lightingControlDTO.getRoomName());
            if (roomData != null) {
                newLightingControl.setRoom(roomData);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Room not found"));
            }
            lightingControlRepository.save(newLightingControl);
            return ResponseEntity.ok(new ApiResponse("Lighting Control data successfully added"));
        }
    }

    public List<LightingControlDTO> getAllLighting() {
        List<LightingControlData> lightingControls = StreamSupport
                .stream(lightingControlRepository.findAll().spliterator(), false)
                .toList();

        // Преобразуем список в список DTO
        return lightingControls.stream()
                .map(this::mapToListingControlDTO)
                .collect(Collectors.toList());
    }

    private LightingControlDTO mapToListingControlDTO(LightingControlData lightingControlData) {
        LightingControlDTO lightingControlDTO = new LightingControlDTO();
        lightingControlDTO.setControlId(lightingControlData.getControlId());
        lightingControlDTO.setColorTemperature(lightingControlData.getColorTemperature());
        lightingControlDTO.setBrightness(lightingControlData.getBrightness());
        lightingControlDTO.setControlTime(lightingControlData.getControlTime());
        return lightingControlDTO;
    }

    private LightingControlData mapToLightingControlEntity(LightingControlDTO lightingControlDTO) {
        LightingControlData lightingControlData = new LightingControlData();
        lightingControlData.setControlId(lightingControlData.getControlId());
        lightingControlData.setControlName(lightingControlData.getControlName());
        lightingControlData.setColorTemperature(lightingControlDTO.getColorTemperature());
        lightingControlData.setBrightness(lightingControlDTO.getBrightness());
        lightingControlData.setControlTime(lightingControlDTO.getControlTime());
        return lightingControlData;
    }
}
