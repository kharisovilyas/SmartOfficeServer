package com.smartoffice.server.features.controller.qr;

import com.smartoffice.server.database.dto.qr.QRAccessDTO;
import com.smartoffice.server.database.dto.rooms.RoomDTO;
import com.smartoffice.server.features.service.qr.QRAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/qr/access")
public class QRAccessController {
    private final QRAccessService qrAccessService;

    @Autowired
    public QRAccessController(QRAccessService qrAccessService) {
        this.qrAccessService = qrAccessService;
    }

    @GetMapping("get/all")
    public ResponseEntity<List<QRAccessDTO>> getAllRooms() {
        return ResponseEntity.ok(qrAccessService.getQRAccesses());
    }
}
