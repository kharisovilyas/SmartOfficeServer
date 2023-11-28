package com.smartoffice.server.features.service.controls;

import com.smartoffice.server.database.dto.control.DoorControlDTO;
import com.smartoffice.server.database.entity.control.DoorControlData;
import com.smartoffice.server.database.entity.rooms.RoomData;
import com.smartoffice.server.features.repository.controls.DoorControlRepository;
import com.smartoffice.server.features.repository.room.RoomRepository;
import com.smartoffice.server.features.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class DoorControlService {

    private final DoorControlRepository doorControlRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public DoorControlService(DoorControlRepository doorControlRepository, RoomRepository roomRepository) {
        this.doorControlRepository = doorControlRepository;
        this.roomRepository = roomRepository;
    }

    public ResponseEntity<ApiResponse> updateDoorControl(DoorControlDTO doorControlDTO) {
        DoorControlData existingDoorControl = doorControlRepository.findByControlId(doorControlDTO.getControlId());

        if (existingDoorControl != null) {
            // Если запись существует, обновляем данные
            existingDoorControl.setDoorStatus(doorControlDTO.getDoorStatus());
            existingDoorControl.setControlTime(doorControlDTO.getControlTime());
            doorControlRepository.save(existingDoorControl);

            RoomData roomData = roomRepository.findByRoomName(doorControlDTO.getRoomName());
            if (roomData != null) {
                existingDoorControl.setRoom(roomData);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Room not found"));
            }
            existingDoorControl.setRoom(roomData);
            return ResponseEntity.ok(new ApiResponse("Door Control data successfully updated"));
        } else {
            // Если запись не существует, создаем новую запись
            DoorControlData newDoorControl = mapToDoorControlEntity(doorControlDTO);
            RoomData roomData = roomRepository.findByRoomName(doorControlDTO.getRoomName());
            if (roomData != null) {
                newDoorControl.setRoom(roomData);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Room not found"));
            }
            newDoorControl.setRoom(roomData);
            doorControlRepository.save(newDoorControl);
            return ResponseEntity.ok(new ApiResponse("Door Control data successfully added"));
        }
    }

    public List<DoorControlDTO> getAllDoors() {
        List<DoorControlData> companies = StreamSupport.stream(doorControlRepository.findAll().spliterator(), true).toList();
        // Преобразуем список компаний в список DTO
        return companies.stream()
                .map(this::mapToDoorControlDTO)
                .toList();
    }

    private DoorControlDTO mapToDoorControlDTO(DoorControlData doorControlData) {
        DoorControlDTO doorControlDTO = new DoorControlDTO();
        doorControlDTO.setControlId(doorControlDTO.getControlId());
        doorControlDTO.setDoorStatus(doorControlDTO.getDoorStatus());
        doorControlDTO.setControlTime(doorControlDTO.getControlTime());
        doorControlDTO.setRoom(doorControlDTO.getRoom());
        return doorControlDTO;
    }

    private DoorControlData mapToDoorControlEntity(DoorControlDTO doorControlDTO) {
        // Здесь может быть логика маппинга DTO на сущность
        // Например, использование ModelMapper или вручную установка полей
        DoorControlData doorControlData = new DoorControlData();
        doorControlData.setControlId(doorControlDTO.getControlId());
        doorControlData.setDoorStatus(doorControlDTO.getDoorStatus());
        doorControlData.setControlTime(doorControlDTO.getControlTime());
        return doorControlData;
    }
}
