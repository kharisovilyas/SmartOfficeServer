package com.smartoffice.server.features.controller.controls;

import com.smartoffice.server.database.dto.company.CompanyDTO;
import com.smartoffice.server.database.dto.control.DoorControlDTO;
import com.smartoffice.server.features.response.ApiResponse;
import com.smartoffice.server.features.service.controls.DoorControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/control/door")
public class DoorControlController {
    private final DoorControlService doorControlService;

    @Autowired
    public DoorControlController(DoorControlService doorControlService) {
        this.doorControlService = doorControlService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<DoorControlDTO>> getAllDoors() {
        return ResponseEntity.ok(doorControlService.getAllDoors());
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponse> updateDoorsControl(@RequestBody DoorControlDTO doorControlDTO) {
        return doorControlService.updateDoorControl(doorControlDTO);
    }
}
