package com.geekhub;

import com.geekhub.dateTime.DateTimeService;

import java.time.LocalDateTime;

public class DateTimeConsole {

    private final ScannerHelper scannerHelper;
    private final DateTimeService dateTimeService;

    public DateTimeConsole(ScannerHelper scannerHelper, DateTimeService dateTimeService) {
        this.scannerHelper = scannerHelper;
        this.dateTimeService = dateTimeService;
    }

    public LocalDateTime addLocalDateTime() {
        System.out.println("Enter date in format: '" + dateTimeService.getDateFormat() + "'");
        String strDate = scannerHelper.getString();
        return dateTimeService.strToLDT(strDate);
    }

}
