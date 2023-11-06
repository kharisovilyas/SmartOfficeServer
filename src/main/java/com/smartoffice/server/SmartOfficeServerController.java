package com.smartoffice.server;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmartOfficeServerController {
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, World!";
    }
}