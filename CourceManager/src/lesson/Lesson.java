package lesson;

import homework.HomeWork;
import person.Person;
import resource.Resource;

public class Lesson {

    private int num;
    private String name;
    private String description;
    private String date;
    private Resource[] resources;
    private Person lecturer;
    private HomeWork homeWork;

    @Override
    public String toString() {
        String toString = String.format ("Number: %d. Name: %s\n" +
                "Lecturer: %s\n" +
                "Date: %s\n" +
                "Description: %s\n" +
                "Homework: %s\n" +
                "Resources: %s\n", num, name, lecturer, date, description,
            homeWork.toString(), resources.toString());
        return toString;
    }

    public Lesson() {

    }

    public Lesson(int num) {

    }

    public Lesson(int num, String name, String description, String date, Resource[] resources, Person lecturer, HomeWork homeWork) {
        this.num = num;
        this.name = name;
        this.description = description;
        this.date = date;
        this.resources = resources;
        this.lecturer = lecturer;
        this.homeWork = homeWork;
    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Resource[] getResources() {
        return resources;
    }

    public void setResources(Resource[] resources) {
        this.resources = resources;
    }

    public Person getLecturer() {
        return lecturer;
    }

    public void setLecturer(Person lecturer) {
        this.lecturer = lecturer;
    }

    public HomeWork getHomeWork() {
        return homeWork;
    }

    public void setHomeWork(HomeWork homeWork) {
        this.homeWork = homeWork;
    }

}
