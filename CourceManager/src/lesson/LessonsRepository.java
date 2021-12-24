package lesson;

import lesson.Lesson;

public interface LessonsRepository {
    void printAllLessons();

    void addNewLessonByNumber();

    void delLessonByNumber();

//    void getLessonByNumber(int num);

    void getLessonByNumber();

    Lesson[] getLessons();
}
