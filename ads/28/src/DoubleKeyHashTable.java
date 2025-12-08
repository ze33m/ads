import java.util.*;

class DoubleHashTable<K, V> {
    private static class Node<K, V> {
        K key;
        V value;
        
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    
    private Node<K, V>[] table;
    private int size;
    
    @SuppressWarnings("unchecked")
    public DoubleHashTable() {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }
    
    private int hash(K key) {
        if (key instanceof Double) {
            return doubleHash((Double) key);
        } else if (key instanceof Integer) {
            return integerHash((Integer) key);
        } else if (key instanceof String) {
            return stringHash((String) key);
        }
        return key.hashCode() % table.length;
    }
    
    private int doubleHash(double key) {
        long bits = Double.doubleToLongBits(key);
        return (int) Math.abs(bits % table.length);
    }
    
    private int integerHash(int key) {
        return (key & 0x7fffffff) % table.length;
    }
    
    private int stringHash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = 31 * hash + key.charAt(i);
        }
        return Math.abs(hash % table.length);
    }
    
    private int secondaryHash(K key) {
        if (key instanceof Double) {
            return 1 + (Math.abs(key.hashCode()) % (table.length - 1));
        }
        return 1;
    }
    
    public void put(K key, V value) {
        if (size >= table.length * LOAD_FACTOR) {
            resize();
        }
        
        int index = hash(key);
        int step = secondaryHash(key);
        
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                table[index].value = value;
                return;
            }
            index = (index + step) % table.length;
        }
        
        table[index] = new Node<>(key, value);
        size++;
    }
    
    public V get(K key) {
        int index = hash(key);
        int step = secondaryHash(key);
        
        int startIndex = index;
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                return table[index].value;
            }
            index = (index + step) % table.length;
            if (index == startIndex) {
                break;
            }
        }
        
        return null;
    }
    
    public boolean containsKey(K key) {
        return get(key) != null;
    }
    
    public void remove(K key) {
        int index = hash(key);
        int step = secondaryHash(key);
        
        int startIndex = index;
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                table[index] = null;
                size--;
                
                index = (index + step) % table.length;
                while (table[index] != null) {
                    Node<K, V> node = table[index];
                    table[index] = null;
                    size--;
                    put(node.key, node.value);
                    index = (index + step) % table.length;
                }
                return;
            }
            index = (index + step) % table.length;
            if (index == startIndex) {
                break;
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    private void resize() {
        Node<K, V>[] oldTable = table;
        table = new Node[oldTable.length * 2];
        size = 0;
        
        for (Node<K, V> node : oldTable) {
            if (node != null) {
                put(node.key, node.value);
            }
        }
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void display() {
        System.out.println("Хеш-таблица (размер: " + size + ", вместимость: " + table.length + "):");
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                System.out.println("  [" + i + "]: " + table[i].key + " -> " + table[i].value);
            }
        }
    }
}

public class DoubleKeyHashTable {
    public static void main(String[] args) {
        System.out.println("=== Хеш-таблица с вещественными ключами ===");
        
        DoubleHashTable<Double, String> table = new DoubleHashTable<>();
        
        System.out.println("\n1. Добавление элементов с вещественными ключами:");
        table.put(3.14, "Pi");
        table.put(2.718, "Euler's number");
        table.put(1.618, "Golden ratio");
        table.put(0.577, "Euler-Mascheroni constant");
        table.put(1.414, "Square root of 2");
        table.put(1.732, "Square root of 3");
        table.put(2.236, "Square root of 5");
        table.put(2.645, "Square root of 7");
        table.put(3.14159, "More precise Pi");
        table.put(2.71828, "More precise e");
        
        table.display();
        
        System.out.println("\n2. Поиск элементов:");
        System.out.println("Ключ 3.14: " + table.get(3.14));
        System.out.println("Ключ 1.618: " + table.get(1.618));
        System.out.println("Ключ 0.577: " + table.get(0.577));
        System.out.println("Ключ 5.0 (не существует): " + table.get(5.0));
        
        System.out.println("\n3. Обновление элемента:");
        table.put(3.14, "Updated Pi value");
        System.out.println("Ключ 3.14 после обновления: " + table.get(3.14));
        
        System.out.println("\n4. Удаление элемента:");
        System.out.println("Содержит ключ 1.414 перед удалением: " + table.containsKey(1.414));
        table.remove(1.414);
        System.out.println("Содержит ключ 1.414 после удаления: " + table.containsKey(1.414));
        
        table.display();
        
        System.out.println("\n5. Тестирование с целыми ключами:");
        DoubleHashTable<Integer, String> intTable = new DoubleHashTable<>();
        intTable.put(1, "One");
        intTable.put(2, "Two");
        intTable.put(3, "Three");
        intTable.put(13, "Thirteen");
        intTable.put(23, "Twenty-three");
        
        System.out.println("Ключ 13: " + intTable.get(13));
        System.out.println("Ключ 23: " + intTable.get(23));
        
        System.out.println("\n6. Тестирование со строковыми ключами:");
        DoubleHashTable<String, Double> stringTable = new DoubleHashTable<>();
        stringTable.put("temperature", 36.6);
        stringTable.put("gravity", 9.81);
        stringTable.put("speed_of_light", 299792458.0);
        
        System.out.println("Ключ 'gravity': " + stringTable.get("gravity"));
        System.out.println("Ключ 'temperature': " + stringTable.get("temperature"));
        
        System.out.println("\n7. Статистика:");
        System.out.println("Размер таблицы: " + table.size());
        System.out.println("Таблица пуста? " + table.isEmpty());
    }
}