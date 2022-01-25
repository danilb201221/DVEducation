package com.geekhub;

import com.geekhub.homework.HomeWorkService;
import com.geekhub.lesson.Lesson;

import java.time.LocalDateTime;

public class HomeWorkConsole {

    private final ScannerHelper scannerHelper;
    private final HomeWorkService homeWorkService;
    private final DateTimeConsole dateTimeConsole;

    public HomeWorkConsole(ScannerHelper scannerHelper, HomeWorkService homeWorkService, DateTimeConsole dateTimeConsole) {
        this.scannerHelper = scannerHelper;
        this.homeWorkService = homeWorkService;
        this.dateTimeConsole = dateTimeConsole;
    }

    public void addHomeWork(Lesson lesson) {
        System.out.println("Add name");
        String name = scannerHelper.getString();
        System.out.println("Add task");
        String task = scannerHelper.getString();
        LocalDateTime ldt = dateTimeConsole.addLocalDateTime();

        homeWorkService.addHomeWork(lesson, name, task, ldt);
    }

    public void displayHomeWorkList(Lesson lesson) {
        System.out.println(homeWorkService.getHomeWorkList(lesson));
    }

    public void deleteHomeWork(Lesson lesson) {
        System.out.println("Get name homework");
        String name = scannerHelper.getString();
        homeWorkService.deleteHomeWork(lesson, name);
    }
}
