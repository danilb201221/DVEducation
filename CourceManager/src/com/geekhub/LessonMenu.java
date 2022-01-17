package com.geekhub;

import com.geekhub.lesson.Lesson;

public class LessonMenu {

    MainConsole mainConsole = new MainConsole();
    ResourceConsole resourceConsole = new ResourceConsole();
    HomeWorkConsole homeWorkConsole = new HomeWorkConsole();

    private void printMenuLesson() {
        System.out.println("\nWhat would you like to do? Choose the option you want\n"
            + "1. Add com.geekhub.resource\n"
            + "2. Add com.geekhub.homework\n"
            + "3. Delete com.geekhub.resource\n"
            + "4. Delete com.geekhub.homework\n"
            + "5. Show resources\n"
            + "6. Show com.geekhub.homework(-s)\n"
            + "7. Back");
    }

    public void menuLesson(Lesson lesson) {
        String countMenu;
        do {
            printMenuLesson();
            countMenu = mainConsole.getString();
            switch (countMenu) {
                case "1" -> resourceConsole.addResource(lesson);
                case "2" -> homeWorkConsole.addHomeWork(lesson);
                case "3" -> resourceConsole.delResource(lesson);
                case "4" -> homeWorkConsole.delHomeWork(lesson);
                case "5" -> resourceConsole.displayResourcesList(lesson);
                case "6" -> homeWorkConsole.displayHomeWorkList(lesson);
                case "7" -> {
                    break;
                }
                default -> mainConsole.notAvailable();
            }
        } while (countMenu == "7");
    }
}
