package com.geekhub;

import com.geekhub.lesson.Lesson;
import com.geekhub.resource.ResourceService;
import com.geekhub.resource.ResourceType;

public class ResourceConsole {

    private final ScannerHelper scannerHelper;
    private final ResourceService resourceService;

    public ResourceConsole(ScannerHelper scannerHelper, ResourceService resourceService) {
        this.scannerHelper = scannerHelper;
        this.resourceService = resourceService;
    }

    public void addResource(Lesson lesson) {
        ResourceType resourceType = null;
        System.out.println("Chose type resource:\n" +
            "1. url" +
            "2. book" +
            "3. video");
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
        resourceService.delResource(lesson, name);
    }


    public void displayResourcesList(Lesson lesson) {
        System.out.println(resourceService.getResourcesList(lesson));
    }
}
