import java.util.Random;
import java.util.Arrays;

public class math_random {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();

        // инициализация
        int[] randomArray = new int[10];
        for (int i = 0; i<10; i++)
        {
            randomArray[i] = rand.nextInt(100);
        }

        // вывод
        System.out.println("Массив");
        for (int i = 0; i<10; i++)
        {
            System.out.println(randomArray[i]);
        }

        Arrays.sort(randomArray);

        // вывод остортированного массива
        System.out.println("\nОтсортированный массив");
        for (int i = 0; i<10; i++)
        {
            System.out.println(randomArray[i]);
        }
    }
}
