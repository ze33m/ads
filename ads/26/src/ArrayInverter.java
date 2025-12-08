import java.util.Stack;

public class ArrayInverter {
    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Исходный массив:");
        printArray(array1);
        
        invertArray(array1);
        System.out.println("Инвертированный массив:");
        printArray(array1);
        
        String[] array2 = {"A", "B", "C", "D", "E"};
        System.out.println("\nИсходный строковый массив:");
        printArray(array2);
        
        invertArray(array2);
        System.out.println("Инвертированный строковый массив:");
        printArray(array2);
    }
    
    public static <T> void invertArray(T[] array) {
        Stack<T> stack = new Stack<>();
        
        for (T element : array) {
            stack.push(element);
        }
        
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
    }
    
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}