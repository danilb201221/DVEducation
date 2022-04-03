package com.geekhub.course;

import com.geekhub.exeptions.CourseNotFoundException;
import java.util.ArrayList;

public class CourseService {

    CourseRepository courseRepository = new CourseRepository();


    public ArrayList<String> getCoursesList() {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < courseRepository.getCoursesList().size(); i++) {
            String course = (i+1) + ". " + courseRepository.getCoursesList().get(i).getName();
            result.add(course);
        }
        return result;
    }

    public void addNewCourse(String name) {
        courseRepository.getCoursesList().add(new CourseImpl(name));
    }

    public void deleteCourse(int index) throws IndexOutOfBoundsException, UnsupportedOperationException {
        courseRepository.getCoursesList().remove(index);
    }

    public CourseImpl getCourse(int index) throws CourseNotFoundException {
        CourseImpl courseImpl;
        if ((courseRepository.getCoursesList().get(index) != null) && (courseRepository.getCoursesList().size() > index)) {
            courseImpl = courseRepository.getCoursesList().get(index);
            return courseImpl;
        } else {
            throw new CourseNotFoundException();
        }
    }
}
