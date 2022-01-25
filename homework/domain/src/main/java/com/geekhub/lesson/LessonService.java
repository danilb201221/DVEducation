package com.geekhub.lesson;

import com.geekhub.course.Course;
import com.geekhub.exeptions.LessonNotFoundException;
import com.geekhub.person.Person;

import java.time.LocalDateTime;

public class LessonService {


    private final LessonsRepository lessonsRepository;

    public LessonService(LessonsRepository lessonsRepository) {
        this.lessonsRepository = lessonsRepository;
    }


    public StringBuilder displayLessonsList(Course course) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < course.getIdLessons().size()-1; i++) {
            Integer hash = course.getIdLessons().get(i);
            result.append(lessonsRepository.toString(hash));
        }
        return result;
    }


    public void addNewLesson(Course course, int num, String name, String description, LocalDateTime date, Person lecturer) {
        Lesson lesson = new Lesson(num, name, description, date, lecturer);
        lessonsRepository.addNewLesson(course, lesson);
    }


    public void delLesson(Course course) {
        course.setIdLesson(null);
    }

    public Lesson getLesson(Course course, int num) throws LessonNotFoundException {
        Lesson lesson = null;
        for (int i = 0; i < course.getIdLessons().size()-1; i++) {
            Integer hash = course.getIdLessons().get(i);
            lesson = lessonsRepository.getLesson(hash, num);
            if (lesson != null) {
                break;
            }
        }
        return lesson;
    }
}