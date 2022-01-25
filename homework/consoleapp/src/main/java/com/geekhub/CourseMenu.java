package com.geekhub;

import com.geekhub.course.Course;

public class CourseMenu {

    private final ScannerHelper scannerHelper;
    private final LessonConsole lessonConsole;
    private final PersonConsole personConsole;
    private final LessonMenu lessonMenu;

    public CourseMenu(ScannerHelper scannerHelper, LessonConsole lessonConsole, PersonConsole personConsole, LessonMenu lessonMenu) {
        this.scannerHelper = scannerHelper;
        this.lessonConsole = lessonConsole;
        this.personConsole = personConsole;
        this.lessonMenu = lessonMenu;
    }

    private void printMenuCourse() {
        System.out.println("\nWhat would you like to do? Choose the option you want\n"
            + "1. Show all lectures (number and name)\n"
            + "2. Add new lesson\n"
            + "3. Delete lesson by number\n"
            + "4. Get lesson\n"
            + "5. Get lecture by number\n"
            + "6. Show all student in this course\n"
            + "7. Add new student in this course\n"
            + "8. Add many new student in this course\n"
            + "9. Show all lecturers in this course\n"
            + "10. Add lecturer from the list\n"
            + "11. Back");
    }


    public void menuCourse(ScannerHelper scannerHelper, Course course) {
        String countMenu;
        do {
            printMenuCourse();
            countMenu = scannerHelper.getString();
            switch (countMenu) {
                case "1" -> lessonConsole.displayLessonsList(course);
                case "2" -> lessonConsole.addNewLesson(course);
                case "3" -> lessonConsole.deleteLesson(course);
                case "4" -> lessonMenu.menuLesson(lessonConsole.getLesson(scannerHelper, course));
                case "5" -> personConsole.displayStudentsList(course);
                case "6" -> personConsole.addNewStudent(course);
                case "7" -> personConsole.deleteStudent(course);
                case "8" -> personConsole.displayLecturersList(course);
                case "9" -> personConsole.addNewLecturer(course);
                case "10" -> personConsole.deleteLecturer(course);
                case "11" -> {
                    break;
                }
                default -> scannerHelper.notAvailable();
            }
        } while (countMenu == "12");
    }
}
