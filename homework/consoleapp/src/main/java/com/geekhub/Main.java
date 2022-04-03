package com.geekhub;

import com.geekhub.database.DatabaseConfig;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    private static void printGreetings() {
        System.out.print("""
            Hello!
            This program allows you to work with your courses""");
    }

    public static void main(String[] args) {
        SpringApplication.run();

        DatabaseConfig databaseConfig = new DatabaseConfig();
        databaseConfig.createTablesDB();

        MainMenu mainMenu = new MainMenu();

        printGreetings();

        try {
            mainMenu.printMainMenu();
        } catch (Exception e) {
            System.err.println("Unexpected error");
        }

    }
}

