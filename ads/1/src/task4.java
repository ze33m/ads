import java.util.ArrayList;
import java.util.Scanner;

public class task4 {
    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);
        String line = console.nextLine();
        ArrayList<Float> array = new ArrayList<Float>();
        while (isNumeric(line))
        {
            float num = Float.valueOf(line);
            array.add(num);
            line = console.nextLine();
        }
        console.close();

        System.out.println("сумма: "+sum(array));
        System.out.println("максимальное число: "+max(array));
        System.out.println("минимальное число: "+min(array));
        
    }

    public static float sum(ArrayList<Float> array)
    {
        float summa = 0;
        for(int i = 0; i<array.size(); i++)
            summa += array.get(i);
        return summa;
    }

    public static float min(ArrayList<Float> array)
    {
        float min = array.get(0);
        for(int i = 1; i<array.size(); i++)
            if (array.get(i) < min) 
                min = array.get(i);
        return min;
    }

    public static float max(ArrayList<Float> array)
    {
        float max = array.get(0);
        for(int i = 1; i<array.size(); i++)
            if (array.get(i) > max) 
                max = array.get(i);
        
        return max;
    }

    public static boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}
