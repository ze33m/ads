class HashNode<K, V> {
    K key;
    V value;
    HashNode<K, V> next;
    
    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

public class HashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    
    private HashNode<K, V>[] table;
    private int size;
    private int capacity;
    
    @SuppressWarnings("unchecked")
    public HashTable() {
        capacity = DEFAULT_CAPACITY;
        table = new HashNode[capacity];
        size = 0;
    }
    
    public void hashtabInit() {
        for (int i = 0; i < capacity; i++) {
            table[i] = null;
        }
        size = 0;
    }
    
    private int hashtabHash(K key) {
        int hashCode = key.hashCode();
        int index = Math.abs(hashCode % capacity);
        return index;
    }
    
    public void hashtabAdd(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        
        int index = hashtabHash(key);
        HashNode<K, V> head = table[index];
        
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = table[index];
        table[index] = newNode;
        size++;
        
        if ((float)size / capacity >= LOAD_FACTOR) {
            resize();
        }
    }
    
    public V hashtabLookup(K key) {
        int index = hashtabHash(key);
        HashNode<K, V> head = table[index];
        
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        
        return null;
    }
    
    public void hashtabDelete(K key) {
        int index = hashtabHash(key);
        HashNode<K, V> head = table[index];
        HashNode<K, V> prev = null;
        
        while (head != null) {
            if (head.key.equals(key)) {
                if (prev != null) {
                    prev.next = head.next;
                } else {
                    table[index] = head.next;
                }
                size--;
                return;
            }
            prev = head;
            head = head.next;
        }
    }
    
    @SuppressWarnings("unchecked")
    private void resize() {
        int oldCapacity = capacity;
        capacity = capacity * 2;
        HashNode<K, V>[] oldTable = table;
        table = new HashNode[capacity];
        
        for (int i = 0; i < oldCapacity; i++) {
            HashNode<K, V> head = oldTable[i];
            while (head != null) {
                HashNode<K, V> next = head.next;
                int newIndex = hashtabHash(head.key);
                head.next = table[newIndex];
                table[newIndex] = head;
                head = next;
            }
        }
    }
    
    public boolean containsKey(K key) {
        return hashtabLookup(key) != null;
    }
    
    public int getSize() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void display() {
        System.out.println("HashTable (size=" + size + ", capacity=" + capacity + "):");
        for (int i = 0; i < capacity; i++) {
            System.out.print("[" + i + "]: ");
            HashNode<K, V> head = table[i];
            while (head != null) {
                System.out.print("{" + head.key + "=" + head.value + "} ");
                head = head.next;
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Тестирование хэш-таблицы ===");
        
        HashTable<String, Integer> hashtab = new HashTable<>();
        hashtab.hashtabInit();
        
        System.out.println("\n1. Добавление 10 элементов:");
        hashtab.hashtabAdd("John", 25);
        hashtab.hashtabAdd("Alice", 30);
        hashtab.hashtabAdd("Bob", 35);
        hashtab.hashtabAdd("Emma", 28);
        hashtab.hashtabAdd("David", 32);
        hashtab.hashtabAdd("Sophia", 27);
        hashtab.hashtabAdd("Michael", 40);
        hashtab.hashtabAdd("Olivia", 29);
        hashtab.hashtabAdd("James", 33);
        hashtab.hashtabAdd("Isabella", 26);
        
        hashtab.display();
        
        System.out.println("\n2. Поиск элементов по ключу:");
        System.out.println("John: " + hashtab.hashtabLookup("John"));
        System.out.println("Alice: " + hashtab.hashtabLookup("Alice"));
        System.out.println("NonExistent: " + hashtab.hashtabLookup("NonExistent"));
        
        System.out.println("\n3. Удаление элементов:");
        System.out.println("Удаляем Bob...");
        hashtab.hashtabDelete("Bob");
        System.out.println("Удаляем Emma...");
        hashtab.hashtabDelete("Emma");
        
        System.out.println("\n4. Проверка после удаления:");
        hashtab.display();
        
        System.out.println("\n5. Проверка содержит ли таблица:");
        System.out.println("Contains John? " + hashtab.containsKey("John"));
        System.out.println("Contains Bob? " + hashtab.containsKey("Bob"));
        
        System.out.println("\n6. Добавление элемента с существующим ключом (обновление):");
        hashtab.hashtabAdd("John", 26);
        System.out.println("John после обновления: " + hashtab.hashtabLookup("John"));
        
        System.out.println("\n7. Проверка размера:");
        System.out.println("Size: " + hashtab.getSize());
        System.out.println("Is empty? " + hashtab.isEmpty());
    }
}