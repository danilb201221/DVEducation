package com.geekhub;

import com.geekhub.courseImpl.CourseImpl;
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
            2. Add new lessonImpl
            3. Delete lessonImpl by number
            4. Get lessonImpl
            5. Show all student in this courseImpl
            6. Add new student in this courseImpl
            7. Delete student in this courseImpl
            8. Add many new student in this courseImpl
            9. Add new lecturer in this courseImpl
            10. Delete lecturer in this courseImpl
            11. Back""");
    }


    public void menuCourse(CourseImpl courseImpl) {
        String countMenu;
        boolean exitMenu = false;
        do {
            printMenuCourse();
            countMenu = scannerHelper.getString();
            switch (countMenu) {
                case "1" -> lessonConsole.displayLessonsList(courseImpl);
                case "2" -> lessonConsole.addNewLesson(courseImpl);
                case "3" -> lessonConsole.deleteLesson(courseImpl);
                case "4" -> {
                    try {
                        lessonMenu.menuLesson(lessonConsole.getLesson(courseImpl));
                    } catch (LessonNotFoundException e) {
                        System.err.println(e);
                    }
                }
                case "5" -> personConsole.displayStudentsList(courseImpl);
                case "6" -> personConsole.addNewStudent(courseImpl);
                case "7" -> personConsole.deleteStudent(courseImpl);
                case "8" -> personConsole.displayLecturersList(courseImpl);
                case "9" -> personConsole.addNewLecturer(courseImpl);
                case "10" -> personConsole.deleteLecturer(courseImpl);
                case "11" -> exitMenu = true;
                default -> scannerHelper.notAvailable();
            }
        } while (!exitMenu);
    }
}
