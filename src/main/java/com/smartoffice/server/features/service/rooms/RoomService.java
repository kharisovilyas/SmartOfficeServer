package com.smartoffice.server.features.service.rooms;

import com.smartoffice.server.database.dto.rooms.RoomDTO;
import com.smartoffice.server.database.entity.rooms.RoomData;
import com.smartoffice.server.features.repository.RoomRepository;
import com.smartoffice.server.features.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<RoomDTO> getAllRooms() {
        List<RoomData> companies = StreamSupport.stream(roomRepository.findAll().spliterator(), true).toList();
        // Преобразуем список компаний в список DTO
        return companies.stream()
                .map(this::mapToRoomDTO)
                .toList();
    }
    public ResponseEntity<ApiResponse> updateRoom(RoomDTO lightingControlDTO) {
        return null;
    }
    public RoomDTO mapToRoomDTO(RoomData roomData) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setRoomId(roomData.getRoomId());
        roomDTO.setRoomName(roomData.getRoomName());
        roomDTO.setCapacity(roomData.getCapacity());
        roomDTO.setFloor(roomData.getFloor());
        roomDTO.setSchedules(roomData.getSchedules());
        return roomDTO;
    }

    public RoomData mapToRoomData(RoomDTO roomDTO) {
        RoomData roomData = new RoomData();
        roomData.setRoomId(roomDTO.getRoomId());
        roomData.setRoomName(roomDTO.getRoomName());
        roomData.setCapacity(roomDTO.getCapacity());
        roomData.setFloor(roomDTO.getFloor());
        return roomData;
    }

}
