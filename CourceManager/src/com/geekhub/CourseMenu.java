package com.geekhub;

import com.geekhub.course.Course;

public class CourseMenu {

    MainConsole mainConsole = new MainConsole();
    LessonConsole lessonConsole = new LessonConsole();
    PersonConsole personConsole = new PersonConsole();
    LessonMenu lessonMenu = new LessonMenu();

    private void printMenuCourse() {
        System.out.println("\nWhat would you like to do? Choose the option you want\n"
            + "1. Show all lectures (number and name)\n"
            + "2. Add new com.geekhub.lesson\n"
            + "3. Delete com.geekhub.lesson by number\n"
            + "4. Get com.geekhub.lesson\n"
            + "5. Get lecture by number\n"
            + "6. Show all student in this com.geekhub.course\n"
            + "7. Add new student in this com.geekhub.course\n"
            + "8. Add many new student in this com.geekhub.course\n"
            + "9. Show all lecturers in this com.geekhub.course\n"
            + "10. Add lecturer from the list\n"
            + "11. Back");
    }


    public void menuCourse(Course course) {
        String countMenu;
        do {
            printMenuCourse();
            countMenu = mainConsole.getString();
            switch (countMenu) {
                case "1" -> lessonConsole.displayLessonsList(course);
                case "2" -> lessonConsole.addNewLesson(course);
                case "3" -> lessonConsole.delLesson(course);
                case "4" -> lessonMenu.menuLesson(lessonConsole.getLesson(course));
                case "5" -> personConsole.displayStudentsList(course);
                case "6" -> personConsole.addNewStudent(course);
                case "7" -> personConsole.delStudent(course);
                case "8" -> personConsole.displayLecturersList(course);
                case "9" -> personConsole.addNewLecturer(course);
                case "10" -> personConsole.delLecturer(course);
                case "11" -> {
                    break;
                }
                default -> mainConsole.notAvailable();
            }
        } while (countMenu == "12");
    }
}
