package com.speakingClock.SpeakingClock.Controller;

import com.speakingClock.SpeakingClock.Services.SpeakingClockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/time")

public class SpeakingController {

    @Autowired
    private SpeakingClockService speakingClockService;


    @GetMapping("/convert")
    public ResponseEntity<String> convertTime(@RequestParam String time) {
        return ResponseEntity.ok(speakingClockService.convertTimeToWords(time));
    }

}
