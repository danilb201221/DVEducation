package com.geekhub;

import com.geekhub.exeptions.CourseNotFoundException;

public class MainMenu {

    ScannerHelper scannerHelper = new ScannerHelper();
    CourseConsole courseConsole = new CourseConsole();
    CourseMenu courseMenu = new CourseMenu();

    private static void printMainMenuList() {
        System.out.println("""

            What would you like to do? Choose the option you want
            1. Show all courses (number and name)
            2. Add new courseImpl
            3. Delete courseImpl by number
            4. Get courseImpl by number
            5. Exit""");
    }

    public void printMainMenu() {
        String countMenu;
        do {
            printMainMenuList();
            countMenu = scannerHelper.getString();

            switch (countMenu) {
                case "1" -> courseConsole.displayCoursesList();
                case "2" -> courseConsole.addNewCourse();
                case "3" -> courseConsole.deleteCourse();
                case "4" -> {
                    try {
                        courseMenu.menuCourse(courseConsole.getCourse());
                    } catch (NullPointerException | IndexOutOfBoundsException | CourseNotFoundException e) {
                        System.err.println("Course not found");
                    }
                }
                case "5" -> {
                    scannerHelper.scannerClose();
                    System.exit(0);
                }
                default -> scannerHelper.notAvailable();
            }

        } while (true);
    }

}
