package com.speakingClock.SpeakingClock.ServiceImpl;

import com.speakingClock.SpeakingClock.Exceptions.InvalidTimeFormatException;
import com.speakingClock.SpeakingClock.Services.SpeakingClockService;
import org.springframework.stereotype.Service;

@Service
public class SpeakingServiceImpl implements SpeakingClockService {
    private static final String[] HOURS = {"twelve", "one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine", "ten", "eleven", "twelve", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine", "ten", "eleven"};
    private static final String[] MINUTES = {
            "o'clock", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four",
            "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine", "thirty",
            "thirty one", "thirty two", "thirty three", "thirty four", "thirty five", "thirty six",
            "thirty seven", "thirty eight", "thirty nine", "forty", "forty one", "forty two",
            "forty three", "forty four", "forty five", "forty six", "forty seven", "forty eight",
            "forty nine", "fifty", "fifty one", "fifty two", "fifty three", "fifty four", "fifty five",
            "fifty six", "fifty seven", "fifty eight", "fifty nine"
    };

    @Override
    public String convertTimeToWords(String time) {
        if (!time.matches("^([01]?\\d|2[0-3]):[0-5]\\d$")) {

            throw new InvalidTimeFormatException("Invalid time format. Expected HH:mm");
        }

        if (time.equals("00:00")) return "It's Midnight";
        if (time.equals("12:00")) return "It's Midday";

        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        return "It's " + HOURS[hour] + (minute == 0 ? " o'clock" : " " + MINUTES[minute]);
    }
}
