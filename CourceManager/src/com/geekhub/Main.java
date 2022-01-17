package com.geekhub;

import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    private static void printGreetings() {
        System.out.print("Hello!\n"
            + "This program allows you to work with your courses");
    }

    public static void main(String[] args) {

        CourseConsole consoleCourse = new CourseConsole();
        MainMenu mainMenu = new MainMenu();

        printGreetings();

        mainMenu.printMenuCourse();

    }
}

