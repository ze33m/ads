public class ArrayQueueModule {
    private static final int DEFAULT_CAPACITY = 10;
    private static Object[] elements = new Object[DEFAULT_CAPACITY];
    private static int front = 0;
    private static int rear = 0;
    private static int size = 0;

    private static void ensureCapacity() {
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[(front + i) % elements.length];
            }
            elements = newElements;
            front = 0;
            rear = size;
        }
    }

    public static void enqueue(Object element) {
        ensureCapacity();
        elements[rear] = element;
        rear = (rear + 1) % elements.length;
        size++;
    }

    public static Object element() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return elements[front];
    }

    public static Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        Object result = elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length;
        size--;
        return result;
    }

    public static int size() {
        return size;
    }

    public static boolean isEmpty() {
        return size == 0;
    }

    public static void clear() {
        for (int i = 0; i < size; i++) {
            elements[(front + i) % elements.length] = null;
        }
        front = 0;
        rear = 0;
        size = 0;
    }
}