package com.geekhub.dateTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateTimeService {

    private final String dateFormat = "yyyy-MM-dd HH:mm";


    public LocalDateTime strToLDT(String strDate) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        return LocalDateTime.parse(strDate, formatter);
    }

    public String getDateFormat() {
        return dateFormat;
    }
}
