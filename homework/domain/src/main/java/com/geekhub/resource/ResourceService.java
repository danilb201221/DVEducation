package com.geekhub.resource;

import com.geekhub.lesson.LessonImpl;

public class ResourceService {

    ResourceRepository resourceRepository = new ResourceRepository();

    public void addNewResource(LessonImpl lessonImpl, ResourceType resourceType, String name, String data) {
        ResourceImpl resourceImpl = new ResourceImpl(resourceType, name, data);
        resourceRepository.getResources().put(resourceImpl.hashCode(), resourceImpl);
        lessonImpl.getIdResources().add(resourceImpl.hashCode());
    }

    public StringBuilder getResourcesList(LessonImpl lessonImpl) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lessonImpl.getIdResources().size() - 1; i++) {
            Integer hash = lessonImpl.getIdResources().get(i);
            result.append(resourceRepository.toString(hash));
        }
        return result;
    }

    public void deleteResource(LessonImpl lessonImpl, String name) {
        for (int i = 0; i < lessonImpl.getIdResources().size(); i++) {
            Integer hash = lessonImpl.getIdResources().get(i);
            if (resourceRepository.getResources().get(hash).getName().equals(name)) {
                lessonImpl.getIdResources().remove(hash);
            }
        }
    }
}
