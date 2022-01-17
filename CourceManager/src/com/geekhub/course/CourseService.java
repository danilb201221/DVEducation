package com.geekhub.course;

public class CourseService {

    CourseRepository courseRepository = new CourseRepository();


    public StringBuilder displayCoursesList() {
        StringBuilder result = new StringBuilder();
        int num = 1;
        for (int i = 0; i < courseRepository.getLastIndex(); i++) {
            if (courseRepository.notNullID(i)) {
                result.append(num + ". " + courseRepository.toString(i));
                num++;
            } else {
                continue;
            }
        }
        return result;
    }

    public void addNewCourse(String name) {
        courseRepository.addNewCourse(name);
    }

    public void delCourse(int id) {
        courseRepository.delCourse(id);
    }

    public Course getCourseByNumber(int id) {
        return courseRepository.getCourse(id);
    }
}
