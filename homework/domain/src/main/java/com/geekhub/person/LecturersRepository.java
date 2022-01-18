package com.geekhub.person;

import com.geekhub.course.Course;

import java.util.HashMap;
import java.util.Map;

public class LecturersRepository {

    private Map<Integer, Person> lecturers = new HashMap<>();

    public String toString(Integer hash) {
        String result = lecturers.get(hash).toString();
        return result;
    }

    public void addLecturer(Course course, Person lecturer) {
        lecturers.put(lecturer.hashCode(), lecturer);
        course.setIdStudent(lecturer.hashCode());
    }

    public Map<Integer, Person> getLecturers() {
        return lecturers;
    }
}
