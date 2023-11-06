package com.smartoffice.server;

import com.smartoffice.server.features.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmartOfficeServerController {
    @GetMapping("/hello")
    public ResponseEntity<ApiResponse> helloWorld() {
        return ResponseEntity.ok(new ApiResponse("Hello world!"));
    }
}