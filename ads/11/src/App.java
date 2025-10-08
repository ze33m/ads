import java.util.*;

public class App {
    public static void main(String[] args) {
        int N = 100_000; // количество элементов
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();


        measureAdd(arrayList, N, "ArrayList");
        measureAdd(linkedList, N, "LinkedList");

        measureInsert(arrayList, N, "ArrayList");
        measureInsert(linkedList, N, "LinkedList");

        measureSearch(arrayList, N, "ArrayList");
        measureSearch(linkedList, N, "LinkedList");

        measureRemove(arrayList, "ArrayList");
        measureRemove(linkedList, "LinkedList");
    }


    private static void measureAdd(List<Integer> list, int N, String name) {
        list.clear();
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long end = System.nanoTime();
        System.out.printf("%s: добавление %d элементов заняло %.3f мс%n",
                name, N, (end - start) / 1_000_000.0);
    }

    private static void measureInsert(List<Integer> list, int N, String name) {
        list.clear();
        for (int i = 0; i < N; i++) list.add(i);
        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.add(N / 2, 12345); 
        }
        long end = System.nanoTime();
        System.out.printf("%s: вставка 1000 элементов заняла %.3f мс%n",
                name, (end - start) / 1_000_000.0);
    }

    private static void measureSearch(List<Integer> list, int N, String name) {
        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.contains(N - 1);
        }
        long end = System.nanoTime();
        System.out.printf("%s: 1000 поисков заняли %.3f мс%n",
                name, (end - start) / 1_000_000.0);
    }

    private static void measureRemove(List<Integer> list, String name) {
        long start = System.nanoTime();
        while (!list.isEmpty()) {
            list.remove(list.size() / 2);
        }
        long end = System.nanoTime();
        System.out.printf("%s: полное удаление заняло %.3f мс%n",
                name, (end - start) / 1_000_000.0);
    }
}
