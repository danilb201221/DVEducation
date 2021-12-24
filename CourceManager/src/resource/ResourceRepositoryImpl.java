package resource;

import MainConsole;

public class ResourceRepositoryImpl implements ResourceRepository {

    ResourceService resource = new ResourceServiceImpl();
    MainConsole console = new MainConsole();

    private Resource[] resources;

    public ResourceRepositoryImpl() {
        this.resources = new Resource[20];
    }

    @Override
    public void printAllResources() {
        for (int i = 0; i < resources.length; i++) {
            if ((resources[i] != null)) {
                System.out.printf("%d. %s", (i+1), resources[i].toString());
            } else {
                continue;
            }
        }
    }

    @Override
    public void addNewResource() {
        for (int i = 0; i < resources.length; i++) {
            if ((resources[i] == null)) {
                resources[i] = resource.addNewResource();
                break;
            }
        }
    }

    @Override
    public void getResourceByNumber() {
        int num = console.getInt();
        System.out.println(resources[num - 1].getData());
    }

}
