public class Shirt {
    String model;
    String name; 
    String color;
    String size;

    public Shirt(String model, String name, String color, String size)
    {
        this.model = model;
        this.name = name;
        this.color = color;
        this.size = size;
    }

    public Shirt(String info)
    {
        String[] information = info.split(",");
        this.model = information[0];
        this.name = information[1];
        this.color = information[2];
        this.size = information[3];
    }

    public String toString()
    {
        return model + " | " + name + " | " + color + " | " + size;
    }


}
