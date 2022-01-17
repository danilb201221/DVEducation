package com.geekhub.lesson;

import com.geekhub.person.Person;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lesson {

    private int num;
    private String name;
    private String description;
    private LocalDateTime date;
    private List<Integer> resources;
    private Person lecturer;
    private List<Integer> homeWorks;

    @Override
    public String toString() {
        String toString = String.format ("Number: %d. Name: %s\n" +
                "Lecturer: %s\n" +
                "Date: %s\n" +
                "Description: %s\n" +
                "Homework: %s\n" +
                "Resources: %s\n", num, name, lecturer, date, description,
            homeWorks.toString(), resources.toString());
        return toString;
    }

    public Lesson() {

    }

    public Lesson(int num) {

    }

    public Lesson(int num, String name, String description, LocalDateTime date, Person lecturer) {
        this.num = num;
        this.name = name;
        this.description = description;
        this.date = date;
        this.lecturer = lecturer;
        this.resources = new ArrayList<>();
        this.homeWorks = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return num == lesson.num && Objects.equals(name, lesson.name) && Objects.equals(description, lesson.description) && Objects.equals(date, lesson.date) && Objects.equals(resources, lesson.resources) && Objects.equals(lecturer, lesson.lecturer) && Objects.equals(homeWorks, lesson.homeWorks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, name, description, date, resources, lecturer, homeWorks);
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Integer> getIdResources() {
        return resources;
    }

    public void setResources(List<Integer> resources) {
        this.resources = resources;
    }

    public Person getLecturer() {
        return lecturer;
    }

    public void setLecturer(Person lecturer) {
        this.lecturer = lecturer;
    }

    public List<Integer> getIdHomeWorks() {
        return homeWorks;
    }

    public void setHomeWorks(List<Integer> homeWorks) {
        this.homeWorks = homeWorks;
    }
}
