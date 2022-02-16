package com.geekhub;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerHelper {

    private Scanner sc;

    public void notAvailable() {
        System.out.println("This command is not available");
    }

    public ScannerHelper() {
        this.sc = new Scanner(System.in);
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
        int _int = 0;
        try {
            _int = getScanner().nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Invalid value, please enter a number");
            sc = null;
            _int = getInt();
        }
        return _int;
    }

    public void scannerClose() {
        getScanner().close();
    }

}
