package com.geekhub.lesson;

import com.geekhub.course.CourseImpl;
import com.geekhub.exeptions.LessonNotFoundException;
import com.geekhub.person.PersonImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class LessonService {


    LessonsRepository lessonsRepository = new LessonsRepository();


    public ArrayList<String> getLessonsList(CourseImpl courseImpl) {
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < courseImpl.getIdLessons().size(); i++) {
            Integer hash = courseImpl.getIdLessons().get(i);
            LessonImpl lessonImpl = lessonsRepository.getAllLessons().get(hash);

            String lessonInf = String.format("%d. %s", lessonImpl.getNum(), lessonImpl.getName());
            result.add(lessonInf);
        }
        return result;
    }


    public void addNewLesson(CourseImpl courseImpl,
                             int numberLesson,
                             String nameLesson,
                             String description,
                             LocalDateTime date,
                             PersonImpl lecturer) {

        LessonImpl lessonImpl = new LessonImpl(numberLesson, nameLesson, description, date, lecturer);
        lessonsRepository.getAllLessons().put(lessonImpl.hashCode(), lessonImpl);
        courseImpl.getIdLessons().add(lessonImpl.hashCode());
    }


    public void deleteLesson(CourseImpl courseImpl, int index) throws IndexOutOfBoundsException, UnsupportedOperationException {
        courseImpl.getIdLessons().remove(index);
    }


    public LessonImpl getLesson(CourseImpl courseImpl, int numberLesson) throws LessonNotFoundException {
        LessonImpl lessonImpl = null;
        for (int i = 0; i < courseImpl.getIdLessons().size(); i++) {
            Integer hash = courseImpl.getIdLessons().get(i);
            lessonImpl = lessonsRepository.getAllLessons().get(hash);
            if (validatorNumberLesson(lessonImpl, numberLesson)) {
                break;
            }
        }
        if (lessonImpl != null) {
            return lessonImpl;
        } else {
            throw new LessonNotFoundException();
        }
    }


    private boolean validatorNumberLesson(LessonImpl lessonImpl, int requiredNumber) throws LessonNotFoundException {
        try {
            int currentNumber = lessonImpl.getNum();
            return currentNumber == requiredNumber;
        } catch (Exception e) {
            throw new LessonNotFoundException();
        }
    }
}