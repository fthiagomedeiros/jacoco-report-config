package com.example.jacocotestproject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CustomController {

    @PostMapping("/test")
    public ResponseEntity<String> post() {
        return new ResponseEntity<>("Hello World!", HttpStatus.CREATED);
    }
}
