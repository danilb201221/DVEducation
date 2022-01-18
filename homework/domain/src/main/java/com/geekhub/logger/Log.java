package com.geekhub.logger;

import java.util.ArrayList;

public class Log {
    ArrayList loggerList = new ArrayList<String>();

    public void addLog(String log) {
        loggerList.add(log);
    }
}
