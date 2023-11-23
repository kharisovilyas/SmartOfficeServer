package com.smartoffice.server.features.controller.controls;

import com.smartoffice.server.database.dto.control.DoorControlDTO;
import com.smartoffice.server.database.dto.control.HVACControlDTO;
import com.smartoffice.server.features.response.ApiResponse;
import com.smartoffice.server.features.service.controls.HVACControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/control/hvac")
public class HVACControlController {
    private final HVACControlService hvacControlService;

    @Autowired
    public HVACControlController(HVACControlService hvacControlService) {
        this.hvacControlService = hvacControlService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<HVACControlDTO>> getAllHVAC() {
        return ResponseEntity.ok(hvacControlService.getAllHVACControl());
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponse> updateHVACControl(@RequestBody HVACControlDTO hvacControlDTO) {
        return hvacControlService.updateHVACControl(hvacControlDTO);
    }
}
