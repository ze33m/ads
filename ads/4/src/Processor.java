public class Processor {
    private String model;
    private Double freq;
    private Integer cores;

    public Processor(String model, double freq, int cores) {
        this.model = model;
        this.freq = freq;
        this.cores = cores;
    }

    @Override public String toString()
    {
        return this.model + " | " + this.freq.toString() + " | " + this.cores.toString();
    }
}
