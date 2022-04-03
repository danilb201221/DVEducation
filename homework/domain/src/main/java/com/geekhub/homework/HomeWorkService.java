package com.geekhub.homework;

import com.geekhub.lesson.LessonImpl;

import java.time.LocalDateTime;

public class HomeWorkService {

    HomeWorkRepository homeWorkRepository = new HomeWorkRepository();

    public void addHomeWork(LessonImpl lessonImpl, String name, String task, LocalDateTime ldt) {
        HomeWorkImpl homeWorkImpl = new HomeWorkImpl(name, task, ldt);

        homeWorkRepository.getHomeWorks().put(lessonImpl.hashCode(), homeWorkImpl);
        lessonImpl.getIdHomeWorks().add(homeWorkImpl.hashCode());
    }

    public StringBuilder getHomeWorkList(LessonImpl lessonImpl) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lessonImpl.getIdHomeWorks().size() - 1; i++) {
            Integer hash = lessonImpl.getIdHomeWorks().get(i);
            result.append(homeWorkRepository.getHomeWorks().get(hash).toString());
        }
        return result;
    }

    public void deleteHomeWork(LessonImpl lessonImpl, String name) {
        for (int i = 0; i < lessonImpl.getIdHomeWorks().size(); i++) {
            Integer hash = lessonImpl.getIdHomeWorks().get(i);
            if (homeWorkRepository.getHomeWorks().get(hash).getName().equals(name)) {
                lessonImpl.getIdHomeWorks().remove(hash);
            }
        }
    }
}
