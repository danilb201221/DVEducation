package course;

public class CourseSource {

    private Course[] courses;
    private Course course;

    public CourseSource() {
        this.courses = new Course[20];
    }

    public void displayCoursesList() {
        for (int i = 0; i < courses.length; i++) {
            if ((courses[i] != null)) {
                System.out.println(courses[i].getName());
            } else {
                continue;
            }
        }
    }

    public void addNewCourse(String name) {
        for (int i = 0; i < courses.length; i++) {
            if ((courses[i] == null)) {
                courses[i] = new Course(name);
                break;
            }
        }
    }

    public void delCourse(int id) {
        courses[id] = null;
        System.out.println("Course №" + (id+1) + " deleted");
    }


    public Course getCourseByNumber(int id) {
        System.out.println("You chose " + courses[id].getName());
        return courses[id];
    }

    public Course[] getCourses() {
        return courses;
    }
}
