package com.geekhub;

import com.geekhub.course.Course;
import com.geekhub.exeptions.LessonNotFoundException;
import com.geekhub.lesson.Lesson;
import com.geekhub.lesson.LessonService;
import com.geekhub.person.Person;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.NoSuchElementException;
import java.util.Optional;

public class LessonConsole {

    ScannerHelper scannerHelper = new ScannerHelper();
    LessonService lessonService = new LessonService();
    PersonConsole personConsole = new PersonConsole();
    DateTimeConsole dateConsole = new DateTimeConsole();

    public void displayLessonsList(Course course) {
        for (int i = 0; i < lessonService.getLessonsList(course).size(); i++) {
            System.out.println(lessonService.getLessonsList(course).get(i));
        }
    }

    public void addNewLesson(Course course) {
        try {
            System.out.println("Add number");
            int number = scannerHelper.getInt();

            System.out.println("Add name");
            String name = scannerHelper.getString();

            System.out.println("Add description");
            String description = scannerHelper.getString();

            LocalDateTime date = dateConsole.addLocalDateTime();

            System.out.println("Add lecturer\n" +
                personConsole.getLecturersList(course));
            int numLecturer = scannerHelper.getInt();

            Person lecturer = personConsole.getLecturer(course, numLecturer);

            lessonService.addNewLesson(course, number, name, description, date, lecturer);

        } catch (DateTimeParseException e) {
            System.out.println("Incorrect date-time format");

        } catch (Exception e) {
            System.err.println("Unexpected error");
        }
    }


    public void deleteLesson(Course course) {
        System.out.println("Enter the number of the lesson you want to delete");
        int index = scannerHelper.getInt() - 1;
        try {
            lessonService.deleteLesson(course, index);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Lesson with this number does not exist");
        } catch (UnsupportedOperationException e) {
            System.err.println("Unexpected error");
        }
    }

    public Lesson getLesson(Course course) throws LessonNotFoundException, NoSuchElementException {
        System.out.println("Enter the number of the lesson you want to get");
        displayLessonsList(course);
        int number = scannerHelper.getInt();
        return lessonService.getLesson(course, number);
    }
}
