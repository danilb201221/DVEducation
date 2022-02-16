package com.geekhub;

import com.geekhub.lesson.Lesson;

public class LessonMenu {

    ScannerHelper scannerHelper = new ScannerHelper();
    ResourceConsole resourceConsole = new ResourceConsole();
    HomeWorkConsole homeWorkConsole = new HomeWorkConsole();

    private void printMenuLesson() {
        System.out.println("""

            What would you like to do? Choose the option you want
            1. Add resource
            2. Add homework
            3. Delete resource
            4. Delete homework
            5. Show resources
            6. Show homework(-s)
            7. Back""");
    }

    public void menuLesson(Lesson lesson) {
        String countMenu;
        boolean exitMenu = false;
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
                case "7" -> exitMenu = true;
                default -> scannerHelper.notAvailable();
            }
        } while (!exitMenu);
    }
}
