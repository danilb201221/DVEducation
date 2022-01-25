package com.geekhub.course;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository {

    private List<Course> courses = new ArrayList<>();

    public Course getCourse(int index) {
        return courses.get(index);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
