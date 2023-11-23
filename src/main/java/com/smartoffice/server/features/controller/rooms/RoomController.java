package com.smartoffice.server.features.controller.rooms;

import com.smartoffice.server.database.dto.control.LightingControlDTO;
import com.smartoffice.server.database.dto.rooms.RoomDTO;
import com.smartoffice.server.features.response.ApiResponse;
import com.smartoffice.server.features.service.controls.LightingControlService;
import com.smartoffice.server.features.service.rooms.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/room")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<RoomDTO>> getAllRooms() {
        return ResponseEntity.ok(roomService.getAllRooms());
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponse> updateRoom(@RequestBody RoomDTO roomDTO) {
        return roomService.updateRoom(roomDTO);
    }
}
