public class Memory {
    private String model;
    private Integer capacity;

    public Memory(String model, int capacity) {
        this.model = model;
        this.capacity = capacity;
    }

    @Override public String toString()
    {
        return this.model + " | " + this.capacity.toString();
    }
}