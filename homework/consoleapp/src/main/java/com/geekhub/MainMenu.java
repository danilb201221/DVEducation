package com.geekhub;

public class MainMenu {

    private final ScannerHelper scannerHelper;
    private final CourseConsole courseConsole;
    private final CourseMenu courseMenu;

    public MainMenu(ScannerHelper scannerHelper, CourseConsole courseConsole, CourseMenu courseMenu) {
        this.scannerHelper = scannerHelper;
        this.courseConsole = courseConsole;
        this.courseMenu = courseMenu;
    }

    private static void printMenuCourses() {
        System.out.println("\nWhat would you like to do? Choose the option you want\n"
            + "1. Show all courses (number and name)\n"
            + "2. Add new course\n"
            + "3. Delete course by number\n"
            + "4. Get course by number\n"
            + "5. Exit");
    }

    public void printMenuCourse(ScannerHelper scannerHelper) {
        String countMenu;
        do {
            printMenuCourses();
            countMenu = this.scannerHelper.getString();
            switch (countMenu) {
                case "1" -> courseConsole.displayCoursesList();
                case "2" -> courseConsole.addNewCourse();
                case "3" -> courseConsole.deleteCourse();
                case "4" -> courseMenu.menuCourse(this.scannerHelper, courseConsole.getCourse());
                case "5" -> {
                    this.scannerHelper.scannerClose();
                    System.exit(0);
                }
                default -> this.scannerHelper.notAvailable();
            }
        } while (true);
    }

}
