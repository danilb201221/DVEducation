package com.geekhub;

import com.geekhub.lesson.LessonImpl;
import com.geekhub.resource.ResourceService;
import com.geekhub.resource.ResourceType;

public class ResourceConsole {

    ScannerHelper scannerHelper = new ScannerHelper();
    ResourceService resourceService = new ResourceService();

    public void addResource(LessonImpl lessonImpl) {
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

        resourceService.addNewResource(lessonImpl, resourceType, name, data);
    }

    public void deleteResource(LessonImpl lessonImpl) {
        System.out.println("Get name resource");
        String name = scannerHelper.getString();
        resourceService.deleteResource(lessonImpl, name);
    }


    public void displayResourcesList(LessonImpl lessonImpl) {
        System.out.println(resourceService.getResourcesList(lessonImpl));
    }
}
