package com.course.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivenessReadinessController {

    @GetMapping("/healthz")
    public ResponseEntity healthCheck () {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("readiness")
    public ResponseEntity readCheck () {
        return new ResponseEntity(HttpStatus.OK);
    }
}
