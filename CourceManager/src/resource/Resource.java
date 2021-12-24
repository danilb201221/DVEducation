package resource;

import MainConsole;

public class Resource {
    private String name;
    private ResourceType type;
    private String data;

    MainConsole console = new MainConsole();




    public String toString() {
        String toString = String.format("Type: %s Name: %s\n", type, name);
        return toString;
    }




    public Resource(){

    }

    public Resource(ResourceType resourceType, String name, String data){
        this.type = resourceType;
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
