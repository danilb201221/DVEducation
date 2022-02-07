package com.geekhub.course;

public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    public StringBuilder getCoursesList() {
        StringBuilder result = new StringBuilder();
        int num = 1;
        for (int i = 0; i < courseRepository.getCourses().size(); i++) {
            result.append(num + ". " + courseRepository.getCourses().get(i).toString());
            num++;
        }
        return result;
    }

    public void addNewCourse(String name) {
        courseRepository.getCourses().add(courseRepository.getCourses().size(), new Course(name));
    }

    public void deleteCourse(int index) {
        courseRepository.getCourses().remove(index);
    }

    public Course getCourseByNumber(int index) {
        return courseRepository.getCourse(index);
    }
}
