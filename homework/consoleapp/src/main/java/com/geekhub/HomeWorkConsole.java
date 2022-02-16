package com.geekhub;

import com.geekhub.homework.HomeWorkService;
import com.geekhub.lesson.Lesson;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class HomeWorkConsole {

    ScannerHelper scannerHelper = new ScannerHelper();
    HomeWorkService homeWorkService = new HomeWorkService();
    DateTimeConsole dateTimeConsole = new DateTimeConsole();

    public void addHomeWork(Lesson lesson) {
        System.out.println("Add name");
        String name = scannerHelper.getString();
        System.out.println("Add task");
        String task = scannerHelper.getString();
        try {
            LocalDateTime ldt = dateTimeConsole.addLocalDateTime();
            homeWorkService.addHomeWork(lesson, name, task, ldt);
        } catch (DateTimeParseException e) {
            System.out.println("Incorrect date-time format");
        }
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
