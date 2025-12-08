public class ArrayQueueTest {
    public static void main(String[] args) {
        testArrayQueueModule();
        testArrayQueueADT();
        testArrayQueue();
    }

    private static void testArrayQueueModule() {
        System.out.println("Testing ArrayQueueModule:");
        ArrayQueueModule.clear();
        ArrayQueueModule.enqueue("A");
        ArrayQueueModule.enqueue("B");
        ArrayQueueModule.enqueue("C");
        System.out.println("Size: " + ArrayQueueModule.size());
        System.out.println("Element: " + ArrayQueueModule.element());
        System.out.println("Dequeue: " + ArrayQueueModule.dequeue());
        System.out.println("Size after dequeue: " + ArrayQueueModule.size());
        System.out.println("Is empty: " + ArrayQueueModule.isEmpty());
        ArrayQueueModule.clear();
        System.out.println("Is empty after clear: " + ArrayQueueModule.isEmpty());
        System.out.println();
    }

    private static void testArrayQueueADT() {
        System.out.println("Testing ArrayQueueADT:");
        ArrayQueueADT queue = new ArrayQueueADT();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Size: " + queue.size());
        System.out.println("Element: " + queue.element());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Size after dequeue: " + queue.size());
        System.out.println("Is empty: " + queue.isEmpty());
        queue.clear();
        System.out.println("Is empty after clear: " + queue.isEmpty());
        System.out.println();
    }

    private static void testArrayQueue() {
        System.out.println("Testing ArrayQueue:");
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue(1.5);
        queue.enqueue(2.5);
        queue.enqueue(3.5);
        System.out.println("Size: " + queue.size());
        System.out.println("Element: " + queue.element());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Size after dequeue: " + queue.size());
        System.out.println("Is empty: " + queue.isEmpty());
        queue.clear();
        System.out.println("Is empty after clear: " + queue.isEmpty());
    }
}