public class Monitor {
    private String model;
    private Integer freq;

    public Monitor(String model, int freq) {
        this.model = model;
        this.freq = freq;
    }

    @Override public String toString()
    {
        return this.model + " | " + this.freq.toString();
    }
}