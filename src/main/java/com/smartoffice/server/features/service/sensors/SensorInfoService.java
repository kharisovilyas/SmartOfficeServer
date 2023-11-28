package com.smartoffice.server.features.service.sensors;

import com.smartoffice.server.database.dto.sensors.SensorInfoDTO;
import com.smartoffice.server.database.entity.rooms.RoomData;
import com.smartoffice.server.database.entity.sensors.SensorInfoData;
import com.smartoffice.server.database.entity.sensors.SensorTypeData;
import com.smartoffice.server.features.repository.room.RoomRepository;
import com.smartoffice.server.features.repository.sensor.SensorInfoRepository;
import com.smartoffice.server.features.repository.sensor.SensorRepository;
import com.smartoffice.server.features.repository.sensor.SensorTypeRepository;
import com.smartoffice.server.features.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SensorInfoService {

    private final SensorInfoRepository sensorInfoRepository;
    private final SensorTypeRepository sensorTypeRepository;
    private final RoomRepository roomRepository;
    private final SensorRepository sensorRepository;

    @Autowired
    public SensorInfoService(SensorInfoRepository sensorInfoRepository, SensorTypeRepository sensorTypeRepository, RoomRepository roomRepository, SensorRepository sensorRepository) {
        this.sensorInfoRepository = sensorInfoRepository;
        this.sensorTypeRepository = sensorTypeRepository;
        this.roomRepository = roomRepository;
        this.sensorRepository = sensorRepository;
    }

    @Transactional
    public ResponseEntity<ApiResponse> updateSensorInfo(SensorInfoDTO sensorInfoDTO) {
        SensorInfoData existingSensorInfo = sensorInfoRepository.findBySensorName(sensorInfoDTO.getSensorName());
        if (existingSensorInfo != null) {
            existingSensorInfo.setDescription(sensorInfoDTO.getDescription());
            existingSensorInfo.setLocation(sensorInfoDTO.getLocation());
            existingSensorInfo.setStatus(sensorInfoDTO.getStatus());
            existingSensorInfo.setSensorDataList(
                    StreamSupport.stream(sensorRepository.findAll().spliterator(), true)
                            .collect(Collectors.toList())
            );
            SensorTypeData existingSensorTypeData = sensorTypeRepository.findByTypeName(sensorInfoDTO.getTypeName());
            if (existingSensorTypeData != null) {
                existingSensorInfo.setSensorType(existingSensorTypeData);
            } else {
                SensorTypeData newSensorTypeData = new SensorTypeData();
                newSensorTypeData.setTypeName(sensorInfoDTO.getTypeName());
                sensorTypeRepository.save(newSensorTypeData);
                existingSensorInfo.setSensorType(newSensorTypeData);
            }
            RoomData existingRoomData = roomRepository.findByRoomName(sensorInfoDTO.getRoomName());
            if (existingRoomData != null) {
                existingSensorInfo.setRoomData(existingRoomData);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Room not found"));
            }
            sensorInfoRepository.save(existingSensorInfo);
            return ResponseEntity.ok(new ApiResponse("Data successfully updated"));

        } else {
            RoomData roomData = roomRepository.findByRoomName(sensorInfoDTO.getRoomName());
            if (roomData != null) {
                SensorInfoData newSensorInfoData = mapToSensorInfoEntity(sensorInfoDTO);
                newSensorInfoData.setRoomData(roomData);
                sensorInfoRepository.save(newSensorInfoData);
                return ResponseEntity.ok(new ApiResponse("Data successfully added"));
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Room not found"));
            }
        }
    }


    private SensorInfoData mapToSensorInfoEntity(
            SensorInfoDTO sensorInfoDTO
    ) {
        // Создаем Data на основе сущности SensorInfoDTO
        SensorInfoData sensorInfoData = new SensorInfoData();
        sensorInfoData.setSensorName(sensorInfoDTO.getSensorName());
        sensorInfoData.setLocation(sensorInfoDTO.getLocation());
        sensorInfoData.setDescription(sensorInfoDTO.getDescription());
        sensorInfoData.setStatus(sensorInfoDTO.getStatus());
        sensorInfoData.setSensorType(sensorTypeRepository.findByTypeName(sensorInfoDTO.getTypeName()));
        sensorInfoData.setSensorDataList(
                StreamSupport.stream(sensorRepository.findAll().spliterator(), true).toList()
        );
        return sensorInfoData;
    }

    private SensorInfoDTO mapToSensorInfoDTO(SensorInfoData sensorInfoData) {
        // Создаем DTO на основе сущности SensorInfoData
        SensorInfoDTO sensorInfoDTO = new SensorInfoDTO();
        sensorInfoDTO.setSensorId(sensorInfoData.getSensorId());
        sensorInfoDTO.setSensorName(sensorInfoData.getSensorName());
        sensorInfoDTO.setLocation(sensorInfoData.getLocation());
        sensorInfoDTO.setDescription(sensorInfoData.getDescription());
        sensorInfoDTO.setStatus(sensorInfoData.getStatus());
        sensorInfoDTO.setTypeName(sensorInfoData.getSensorType().getTypeName());
        sensorInfoDTO.setRoomName(sensorInfoData.getRoomData().getRoomName());
        return sensorInfoDTO;
    }

    public List<SensorInfoDTO> getAllSensorInfo() {
        List<SensorInfoData> sensorInfoList = StreamSupport.stream(sensorInfoRepository.findAll().spliterator(), true).toList();
        // Преобразуем список SensorInfoData в список DTO
        return sensorInfoList.stream()
                .map(this::mapToSensorInfoDTO)
                .collect(Collectors.toList());
    }
}

