package com.geekhub;

import com.geekhub.dateTime.DateTimeService;

import java.time.LocalDateTime;

public class DateTimeConsole {

    MainConsole mainConsole = new MainConsole();
    DateTimeService dateService = new DateTimeService();

    public LocalDateTime addLocalDateTime() {
        System.out.println("Enter date in format: '" + dateService.getDateFormat() + "'");
        String strDate = mainConsole.getString();
        return dateService.strToLDT(strDate);
    }

}
