package com.geekhub.logger;

import java.util.ArrayList;

public class Log {
    ArrayList<String> loggerList = new ArrayList<>();

    public void addLog(String log) {
        loggerList.add(log);
    }
}
