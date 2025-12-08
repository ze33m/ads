import java.util.*;

public class HashSetToTreeSet {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        
        hashSet.add("orange");
        hashSet.add("apple");
        hashSet.add("banana");
        hashSet.add("grape");
        hashSet.add("kiwi");
        hashSet.add("mango");
        hashSet.add("pear");
        hashSet.add("cherry");
        hashSet.add("pineapple");
        hashSet.add("watermelon");
        
        System.out.println("Исходный HashSet:");
        System.out.println(hashSet);
        
        TreeSet<String> treeSet = new TreeSet<>(hashSet);
        
        System.out.println("\nПреобразованный TreeSet (отсортированный):");
        System.out.println(treeSet);
        
        System.out.println("\nПервый элемент в TreeSet: " + treeSet.first());
        System.out.println("Последний элемент в TreeSet: " + treeSet.last());
        
        System.out.println("\nЭлементы больше 'grape': " + treeSet.tailSet("grape", false));
        System.out.println("Элементы меньше 'mango': " + treeSet.headSet("mango", false));
        
        System.out.println("\nИтерация по TreeSet:");
        for (String fruit : treeSet) {
            System.out.println(fruit);
        }
    }
}