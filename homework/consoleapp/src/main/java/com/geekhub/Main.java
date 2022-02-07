package com.geekhub;

import com.geekhub.course.CourseRepository;
import com.geekhub.course.CourseService;
import com.geekhub.dateTime.DateTimeService;
import com.geekhub.homework.HomeWorkRepository;
import com.geekhub.homework.HomeWorkService;
import com.geekhub.lesson.LessonService;
import com.geekhub.lesson.LessonsRepository;
import com.geekhub.logger.CustomLogger;
import com.geekhub.person.LecturersRepository;
import com.geekhub.person.PersonService;
import com.geekhub.person.StudentsRepository;
import com.geekhub.resource.ResourceRepository;
import com.geekhub.resource.ResourceService;

public class Main {

    private static void printGreetings() {
        System.out.print("Hello!\n"
            + "This program allows you to work with your courses");
    }

    public static void main(String[] args) {

        ScannerHelper scannerHelper = new ScannerHelper();
        CustomLogger customLogger = new CustomLogger();

        CourseRepository courseRepository = new CourseRepository();
        HomeWorkRepository homeWorkRepository = new HomeWorkRepository();
        LessonsRepository lessonsRepository = new LessonsRepository();
        StudentsRepository studentsRepository = new StudentsRepository();
        LecturersRepository lecturersRepository = new LecturersRepository();
        ResourceRepository resourceRepository = new ResourceRepository();

        CourseService courseService = new CourseService(courseRepository);
        DateTimeService dateTimeService = new DateTimeService();
        HomeWorkService homeWorkService = new HomeWorkService(homeWorkRepository);
        LessonService lessonService = new LessonService(lessonsRepository);
        PersonService personService = new PersonService(studentsRepository, lecturersRepository);
        ResourceService resourceService = new ResourceService(resourceRepository);

        CourseConsole courseConsole = new CourseConsole(scannerHelper, courseService);
        DateTimeConsole dateTimeConsole = new DateTimeConsole(scannerHelper, dateTimeService);
        HomeWorkConsole homeWorkConsole = new HomeWorkConsole(scannerHelper, homeWorkService, dateTimeConsole);
        PersonConsole personConsole = new PersonConsole(scannerHelper, personService);
        LessonConsole lessonConsole = new LessonConsole(scannerHelper, lessonService, personConsole, dateTimeConsole);
        ResourceConsole resourceConsole = new ResourceConsole(scannerHelper, resourceService);

        LessonMenu lessonMenu = new LessonMenu(scannerHelper, resourceConsole, homeWorkConsole);
        CourseMenu courseMenu = new CourseMenu(scannerHelper, lessonConsole, personConsole, lessonMenu);
        MainMenu mainMenu = new MainMenu(scannerHelper, courseConsole, courseMenu);

        printGreetings();

        mainMenu.printMenuCourse(scannerHelper);

    }
}

