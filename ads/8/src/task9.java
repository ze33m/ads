public class task9 {
    public static int countSequences(int a, int b) {
        if (a > b + 1)
            return 0;

        if (a == 0) 
            return 1;

        if (b == 0) 
            return a == 1 ? 1 : 0;

        return countSequences(a, b - 1) + countSequences(a - 1, b - 1);
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        System.out.println(countSequences(a, b));
    }
}
