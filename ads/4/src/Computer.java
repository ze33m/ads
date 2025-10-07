enum Brand {
    DELL, HP, LENOVO, ASUS, APPLE, MICROSOFT
}

public class Computer {
    private Brand brand;
    private Processor processor;
    private Memory memory;
    private Monitor monitor;

    public Computer(Brand brand, Processor processor, Memory memory, Monitor monitor) {
        this.brand = brand;
        this.processor = processor;
        this.memory = memory;
        this.monitor = monitor;
    }

    @Override public String toString()
    {
        return "Компьютер " + this.brand.toString() + ":\n" +
               "  " + this.processor.toString() + "\n" +
               "  " + this.memory.toString() + "\n" +
               "  " + this.monitor.toString();
    }

}
