package com.geekhub;

public class MainMenu {

    MainConsole mainConsole = new MainConsole();
    CourseConsole courseConsole = new CourseConsole();
    CourseMenu courseMenu = new CourseMenu();

    private static void printMenuCourses() {
        System.out.println("\nWhat would you like to do? Choose the option you want\n"
            + "1. Show all courses (number and name)\n"
            + "2. Add new com.geekhub.course\n"
            + "3. Delete com.geekhub.course by number\n"
            + "4. Get com.geekhub.course by number\n"
            + "5. Exit");
    }

    public void printMenuCourse() {
        String countMenu;
        do {
            printMenuCourses();
            countMenu = mainConsole.getString();
            switch (countMenu) {
                case "1" -> courseConsole.displayCoursesList();
                case "2" -> courseConsole.addNewCourse();
                case "3" -> courseConsole.delCourse();
                case "4" -> courseMenu.menuCourse(courseConsole.getCourse());
                case "5" -> System.exit(0);
                default -> mainConsole.notAvailable();
            }
        } while (true);
    }

}
