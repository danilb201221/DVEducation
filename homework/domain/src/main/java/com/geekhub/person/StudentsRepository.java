package com.geekhub.person;

import com.geekhub.course.CourseImpl;

import java.util.HashMap;
import java.util.Map;

public class StudentsRepository {

    private Map<Integer, PersonImpl> students = new HashMap<>();

    public String toString(Integer hash) {
        return students.get(hash).toString();
    }

    public void addStudent(CourseImpl courseImpl, PersonImpl student) {
        students.put(student.hashCode(), student);
        courseImpl.getIdStudents().add(student.hashCode());
    }

    public Map<Integer, PersonImpl> getStudents() {
        return students;
    }
}
