package com.geekhub.resource;

import java.util.HashMap;
import java.util.Map;

public class ResourceRepository {

    private Map<Integer, Resource> resources = new HashMap<>();

    public String toString(Integer hash) {
        return resources.get(hash).toString();
    }

    public Map<Integer, Resource> getResources() {
        return resources;
    }
}
