package com.geekhub.homework;

import java.util.HashMap;
import java.util.Map;

public class HomeWorkRepository {

    private Map<Integer, HomeWork> homeWorks = new HashMap<>();

    public Map<Integer, HomeWork> getHomeWorks() {
        return homeWorks;
    }
}
