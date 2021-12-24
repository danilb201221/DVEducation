import course.Course;
import course.CourseService;

public class CourseMenu {

    private Course course;

    MainConsole mainConsole = new MainConsole();
    LessonConsole lessonConsole = new LessonConsole();

    private void printMenuCourse() {
        System.out.println("\nWhat would you like to do? Choose the option you want\n"
            + "1. Show all lectures (number and name)\n"
            + "2. Add new lecture\n"
            + "3. Delete lecture by number\n"
            + "4. Get full information of lecture by number\n"
            + "5. Get lecture by number\n"
            + "6. Show all student in this course\n"
            + "7. Add new student in this course\n"
            + "8. Add many new student in this course\n"
            + "9. Show all lecturers in this course\n"
            + "10. Add lecturer from the list\n"
            + "11. Back");
    }


    public void menuCourse(Course course) {
        String countMenu;
        do {
            printMenuCourse();
            countMenu = mainConsole.getString();
            switch (countMenu) {
                case "1" -> lessonConsole.displayLessonsList();
                case "2" -> lessonConsole.addNewLesson();
                case "3" -> lessonConsole.delLesson();
                case "4" -> lessonConsole.getLesson();
                case 6:
                    System.out.println("You chose show all student in this course");
                    studentsRepository.getAllStudents();
                    break;
                case 7:
                    System.out.println("You chose add new student in this course");
                    studentsRepository.addNewStudent();
                    break;
                case 8:
                    System.out.println("You chose add many new students in this course");
                    addManyStudents();
                    break;
                case 9:
                    System.out.println("You chose show all lecturers in this course");
                    lecturersRepository.printAllLecturers();
                    break;
                case 10:
                    System.out.println("You chose add lecturer in course from the list");
                    lecturersRepository.addLecturerFromList();
                    break;
                case 11:
                    break;
                default:
                    System.out.println("This command is not available, select from the list provided");
                    break;
            }
        } while (countMenu == 11);
    }
}
