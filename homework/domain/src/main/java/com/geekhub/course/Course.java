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
        this.idStudents = new ArrayList<>();
        this.idLecturers = new ArrayList<>();
    }

    @Override
    public String toString() {
        return name;
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

    public void setIdLessons(List<Integer> idLessons) {
        this.idLessons = idLessons;
    }

    public List<Integer> getIdStudents() {
        return idStudents;
    }

    public void setIdStudents(List<Integer> idStudents) {
        this.idStudents = idStudents;
    }

    public List<Integer> getIdLecturers() {
        return idLecturers;
    }

    public void setIdLecturers(List<Integer> idLecturers) {
        this.idLecturers = idLecturers;
    }
}