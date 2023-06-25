package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class RandomController {

    @GetMapping(value = "/random")
    public ResponseEntity<String> random() {
        Random random = new Random();
        if (random.nextBoolean()) {
            return ResponseEntity.badRequest().body("YOU DIE, RETURN TO CHECKPOINT ");
        }
        return ResponseEntity.ok("YOU LIVE! GG");
    }
}

