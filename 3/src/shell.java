public class shell {
    public static void main(String[] args) throws Exception {
        Double d = Double.valueOf(31.4);
        d = Double.parseDouble("325.5");

        byte b = d.byteValue();
        short s = d.shortValue();
        int i = d.intValue();
        long l = d.longValue();
        float f = d.floatValue();
        double dd = d.doubleValue();
        char c = (char) d.intValue(); 

        System.out.println(d);
        String string = Double.toString(3.14);
    }
}
