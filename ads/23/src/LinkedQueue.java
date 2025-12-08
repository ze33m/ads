public class LinkedQueue extends AbstractQueue {
    private static class Node {
        Object value;
        Node next;
        
        Node(Object value) {
            this.value = value;
            this.next = null;
        }
    }
    
    private Node front;
    private Node rear;
    
    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }
    
    public void enqueue(Object element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }
    
    public Object element() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.value;
    }
    
    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        Object result = front.value;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return result;
    }
    
    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
    }
}