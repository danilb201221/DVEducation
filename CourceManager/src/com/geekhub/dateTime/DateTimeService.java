package com.geekhub.dateTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeService {

    private String dateFormat = "yyyy-MM-dd HH:mm";


    public LocalDateTime strToLDT(String strDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        LocalDateTime ldt = LocalDateTime.parse(strDate, formatter);
        return ldt;
    }

    public String getDateFormat() {
        return dateFormat;
    }
}
