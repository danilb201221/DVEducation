package com.geekhub;

import com.geekhub.lesson.Lesson;
import com.geekhub.resource.ResourceService;
import com.geekhub.resource.ResourceType;

public class ResourceConsole {

    MainConsole mainConsole = new MainConsole();
    ResourceService resourceService = new ResourceService();

    public void addResource(Lesson lesson) {
        ResourceType resourceType = null;
        System.out.println("Chose type com.geekhub.resource:\n" +
            "1. url" +
            "2. book" +
            "3. video");
        String menu = mainConsole.getString();
        switch (menu) {
            case "1" -> resourceType = ResourceType.valueOf("URL");
            case "2" -> resourceType = ResourceType.valueOf("BOOK");
            case "3" -> resourceType = ResourceType.valueOf("VIDEO");
            default -> mainConsole.notAvailable();
        }

        System.out.println("Get name");
        String name = mainConsole.getString();

        System.out.println("Get data");
        String data = mainConsole.getString();

        resourceService.addNewResource(lesson, resourceType, name, data);
    }

    public void delResource(Lesson lesson) {
        System.out.println("Get name com.geekhub.resource");
        String name = mainConsole.getString();
        resourceService.delResource(lesson, name);
    }


    public void displayResourcesList(Lesson lesson) {
        System.out.println(resourceService.getResourcesList(lesson));
    }
}
