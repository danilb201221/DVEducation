package lesson;

import lesson.Lesson;

public interface LessonService {


    void menuLesson(Lesson lesson);

    Lesson addNewLessonByNumber(int num);
}
