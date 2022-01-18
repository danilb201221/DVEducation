package com.geekhub;

import com.geekhub.course.Course;
import com.geekhub.exeptions.LessonNotFoundException;
import com.geekhub.lesson.Lesson;
import com.geekhub.lesson.LessonService;
import com.geekhub.person.Person;

import java.time.LocalDateTime;

public class LessonConsole {

    MainConsole mainConsole = new MainConsole();
    LessonService lessonService = new LessonService();
    PersonConsole personConsole = new PersonConsole();
    DateTimeConsole dateConsole = new DateTimeConsole();

    public void displayLessonsList(Course course) {
        System.out.println(lessonService.displayLessonsList(course));
    }

    public void addNewLesson(Course course) {
        System.out.println("Add number");
        int num = mainConsole.getInt();
        System.out.println("Add name");
        String name = mainConsole.getString();
        System.out.println("Add description");
        String description = mainConsole.getString();
        LocalDateTime date = dateConsole.addLocalDateTime();
        System.out.println("Add lecturer\n" +
            personConsole.getLecturersList(course));
        int numLecturer = mainConsole.getInt();
        Person lecturer = personConsole.getLecturer(course, numLecturer);

        lessonService.addNewLesson(course, num, name, description, date, lecturer);
    }


    public void delLesson(Course course) {
        lessonService.delLesson(course);
    }

    public Lesson getLesson(Course course) {
        System.out.println("Enter the number of the lesson you want to get");
        displayLessonsList(course);
        int num = mainConsole.getInt();
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
