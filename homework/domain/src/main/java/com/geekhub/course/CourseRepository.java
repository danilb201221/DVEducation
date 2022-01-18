package com.geekhub.course;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository {

    private List<Course> courses = new ArrayList<>();

    public int getLastIndex() {
        return courses.size()-1;
    }

    public boolean notNullID(int id) {
        if (courses.get(id) != null) {
            return true;
        } else {
            return false;
        }
    }

    public String toString(int i) {
        String toString = String.format("%s\n", courses.get(i).getName());
        return toString;
    }

    public void addNewCourse(String name) {
        courses.add(getLastIndex()+1, new Course(name));
    }

    public void delCourse(int id) {
        courses.remove(id);
    }

    public Course getCourse(int id) {
        return courses.get(id);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
