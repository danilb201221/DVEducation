package com.geekhub;

import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    private static void printGreetings() {
        System.out.print("""
            Hello!
            This program allows you to work with your courses""");
    }

    public static void main(String[] args) {

        MainMenu mainMenu = new MainMenu();

        printGreetings();

        try {
            mainMenu.printMainMenu();
        } catch (Exception e) {
            System.err.println("Unexpected error");
        }

    }
}

