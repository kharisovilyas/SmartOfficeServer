package com.smartoffice.server.features.controller.controls;

import com.smartoffice.server.database.dto.control.LightingControlDTO;
import com.smartoffice.server.features.response.ApiResponse;
import com.smartoffice.server.features.service.controls.LightingControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/control/lighting")
public class LightingControlController {
    private final LightingControlService lightingControlService;

    @Autowired
    public LightingControlController(LightingControlService lightingControlService) {
        this.lightingControlService = lightingControlService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<LightingControlDTO>> getAllLighting() {
        return ResponseEntity.ok(lightingControlService.getAllLighting());
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponse> updateLightingControl(@RequestBody LightingControlDTO lightingControlDTO) {
        return lightingControlService.updateLightingControl(lightingControlDTO);
    }
}
