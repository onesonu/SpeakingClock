package com.speakingClock.SpeakingClock.Exceptions;


public class InvalidTimeFormatException extends RuntimeException {
    public InvalidTimeFormatException(String message) {
        super(message);
    }
}
