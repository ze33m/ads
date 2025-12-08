public class LinkedQueueTest {
    public static void main(String[] args) {
        System.out.println("Testing LinkedQueue:");
        
        Queue queue = new LinkedQueue();
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");
        
        System.out.println("Size: " + queue.size());
        System.out.println("Element: " + queue.element());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Size after dequeue: " + queue.size());
        System.out.println("Is empty: " + queue.isEmpty());
        
        queue.enqueue("Fourth");
        System.out.println("Element after new enqueue: " + queue.element());
        
        queue.clear();
        System.out.println("Is empty after clear: " + queue.isEmpty());
        
        try {
            queue.element();
        } catch (IllegalStateException e) {
            System.out.println("Correctly threw exception for empty queue");
        }
    }
}