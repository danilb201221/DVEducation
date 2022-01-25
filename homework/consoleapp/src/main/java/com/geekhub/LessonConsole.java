package com.geekhub;

import com.geekhub.course.Course;
import com.geekhub.exeptions.LessonNotFoundException;
import com.geekhub.lesson.Lesson;
import com.geekhub.lesson.LessonService;
import com.geekhub.person.Person;

import java.time.LocalDateTime;

public class LessonConsole {

    private final ScannerHelper scannerHelper;
    private final LessonService lessonService;
    private final PersonConsole personConsole;
    private final DateTimeConsole dateTimeConsole;

    public LessonConsole(ScannerHelper scannerHelper, LessonService lessonService, PersonConsole personConsole, DateTimeConsole dateTimeConsole) {
        this.scannerHelper = scannerHelper;
        this.lessonService = lessonService;
        this.personConsole = personConsole;
        this.dateTimeConsole = dateTimeConsole;
    }

    public void displayLessonsList(Course course) {
        System.out.println(lessonService.displayLessonsList(course));
    }

    public void addNewLesson(Course course) {
        System.out.println("Add number");
        int num = scannerHelper.getInt();
        System.out.println("Add name");
        String name = scannerHelper.getString();
        System.out.println("Add description");
        String description = scannerHelper.getString();
        LocalDateTime date = dateTimeConsole.addLocalDateTime();
        System.out.println("Add lecturer\n" +
            personConsole.getLecturersList(course));
        int numLecturer = scannerHelper.getInt();
        Person lecturer = personConsole.getLecturer(course, numLecturer);

        lessonService.addNewLesson(course, num, name, description, date, lecturer);
    }


    public void deleteLesson(Course course) {
        lessonService.delLesson(course);
    }

    public Lesson getLesson(ScannerHelper scannerHelper, Course course) {
        System.out.println("Enter the number of the lesson you want to get");
        displayLessonsList(course);
        int num = this.scannerHelper.getInt();
        Lesson lesson = null;
        try {
            lesson = lessonService.getLesson(course, num);
        } catch (LessonNotFoundException e) {
            System.err.println("Lesson not found");
            e.printStackTrace();
        }
        return lesson;
    }
}
