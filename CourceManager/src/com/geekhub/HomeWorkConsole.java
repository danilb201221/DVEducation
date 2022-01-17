package com.geekhub;

import com.geekhub.homework.HomeWorkService;
import com.geekhub.lesson.Lesson;

import java.time.LocalDateTime;

public class HomeWorkConsole {

    MainConsole mainConsole = new MainConsole();
    HomeWorkService homeWorkService = new HomeWorkService();
    DateTimeConsole dateTimeConsole = new DateTimeConsole();

    public void addHomeWork(Lesson lesson) {
        System.out.println("Add name");
        String name = mainConsole.getString();
        System.out.println("Add task");
        String task = mainConsole.getString();
        LocalDateTime ldt = dateTimeConsole.addLocalDateTime();

        homeWorkService.addHomeWork(lesson, name, task, ldt);
    }

    public void displayHomeWorkList(Lesson lesson) {
        System.out.println(homeWorkService.getHomeWorkList(lesson));
    }

    public void delHomeWork(Lesson lesson) {
        System.out.println("Get name com.geekhub.homework");
        String name = mainConsole.getString();
        homeWorkService.delHomeWork(lesson, name);
    }
}
