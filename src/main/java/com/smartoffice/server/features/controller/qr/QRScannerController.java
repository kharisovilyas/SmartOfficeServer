package com.smartoffice.server.features.controller.qr;

import com.smartoffice.server.database.dto.qr.QRScannerDTO;
import com.smartoffice.server.features.response.ApiResponse;
import com.smartoffice.server.features.service.qr.QRScannerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/qr/scanner")
public class QRScannerController {
    private final QRScannerService qrAccessService;
    public QRScannerController(QRScannerService qrScannerService) {
        this.qrAccessService = qrScannerService;
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponse> updateQRScanner(@RequestBody QRScannerDTO qrScannerDTO){
        return qrAccessService.updateQRScanner(qrScannerDTO);
    }

    @GetMapping("get/all")
    public ResponseEntity<List<QRScannerDTO>> getAllRooms() {
        return ResponseEntity.ok(qrAccessService.getQRScanners());
    }
}
