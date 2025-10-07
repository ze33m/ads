public class App {
    public static void main(String[] args) throws Exception {
        Processor p = new Processor("intel core i7", 21, 4);

        Memory m = new Memory("WD", 512);

        Monitor mon = new Monitor("AOC", 144);

        Brand brand = Brand.MICROSOFT;
        
        Computer computer = new Computer(brand, p, m, mon);
        System.out.println(computer);
    }
}
