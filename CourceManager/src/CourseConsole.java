import course.CourseService;
import course.CourseServiceImpl;

public class CourseConsole {

    MainConsole mainConsole = new MainConsole();
    CourseService courseService = new CourseServiceImpl();
    CourseMenu courseMenu = new CourseMenu();


    public void displayCoursesList() {
        courseService.displayCoursesList();
    }

    public void addNewCourse() {
        System.out.println("Add name course");
        String name = mainConsole.getString();
        courseService.addNewCourse(name);
    }

    public void delCourse() {
        System.out.println("Enter the number of the course you want to delete");
        int id = mainConsole.getInt()-1;
        courseService.delCourse(id);
    }

    public void getCourse() {
        System.out.println("Enter the number of the course you want to get");
        int id = mainConsole.getInt()-1;
        courseService.getCourseByNumber(id);
    }

    public void addNewLecturer() {

    }

    public void displayTeacherList() {

    }

}
