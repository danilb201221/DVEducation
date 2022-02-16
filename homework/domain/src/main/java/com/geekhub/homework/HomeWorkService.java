package com.geekhub.homework;

import com.geekhub.lesson.Lesson;

import java.time.LocalDateTime;

public class HomeWorkService {

    HomeWorkRepository homeWorkRepository = new HomeWorkRepository();

    public void addHomeWork(Lesson lesson, String name, String task, LocalDateTime ldt) {
        HomeWork homeWork = new HomeWork(name, task, ldt);

        homeWorkRepository.getHomeWorks().put(lesson.hashCode(), homeWork);
        lesson.getIdHomeWorks().add(homeWork.hashCode());
    }

    public StringBuilder getHomeWorkList(Lesson lesson) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lesson.getIdHomeWorks().size() - 1; i++) {
            Integer hash = lesson.getIdHomeWorks().get(i);
            result.append(homeWorkRepository.getHomeWorks().get(hash).toString());
        }
        return result;
    }

    public void deleteHomeWork(Lesson lesson, String name) {
        for (int i = 0; i < lesson.getIdHomeWorks().size(); i++) {
            Integer hash = lesson.getIdHomeWorks().get(i);
            if (homeWorkRepository.getHomeWorks().get(hash).getName().equals(name)) {
                lesson.getIdHomeWorks().remove(hash);
            }
        }
    }
}
