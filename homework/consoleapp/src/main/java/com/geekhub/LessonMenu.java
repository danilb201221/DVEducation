package com.geekhub;

import com.geekhub.lesson.LessonImpl;

public class LessonMenu {

    ScannerHelper scannerHelper = new ScannerHelper();
    ResourceConsole resourceConsole = new ResourceConsole();
    HomeWorkConsole homeWorkConsole = new HomeWorkConsole();

    private void printMenuLesson() {
        System.out.println("""

            What would you like to do? Choose the option you want
            1. Add resourceImpl
            2. Add homework
            3. Delete resourceImpl
            4. Delete homework
            5. Show resources
            6. Show homework(-s)
            7. Back""");
    }

    public void menuLesson(LessonImpl lessonImpl) {
        String countMenu;
        boolean exitMenu = false;
        do {
            printMenuLesson();
            countMenu = scannerHelper.getString();
            switch (countMenu) {
                case "1" -> resourceConsole.addResource(lessonImpl);
                case "2" -> homeWorkConsole.addHomeWork(lessonImpl);
                case "3" -> resourceConsole.deleteResource(lessonImpl);
                case "4" -> homeWorkConsole.deleteHomeWork(lessonImpl);
                case "5" -> resourceConsole.displayResourcesList(lessonImpl);
                case "6" -> homeWorkConsole.displayHomeWorkList(lessonImpl);
                case "7" -> exitMenu = true;
                default -> scannerHelper.notAvailable();
            }
        } while (!exitMenu);
    }
}
