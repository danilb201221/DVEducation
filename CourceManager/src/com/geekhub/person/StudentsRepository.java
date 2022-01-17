package com.geekhub.person;

import com.geekhub.course.Course;

import java.util.HashMap;
import java.util.Map;

public class StudentsRepository {

    private Map<Integer, Person> students = new HashMap<>();

    public String toString(Integer hash) {
        String result = students.get(hash).toString();
        return result;
    }

    public void addStudent(Course course, Person student) {
        students.put(student.hashCode(), student);
        course.setIdStudent(student.hashCode());
    }

    public Map<Integer, Person> getStudents() {
        return students;
    }
}
