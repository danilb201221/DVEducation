package com.geekhub.resource;

import com.geekhub.lesson.Lesson;

public class ResourceService {

    ResourceRepository resourceRepository = new ResourceRepository();

    public void addNewResource(Lesson lesson, ResourceType resourceType, String name, String data) {
        Resource resource = new Resource(resourceType, name, data);
        resourceRepository.addNewResource(lesson, resource);
    }

    public StringBuilder getResourcesList(Lesson lesson) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lesson.getIdResources().size() - 1; i++) {
            Integer hash = lesson.getIdResources().get(i);
            result.append(resourceRepository.toString(hash));
        }
        return result;
    }

    public void delResource(Lesson lesson, String name) {
        for (int i = 0; i < lesson.getIdResources().size(); i++) {
            Integer hash = lesson.getIdResources().get(i);
            if (resourceRepository.getResources().get(hash).getName().equals(name)) {
                lesson.getIdResources().remove(hash);
            }
        }
    }
}
