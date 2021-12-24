package resource;

public class ResourceServiceImpl implements ResourceService {
    Console console = new ConsoleImpl();

    Resource resource;

    public ResourceServiceImpl() {
        this.resource = new Resource();
    }


    @Override
    public Resource addNewResource() {
        System.out.println("What type of resource do you want to add?\n"
            + "1. URL\n"
            + "2. Book\n"
            + "3. Video");
        int type = console.getInt();
        System.out.println("Add name resource");
        String name = console.getString();

        System.out.println("Add data resource");
        String data = console.getString();

        switch (type) {
            case 1:
                resource = new Resource(ResourceType.URL, name, data);
                break;
            case 2:
                resource = new Resource(ResourceType.BOOK, name, data);
                break;
            case 3:
                resource = new Resource(ResourceType.VIDEO, name, data);
                break;
            default:
                System.out.println("This type is not supported");
        }
        return resource;
    }
}
