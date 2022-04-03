package com.geekhub.exeptions;

public class PropertiesFileNotFoundException extends Exception {
    public PropertiesFileNotFoundException() {
    }

    public PropertiesFileNotFoundException(String message) {
        super(message);
    }

    public PropertiesFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PropertiesFileNotFoundException(Throwable cause) {
        super(cause);
    }

    public PropertiesFileNotFoundException(String message, Throwable cause, boolean enableSuppression,
                                           boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String toString() {
        return "Properties file not found";
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
