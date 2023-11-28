package com.smartoffice.server.features.controller.qr;

import com.smartoffice.server.database.dto.qr.QRLogDTO;
import com.smartoffice.server.features.service.qr.QRLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/qr/log")
public class QRLogController {
    private final QRLogService qrLogService;

    @Autowired
    public QRLogController(QRLogService qrLogService) {
        this.qrLogService = qrLogService;
    }

    @GetMapping("get/all")
    public ResponseEntity<List<QRLogDTO>> getAllRooms() {
        return ResponseEntity.ok(qrLogService.getQRLogs());
    }
}
