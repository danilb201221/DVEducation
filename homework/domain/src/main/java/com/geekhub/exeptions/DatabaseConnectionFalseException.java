package com.geekhub.exeptions;

public class DatabaseConnectionFalseException extends Exception {
    public DatabaseConnectionFalseException() {
    }

    public DatabaseConnectionFalseException(String message) {
        super(message);
    }

    public DatabaseConnectionFalseException(String message, Throwable cause) {
        super(message, cause);
    }

    public DatabaseConnectionFalseException(Throwable cause) {
        super(cause);
    }

    public DatabaseConnectionFalseException(String message, Throwable cause, boolean enableSuppression,
                                            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String toString() {
        return "Database connection error";
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
