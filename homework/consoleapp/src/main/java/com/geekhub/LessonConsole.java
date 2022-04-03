package com.geekhub;

import com.geekhub.course.CourseImpl;
import com.geekhub.exeptions.LessonNotFoundException;
import com.geekhub.lesson.LessonImpl;
import com.geekhub.lesson.LessonService;
import com.geekhub.person.PersonImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.NoSuchElementException;

public class LessonConsole {

    ScannerHelper scannerHelper = new ScannerHelper();
    LessonService lessonService = new LessonService();
    PersonConsole personConsole = new PersonConsole();
    DateTimeConsole dateConsole = new DateTimeConsole();

    public void displayLessonsList(CourseImpl courseImpl) {
        for (int i = 0; i < lessonService.getLessonsList(courseImpl).size(); i++) {
            System.out.println(lessonService.getLessonsList(courseImpl).get(i));
        }
    }

    public void addNewLesson(CourseImpl courseImpl) {
        try {
            System.out.println("Add number");
            int number = scannerHelper.getInt();

            System.out.println("Add name");
            String name = scannerHelper.getString();

            System.out.println("Add description");
            String description = scannerHelper.getString();

            LocalDateTime date = dateConsole.addLocalDateTime();

            System.out.println("Add lecturer\n" +
                personConsole.getLecturersList(courseImpl));
            int numLecturer = scannerHelper.getInt();

            PersonImpl lecturer = personConsole.getLecturer(courseImpl, numLecturer);

            lessonService.addNewLesson(courseImpl, number, name, description, date, lecturer);

        } catch (DateTimeParseException e) {
            System.out.println("Incorrect date-time format");

        } catch (Exception e) {
            System.err.println("Unexpected error");
        }
    }


    public void deleteLesson(CourseImpl courseImpl) {
        System.out.println("Enter the number of the lesson you want to delete");
        int index = scannerHelper.getInt() - 1;
        try {
            lessonService.deleteLesson(courseImpl, index);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Lesson with this number does not exist");
        } catch (UnsupportedOperationException e) {
            System.err.println("Unexpected error");
        }
    }

    public LessonImpl getLesson(CourseImpl courseImpl) throws LessonNotFoundException, NoSuchElementException {
        System.out.println("Enter the number of the lesson you want to get");
        displayLessonsList(courseImpl);
        int number = scannerHelper.getInt();
        return lessonService.getLesson(courseImpl, number);
    }
}
