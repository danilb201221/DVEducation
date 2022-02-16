package com.geekhub.course;

import com.geekhub.exeptions.CourseNotFoundException;
import java.util.ArrayList;
import java.util.Optional;

public class CourseService {

    CourseRepository courseRepository = new CourseRepository();


    public ArrayList<String> getCoursesList() {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < courseRepository.getCourses().size(); i++) {
            String course = (i+1) + ". " + courseRepository.getCourses().get(i).getName();
            result.add(course);
        }
        return result;
    }

    public void addNewCourse(String name) {
        courseRepository.getCourses().add(new Course(name));
    }

    public void deleteCourse(int index) throws IndexOutOfBoundsException, UnsupportedOperationException {
        courseRepository.getCourses().remove(index);
    }

    public Course getCourse(int index) throws CourseNotFoundException {
        Course course;
        if ((courseRepository.getCourses().get(index) != null) && (courseRepository.getCourses().size() > index)) {
            course = courseRepository.getCourses().get(index);
            return course;
        } else {
            throw new CourseNotFoundException();
        }
    }
}
