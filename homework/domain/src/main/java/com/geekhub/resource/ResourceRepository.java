package com.geekhub.resource;

import java.util.HashMap;
import java.util.Map;

public class ResourceRepository {

    private Map<Integer, ResourceImpl> resources = new HashMap<>();

    public String toString(Integer hash) {
        return resources.get(hash).toString();
    }

    public Map<Integer, ResourceImpl> getResources() {
        return resources;
    }
}
