public class MainMenu {

    MainConsole mainConsole = new MainConsole();
    CourseConsole courseConsole = new CourseConsole();

    private static void printMenuCourses() {
        System.out.println("\nWhat would you like to do? Choose the option you want\n"
            + "1. Show all courses (number and name)\n"
            + "2. Add new course\n"
            + "3. Delete course by number\n"
            + "4. Get course by number\n"
            + "5. Add lecturer\n"
            + "6. Show all lecturers\n"
            + "7. Exit");
    }

    public void printMenuCourse() {
        String countMenu;
        do {
            printMenuCourses();
            countMenu = mainConsole.getString();
            switch (countMenu) {
                case "1" -> courseConsole.displayCoursesList();
                case "2" -> courseConsole.addNewCourse();
                case "3" -> courseConsole.delCourse();
                case "4" -> courseConsole.getCourse();
                case "5" -> courseConsole.addNewLecturer();
                case "6" -> courseConsole.displayTeacherList();
                case "7" -> System.exit(0);
                default -> System.out.println("This command is not available, select from the list provided");
            }
        } while (true);
    }

}
