package com.geekhub;

import com.geekhub.course.Course;
import com.geekhub.exeptions.LessonNotFoundException;

public class CourseMenu {

    ScannerHelper scannerHelper = new ScannerHelper();
    LessonConsole lessonConsole = new LessonConsole();
    PersonConsole personConsole = new PersonConsole();
    LessonMenu lessonMenu = new LessonMenu();

    private void printMenuCourse() {
        System.out.println("""

            What would you like to do? Choose the option you want
            1. Show all lectures (number and name)
            2. Add new lesson
            3. Delete lesson by number
            4. Get lesson
            5. Show all student in this course
            6. Add new student in this course
            7. Delete student in this course
            8. Add many new student in this course
            9. Add new lecturer in this course
            10. Delete lecturer in this course
            11. Back""");
    }


    public void menuCourse(Course course) {
        String countMenu;
        boolean exitMenu = false;
        do {
            printMenuCourse();
            countMenu = scannerHelper.getString();
            switch (countMenu) {
                case "1" -> lessonConsole.displayLessonsList(course);
                case "2" -> lessonConsole.addNewLesson(course);
                case "3" -> lessonConsole.deleteLesson(course);
                case "4" -> {
                    try {
                        lessonMenu.menuLesson(lessonConsole.getLesson(course));
                    } catch (LessonNotFoundException e) {
                        System.err.println(e);
                    }
                }
                case "5" -> personConsole.displayStudentsList(course);
                case "6" -> personConsole.addNewStudent(course);
                case "7" -> personConsole.deleteStudent(course);
                case "8" -> personConsole.displayLecturersList(course);
                case "9" -> personConsole.addNewLecturer(course);
                case "10" -> personConsole.deleteLecturer(course);
                case "11" -> exitMenu = true;
                default -> scannerHelper.notAvailable();
            }
        } while (!exitMenu);
    }
}
