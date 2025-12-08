import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayConverter {
    public static <T> List<T> convertArrayToList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
    public static void main(String[] args) {
        String[] stringArray = {"one", "two", "three"};
        List<String> stringList = convertArrayToList(stringArray);
        System.out.println(stringList);
        
        Integer[] intArray = {1, 2, 3, 4, 5};
        List<Integer> intList = convertArrayToList(intArray);
        System.out.println(intList);
    }
}