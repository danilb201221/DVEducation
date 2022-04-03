package com.geekhub.course;

public class CourseImpl {
    private Long id;
    private String name;


    public CourseImpl(String name) {
        this.name = name;
    }

    public CourseImpl(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}