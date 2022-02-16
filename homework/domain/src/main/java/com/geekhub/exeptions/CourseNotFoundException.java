package com.geekhub.exeptions;

public class CourseNotFoundException extends Exception{
    public CourseNotFoundException() {
    }

    public CourseNotFoundException(String message) {
        super(message);
    }

    public CourseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CourseNotFoundException(Throwable cause) {
        super(cause);
    }

    public CourseNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String toString() {
        return "Course not found";
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
