public class GenericArray<T> {
    private T[] array;

    public GenericArray(T[] array) {
        this.array = array;
    }

    public void printArray() {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        GenericArray<Integer> intGenericArray = new GenericArray<>(intArray);
        intGenericArray.printArray();

        String[] stringArray = {"A", "B", "C"};
        GenericArray<String> stringGenericArray = new GenericArray<>(stringArray);
        stringGenericArray.printArray();
    }
}