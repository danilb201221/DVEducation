package com.geekhub.resource;

import com.geekhub.lesson.Lesson;

import java.util.HashMap;
import java.util.Map;

public class ResourceRepository {

    private Map<Integer, Resource> resources = new HashMap<>();

    public void addNewResource(Lesson lesson, Resource resource) {
        resources.put(resource.hashCode(), resource);
        lesson.getIdResources().add(resource.hashCode());
    }

    public String toString(Integer hash) {
        return resources.get(hash).toString();
    }

    public Map<Integer, Resource> getResources() {
        return resources;
    }
}
