interface CustomList<T> {
    void add(T element);
    T get(int index);
    int size();
    boolean isEmpty();
    void clear();
    CustomIterator<T> iterator();
}

interface CustomIterator<T> {
    boolean hasNext();
    T next();
    void remove();
}