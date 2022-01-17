package com.geekhub.homework;


import java.time.LocalDateTime;
import java.util.Objects;

public class HomeWork {
    private String name;
    private String task;
    private LocalDateTime deadLine;

    public HomeWork(String name, String task, LocalDateTime deadLine) {
        this.name = name;
        this.task = task;
        this.deadLine = deadLine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeWork homeWork = (HomeWork) o;
        return Objects.equals(name, homeWork.name) && Objects.equals(task, homeWork.task) && Objects.equals(deadLine, homeWork.deadLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, task, deadLine);
    }

    public String getName() {
        return name;
    }
}
