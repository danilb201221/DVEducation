package com.geekhub;

import com.geekhub.lesson.Lesson;

public class LessonMenu {

    private final ScannerHelper scannerHelper;
    private final ResourceConsole resourceConsole;
    private final HomeWorkConsole homeWorkConsole;

    public LessonMenu(ScannerHelper scannerHelper, ResourceConsole resourceConsole, HomeWorkConsole homeWorkConsole) {
        this.scannerHelper = scannerHelper;
        this.resourceConsole = resourceConsole;
        this.homeWorkConsole = homeWorkConsole;
    }

    private void printMenuLesson() {
        System.out.println("\nWhat would you like to do? Choose the option you want\n"
            + "1. Add resource\n"
            + "2. Add homework\n"
            + "3. Delete resource\n"
            + "4. Delete homework\n"
            + "5. Show resources\n"
            + "6. Show homework(-s)\n"
            + "7. Back");
    }

    public void menuLesson(Lesson lesson) {
        String countMenu;
        do {
            printMenuLesson();
            countMenu = scannerHelper.getString();
            switch (countMenu) {
                case "1" -> resourceConsole.addResource(lesson);
                case "2" -> homeWorkConsole.addHomeWork(lesson);
                case "3" -> resourceConsole.deleteResource(lesson);
                case "4" -> homeWorkConsole.deleteHomeWork(lesson);
                case "5" -> resourceConsole.displayResourcesList(lesson);
                case "6" -> homeWorkConsole.displayHomeWorkList(lesson);
                case "7" -> {
                    break;
                }
                default -> scannerHelper.notAvailable();
            }
        } while (countMenu == "7");
    }
}
