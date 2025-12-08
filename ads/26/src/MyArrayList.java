
import java.util.NoSuchElementException;

class MyArrayList<T> implements CustomList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;
    
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    
    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }
    
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
    
    public CustomIterator<T> iterator() {
        return new MyArrayListIterator();
    }
    
    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }
    
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
    
    private class MyArrayListIterator implements CustomIterator<T> {
        private int currentIndex = 0;
        private boolean canRemove = false;
        
        public boolean hasNext() {
            return currentIndex < size;
        }
        
        @SuppressWarnings("unchecked")
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            canRemove = true;
            return (T) elements[currentIndex++];
        }
        
        public void remove() {
            if (!canRemove) {
                throw new IllegalStateException();
            }
            
            for (int i = currentIndex - 1; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }
            elements[--size] = null;
            currentIndex--;
            canRemove = false;
        }
    }
}

