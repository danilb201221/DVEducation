package com.geekhub;

import com.geekhub.lesson.Lesson;
import com.geekhub.resource.ResourceService;
import com.geekhub.resource.ResourceType;

public class ResourceConsole {

    ScannerHelper scannerHelper = new ScannerHelper();
    ResourceService resourceService = new ResourceService();

    public void addResource(Lesson lesson) {
        ResourceType resourceType = null;
        System.out.println("Chose type resource:\n" +
            "1. Url\n" +
            "2. Book\n" +
            "3. Video\n");
        String menu = scannerHelper.getString();
        switch (menu) {
            case "1" -> resourceType = ResourceType.valueOf("URL");
            case "2" -> resourceType = ResourceType.valueOf("BOOK");
            case "3" -> resourceType = ResourceType.valueOf("VIDEO");
            default -> scannerHelper.notAvailable();
        }

        System.out.println("Get name");
        String name = scannerHelper.getString();

        System.out.println("Get data");
        String data = scannerHelper.getString();

        resourceService.addNewResource(lesson, resourceType, name, data);
    }

    public void deleteResource(Lesson lesson) {
        System.out.println("Get name resource");
        String name = scannerHelper.getString();
        resourceService.deleteResource(lesson, name);
    }


    public void displayResourcesList(Lesson lesson) {
        System.out.println(resourceService.getResourcesList(lesson));
    }
}
