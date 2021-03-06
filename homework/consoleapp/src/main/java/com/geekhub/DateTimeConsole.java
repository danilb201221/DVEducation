package com.geekhub;

import com.geekhub.dateTime.DateTimeService;

import java.time.LocalDateTime;

public class DateTimeConsole {

    ScannerHelper scannerHelper = new ScannerHelper();
    DateTimeService dateService = new DateTimeService();

    public LocalDateTime addLocalDateTime() {
        System.out.println("Enter date in format: '" + dateService.getDateFormat() + "'");
        String strDate = scannerHelper.getString();
        return dateService.strToLDT(strDate);
    }

}
