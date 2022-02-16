package com.geekhub.lesson;

import com.geekhub.course.Course;
import com.geekhub.exeptions.LessonNotFoundException;
import com.geekhub.person.Person;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public class LessonService {


    LessonsRepository lessonsRepository = new LessonsRepository();


    public ArrayList<String> getLessonsList(Course course) {
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < course.getIdLessons().size(); i++) {
            Integer hash = course.getIdLessons().get(i);
            Lesson lesson = lessonsRepository.getAllLessons().get(hash);

            String lessonInf = String.format("%d. %s", lesson.getNum(), lesson.getName());
            result.add(lessonInf);
        }
        return result;
    }


    public void addNewLesson(Course course,
                             int numberLesson,
                             String nameLesson,
                             String description,
                             LocalDateTime date,
                             Person lecturer) {

        Lesson lesson = new Lesson(numberLesson, nameLesson, description, date, lecturer);
        lessonsRepository.getAllLessons().put(lesson.hashCode(), lesson);
        course.getIdLessons().add(lesson.hashCode());
    }


    public void deleteLesson(Course course, int index) throws IndexOutOfBoundsException, UnsupportedOperationException {
        course.getIdLessons().remove(index);
    }


    public Lesson getLesson(Course course, int numberLesson) throws LessonNotFoundException {
        Lesson lesson = null;
        for (int i = 0; i < course.getIdLessons().size(); i++) {
            Integer hash = course.getIdLessons().get(i);
            lesson = lessonsRepository.getAllLessons().get(hash);
            if (validatorNumberLesson(lesson, numberLesson)) {
                break;
            }
        }
        if (lesson != null) {
            return lesson;
        } else {
            throw new LessonNotFoundException();
        }
    }


    private boolean validatorNumberLesson(Lesson lesson, int requiredNumber) throws LessonNotFoundException {
        try {
            int currentNumber = lesson.getNum();
            return currentNumber == requiredNumber;
        } catch (Exception e) {
            throw new LessonNotFoundException();
        }
    }
}