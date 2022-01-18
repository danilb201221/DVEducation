package com.geekhub.homework;

import com.geekhub.lesson.Lesson;

import java.util.HashMap;
import java.util.Map;

public class HomeWorkRepository {

    private Map<Integer, HomeWork> homeWorks = new HashMap<>();

    public void addHomeWork(Lesson lesson, HomeWork homeWork) {
        homeWorks.put(homeWork.hashCode(), homeWork);
        lesson.getIdHomeWorks().add(homeWork.hashCode());
    }

    public String toString(Integer hash) {
        return homeWorks.get(hash).toString();
    }

    public Map<Integer, HomeWork> getHomeWorks() {
        return homeWorks;
    }
}
