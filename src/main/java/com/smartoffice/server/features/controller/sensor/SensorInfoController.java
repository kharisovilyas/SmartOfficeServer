package com.smartoffice.server.features.controller.sensor;
import com.smartoffice.server.database.dto.sensors.SensorInfoDTO;
import com.smartoffice.server.features.response.ApiResponse;
import com.smartoffice.server.features.service.sensors.SensorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensor-info/")
public class SensorInfoController {

    private final SensorInfoService sensorInfoService;

    @Autowired
    public SensorInfoController(SensorInfoService sensorInfoService) {
        this.sensorInfoService = sensorInfoService;
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponse> updateSensorInfo(@RequestBody SensorInfoDTO sensorInfoDTO) {
        return sensorInfoService.updateSensorInfo(sensorInfoDTO);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<SensorInfoDTO>> getAllSensorInfo() {
        return ResponseEntity.ok(sensorInfoService.getAllSensorInfo());
    }
}
