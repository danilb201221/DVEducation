package course;

public interface CourseService {

    void addNewCourse(String name);
    String toString();
    void menuCourse(Course course);

    void displayCoursesList();

    void delCourse(int id);

    void getCourseByNumber(int id);
}
