public class CustomListDemo {
    public static void main(String[] args) {
        System.out.println("=== Тестирование MyArrayList ===");
        
        MyArrayList<String> list = new MyArrayList<>();
        
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        
        System.out.println("Размер списка: " + list.size());
        System.out.println("Элемент по индексу 2: " + list.get(2));
        
        System.out.println("\nИтерация с использованием CustomIterator:");
        CustomIterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println("Элемент: " + element);
            if (element.equals("Three")) {
                iterator.remove();
                System.out.println("  -> Удален элемент 'Three'");
            }
        }
        
        System.out.println("\nСписок после удаления:");
        iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println("Элемент: " + iterator.next());
        }
        System.out.println("Размер списка после удаления: " + list.size());
        
        System.out.println("\n=== Тестирование с числами ===");
        MyArrayList<Integer> intList = new MyArrayList<>();
        intList.add(10);
        intList.add(20);
        intList.add(30);
        intList.add(40);
        
        CustomIterator<Integer> intIterator = intList.iterator();
        while (intIterator.hasNext()) {
            System.out.println("Число: " + intIterator.next());
        }
        
        System.out.println("\n=== Проверка на пустоту ===");
        System.out.println("Список пуст? " + list.isEmpty());
        list.clear();
        System.out.println("После clear - список пуст? " + list.isEmpty());
        
        System.out.println("\n=== Тестирование for-each (нельзя, так как не реализован Iterable) ===");
        System.out.println("Для использования for-each нужно реализовать java.lang.Iterable");
    }
}