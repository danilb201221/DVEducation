package com.geekhub.lesson;

import com.geekhub.course.Course;
import com.geekhub.exeptions.LessonNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class LessonsRepository {

    private Map<Integer, Lesson> allLessons = new HashMap<Integer, Lesson>();

    public void addNewLesson(Course course, Lesson lesson) {
        allLessons.put(lesson.hashCode(), lesson);
        course.setIdLesson(lesson.hashCode());
    }

    public String toString(Integer hash) {
        return allLessons.get(hash).toString();
    }

    public Lesson getLesson(Integer hash, int num) throws LessonNotFoundException {
        Lesson lesson = allLessons.get(hash);
        if (lesson.getNum() == num) {
            return lesson;
        } else {
            return null;
        }
    }
}
