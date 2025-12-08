public class ArrayQueueADT {
    private Object[] elements;
    private int front;
    private int rear;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public ArrayQueueADT() {
        elements = new Object[DEFAULT_CAPACITY];
        front = 0;
        rear = 0;
        size = 0;
    }

    private void ensureCapacity() {
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

    public void enqueue(Object element) {
        ensureCapacity();
        elements[rear] = element;
        rear = (rear + 1) % elements.length;
        size++;
    }

    public Object element() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return elements[front];
    }

    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        Object result = elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length;
        size--;
        return result;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[(front + i) % elements.length] = null;
        }
        front = 0;
        rear = 0;
        size = 0;
    }
}