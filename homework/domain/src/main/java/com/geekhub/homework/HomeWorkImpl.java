package com.geekhub.homework;

import java.time.LocalDateTime;

public class HomeWorkImpl {
    private Long id;
    private String name;
    private String task;
    private LocalDateTime deadLine;
    private Long lesson_id;

    public HomeWorkImpl(String name, String task, LocalDateTime deadLine, Long lesson_id) {
        this.name = name;
        this.task = task;
        this.deadLine = deadLine;
        this.lesson_id = lesson_id;
    }

    public HomeWorkImpl(Long id, String name, String task, LocalDateTime deadLine, Long lesson_id) {
        this.id = id;
        this.name = name;
        this.task = task;
        this.deadLine = deadLine;
        this.lesson_id = lesson_id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
            "Task: " + task + "\n" +
            "Dead Line: " + deadLine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDateTime getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDateTime deadLine) {
        this.deadLine = deadLine;
    }

    public Long getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(Long lesson_id) {
        this.lesson_id = lesson_id;
    }
}
