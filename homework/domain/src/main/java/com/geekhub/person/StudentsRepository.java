package com.geekhub.person;

import com.geekhub.course.Course;

import java.util.HashMap;
import java.util.Map;

public class StudentsRepository {

    private Map<Integer, Person> students = new HashMap<>();

    public String toString(Integer hash) {
        return students.get(hash).toString();
    }

    public void addStudent(Course course, Person student) {
        students.put(student.hashCode(), student);
        course.getIdStudents().add(student.hashCode());
    }

    public Map<Integer, Person> getStudents() {
        return students;
    }
}
