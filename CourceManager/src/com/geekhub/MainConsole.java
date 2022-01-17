package com.geekhub;

import java.util.Scanner;

public class MainConsole {

    private Scanner sc;

    public void notAvailable() {
        System.out.println("This command is not available");
    }

    public Scanner getScanner() {
        if (sc == null) {
            sc = new Scanner(System.in);
        }
        return sc;
    }

    public String getString() {
        return getScanner().next();
    }

    public int getInt() {
        return sc.nextInt();
    }

    public void scannerClose() {
        sc.close();
    }

}
