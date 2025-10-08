import java.util.Scanner;

public class task11 {

    public static int countOnes(Scanner scanner, int prev, int count) {
        int current = scanner.nextInt();
        
        if (prev == 0 && current == 0) 
            return 0;
        
        count = (current == 1) ? 1 : 0;

        return count + countOnes(scanner, current, count);
    }

    public static void main(String[] args) {
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        int count = countOnes(scanner, 0, 0);
        System.out.println(count);
    }
}
