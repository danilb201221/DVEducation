package com.geekhub.course;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private List<Integer> idLessons;
    private List<Integer> idStudents;
    private List<Integer> idLecturers;

    public Course(String name) {
        this.name = name;
        this.idLessons = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getIdLessons() {
        return idLessons;
    }

    public void setIdLesson(Integer idLesson) {
        this.idLessons.add(idLesson);
    }

    public List<Integer> getIdStudents() {
        return idStudents;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudents.add(idStudent);
    }

    public List<Integer> getIdLecturers() {
        return idLecturers;
    }
}