package homework;

import MainConsole;

public class HomeWork {
    private String task;
    private String deadLine;

    MainConsole console = new MainConsole();

    public HomeWork() {
        System.out.println("Add task");
        setTask(console.getString());

        System.out.println("Add deadline");
        setDeadLine(console.getString());
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }
}
