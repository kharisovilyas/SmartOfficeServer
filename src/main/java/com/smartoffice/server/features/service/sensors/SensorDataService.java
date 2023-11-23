package com.smartoffice.server.features.service.sensors;

import com.smartoffice.server.database.dto.sensors.SensorDataDTO;
import com.smartoffice.server.database.entity.sensors.SensorData;
import com.smartoffice.server.database.entity.sensors.SensorInfoData;
import com.smartoffice.server.features.repository.sensor.SensorInfoRepository;
import com.smartoffice.server.features.repository.sensor.SensorRepository;
import com.smartoffice.server.features.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SensorDataService {
    private final SensorRepository sensorDataRepository;
    private final SensorInfoRepository sensorInfoRepository;

    @Autowired
    public SensorDataService(SensorRepository sensorDataRepository, SensorInfoRepository sensorInfoRepository) {
        this.sensorDataRepository = sensorDataRepository;
        this.sensorInfoRepository = sensorInfoRepository;
    }

    @Transactional
    public ResponseEntity<ApiResponse> updateOfSensorData(SensorDataDTO sensorDataDTO) {
        SensorInfoData sensorInfoData = sensorInfoRepository.findBySensorName(sensorDataDTO.getSensorName());

        if (sensorInfoData != null) {
            SensorData newSensorData = new SensorData();
            newSensorData.setSensorInfo(sensorInfoData);
            newSensorData.setValue(sensorDataDTO.getValue());
            newSensorData.setTimestamp(sensorDataDTO.getTimestamp());

            // Сохраняем новые данные
            sensorDataRepository.save(newSensorData);

            return ResponseEntity.ok(new ApiResponse("SensorData added successfully"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("SensorInfoData not found"));
        }
    }



    public List<SensorDataDTO> getAllOfSensorData(String sensorName) {
        List<SensorData> sensorDataList = sensorDataRepository.findBySensorInfo_SensorName(sensorName);
        return sensorDataList.stream()
                .map(this::mapToSensorDataDTO)
                .collect(Collectors.toList());
    }


    private SensorDataDTO mapToSensorDataDTO(SensorData sensorData) {
        SensorDataDTO sensorDataDTO = new SensorDataDTO();
        sensorDataDTO.setSensorDataId(sensorData.getSensorDataId());
        sensorDataDTO.setSensorName(sensorData.getSensorInfo().getSensorName());
        sensorDataDTO.setValue(sensorData.getValue());
        sensorDataDTO.setTimestamp(sensorData.getTimestamp());
        return sensorDataDTO;
    }
    private SensorData mapToSensorData(SensorDataDTO sensorDataDTO) {
        SensorData sensorData = new SensorData();
        sensorData.setSensorDataId(sensorDataDTO.getSensorDataId());
        sensorData.setSensorInfo(sensorDataDTO.getSensorInfo());
        sensorData.setValue(sensorDataDTO.getValue());
        sensorData.setTimestamp(sensorDataDTO.getTimestamp());
        return sensorData;
    }
}
