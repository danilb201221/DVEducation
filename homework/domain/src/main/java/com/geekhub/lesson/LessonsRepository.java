package com.geekhub.lesson;

import java.util.HashMap;
import java.util.Map;

public class LessonsRepository {

    private Map<Integer, LessonImpl> allLessons = new HashMap<>();


    public String toString(Integer hash) {
        return allLessons.get(hash).toString();
    }


    public Map<Integer, LessonImpl> getAllLessons() {
        return allLessons;
    }
}
