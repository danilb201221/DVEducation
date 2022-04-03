package com.geekhub.person;

import com.geekhub.course.CourseImpl;

import java.util.HashMap;
import java.util.Map;

public class LecturersRepository {

    private Map<Integer, PersonImpl> lecturers = new HashMap<>();

    public String toString(Integer hash) {
        return lecturers.get(hash).toString();
    }

    public void addLecturer(CourseImpl courseImpl, PersonImpl lecturer) {
        lecturers.put(lecturer.hashCode(), lecturer);
        courseImpl.getIdStudents().add(lecturer.hashCode());
    }

    public Map<Integer, PersonImpl> getLecturers() {
        return lecturers;
    }
}
