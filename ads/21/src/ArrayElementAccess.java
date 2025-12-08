public class ArrayElementAccess {
    public static <T> T getElementByIndex(T[] array, int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return array[index];
    }

    public static void main(String[] args) {
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        Double element = getElementByIndex(doubleArray, 2);
        System.out.println(element);

        Character[] charArray = {'a', 'b', 'c', 'd', 'e'};
        Character charElement = getElementByIndex(charArray, 4);
        System.out.println(charElement);
    }
}