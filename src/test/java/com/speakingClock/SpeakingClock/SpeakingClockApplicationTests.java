package com.speakingClock.SpeakingClock;

import com.speakingClock.SpeakingClock.Exceptions.InvalidTimeFormatException;
import com.speakingClock.SpeakingClock.ServiceImpl.SpeakingServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpeakingClockApplicationTests {

    @Autowired
    private SpeakingServiceImpl speakingService;

    @Test
    void testValidTime() {
        Assertions.assertEquals("It's eight thirty four", speakingService.convertTimeToWords("08:34"));
    }

    @Test
    void testMidnight() {
        Assertions.assertEquals("It's Midnight", speakingService.convertTimeToWords("00:00"));
    }

    @Test
    void testMidday() {
        Assertions.assertEquals("It's Midday", speakingService.convertTimeToWords("12:00"));
    }

    @Test
    void testInvalidTime() {
        Assertions.assertThrows(InvalidTimeFormatException.class, () -> {
            speakingService.convertTimeToWords("25:61");
        });
    }

}
