package com.geekhub.lesson;

import java.util.HashMap;
import java.util.Map;

public class LessonsRepository {

    private Map<Integer, Lesson> allLessons = new HashMap<>();


    public String toString(Integer hash) {
        return allLessons.get(hash).toString();
    }


    public Map<Integer, Lesson> getAllLessons() {
        return allLessons;
    }
}
