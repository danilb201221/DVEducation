package course;

import lesson.LessonsRepository;
import lesson.LessonsRepositoryImpl;
import person.LecturersRepository;
import person.LecturersRepositoryImpl;
import person.StudentsRepository;
import person.StudentsRepositoryImpl;

public class CourseServiceImpl implements CourseService {

    private Course course;



    CourseSource courseSource = new CourseSource();
    LessonsRepository lessonsRepository = new LessonsRepositoryImpl();
    StudentsRepository studentsRepository = new StudentsRepositoryImpl();
    LecturersRepository lecturersRepository = new LecturersRepositoryImpl();

    public CourseServiceImpl() {
        this.course = new Course();
    }

    @Override
    public void displayCoursesList() {
        courseSource.displayCoursesList();
    }

    @Override
    public void addNewCourse(String name) {
        courseSource.addNewCourse(name);
    }

    @Override
    public void delCourse(int id) {
        courseSource.delCourse(id);
    }


    @Override
    public String toString() {
        String toString = String.format("Name: %s\n", course.getName());
        return toString;
    }

    @Override
    public void getCourseByNumber(int id) {
        menuCourse(courseSource.getCourseByNumber(id));
    }



    private void addManyStudents() {
        System.out.println("How many students you want to add?");
        int n = console.getInt();
        for (int i = 0; i < n; i++) {
            studentsRepository.addNewStudent();
        }
    }

//    public void getLessonByNumber() {
//        System.out.println("Enter the number of the lesson you want to get");
//        int num = console.getInt();
//        lessonsRepository.getLessonByNumber(num-1);
//    }

}
