package com.geekhub.homework;

import java.util.HashMap;
import java.util.Map;

public class HomeWorkRepository {

    private Map<Integer, HomeWorkImpl> homeWorks = new HashMap<>();

    public Map<Integer, HomeWorkImpl> getHomeWorks() {
        return homeWorks;
    }
}
