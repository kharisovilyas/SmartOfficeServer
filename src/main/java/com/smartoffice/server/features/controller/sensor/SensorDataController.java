package com.smartoffice.server.features.controller.sensor;

import com.smartoffice.server.database.dto.sensors.SensorDataDTO;
import com.smartoffice.server.features.response.ApiResponse;
import com.smartoffice.server.features.service.sensors.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensor-data/")
public class SensorDataController {

    private final SensorDataService sensorDataService;

    @Autowired
    public SensorDataController(SensorDataService sensorDataService) {
        this.sensorDataService = sensorDataService;
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponse> updateSensorInfo(@RequestBody SensorDataDTO sensorDataDTO) {
        return sensorDataService.updateOfSensorData(sensorDataDTO);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<SensorDataDTO>> getAllOfSensorData(@RequestParam String sensorName) {
        return ResponseEntity.ok(sensorDataService.getAllOfSensorData(sensorName));
    }
}
