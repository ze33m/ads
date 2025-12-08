import java.util.*;

class PriorityQueueSet<T extends Comparable<T>> {
    private TreeSet<T> set;
    
    public PriorityQueueSet() {
        set = new TreeSet<>();
    }
    
    public void add(T element) {
        set.add(element);
    }
    
    public T poll() {
        if (isEmpty()) {
            return null;
        }
        T element = set.first();
        set.remove(element);
        return element;
    }
    
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return set.first();
    }
    
    public boolean isEmpty() {
        return set.isEmpty();
    }
    
    public int size() {
        return set.size();
    }
    
    public void display() {
        System.out.print("PriorityQueue: ");
        for (T element : set) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

public class PriorityQueueTest {
    public static void main(String[] args) {
        System.out.println("=== Тестирование очереди с приоритетом на основе Set ===");
        
        PriorityQueueSet<Integer> pq = new PriorityQueueSet<>();
        
        System.out.println("\n1. Добавление 10 элементов:");
        pq.add(15);
        pq.add(3);
        pq.add(20);
        pq.add(7);
        pq.add(1);
        pq.add(12);
        pq.add(9);
        pq.add(25);
        pq.add(5);
        pq.add(18);
        
        pq.display();
        
        System.out.println("\n2. Извлечение и вывод нескольких элементов:");
        System.out.println("Peek: " + pq.peek());
        System.out.println("Poll: " + pq.poll());
        System.out.println("Poll: " + pq.poll());
        System.out.println("Poll: " + pq.poll());
        
        System.out.println("\n3. Состояние после извлечения:");
        pq.display();
        
        System.out.println("\n4. Добавление новых элементов и повторное извлечение:");
        pq.add(2);
        pq.add(30);
        pq.add(8);
        
        pq.display();
        
        System.out.println("\n5. Извлечение всех оставшихся элементов:");
        while (!pq.isEmpty()) {
            System.out.println("Poll: " + pq.poll());
        }
        
        System.out.println("\n6. Проверка на пустоту:");
        System.out.println("Is empty? " + pq.isEmpty());
        System.out.println("Size: " + pq.size());
        
        System.out.println("\n7. Тестирование со строками:");
        PriorityQueueSet<String> stringPQ = new PriorityQueueSet<>();
        stringPQ.add("banana");
        stringPQ.add("apple");
        stringPQ.add("cherry");
        stringPQ.add("date");
        stringPQ.add("fig");
        
        System.out.println("Строковая очередь:");
        while (!stringPQ.isEmpty()) {
            System.out.println("Poll: " + stringPQ.poll());
        }
    }
}