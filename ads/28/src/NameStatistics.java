import java.util.*;

public class NameStatistics {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        
        map.put("Иванов", "Иван");
        map.put("Петров", "Петр");
        map.put("Сидоров", "Иван");
        map.put("Кузнецов", "Алексей");
        map.put("Смирнов", "Петр");
        map.put("Попов", "Сергей");
        map.put("Васильев", "Иван");
        map.put("Петрова", "Мария");
        map.put("Соколов", "Алексей");
        map.put("Михайлов", "Сергей");
        
        return map;
    }
    
    public static int getSameFirstNameCount(Map<String, String> map) {
        Map<String, Integer> firstNameCount = new HashMap<>();
        
        for (String firstName : map.values()) {
            firstNameCount.put(firstName, firstNameCount.getOrDefault(firstName, 0) + 1);
        }
        
        int count = 0;
        for (int value : firstNameCount.values()) {
            if (value > 1) {
                count += value;
            }
        }
        
        return count;
    }
    
    public static int getSameLastNameCount(Map<String, String> map) {
        Set<String> lastNames = new HashSet<>();
        int duplicateCount = 0;
        
        for (String lastName : map.keySet()) {
            if (!lastNames.add(lastName)) {
                duplicateCount++;
            }
        }
        
        return map.size() - lastNames.size();
    }
    
    public static void main(String[] args) {
        Map<String, String> peopleMap = createMap();
        
        System.out.println("Созданная карта (Фамилия -> Имя):");
        for (Map.Entry<String, String> entry : peopleMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        
        int sameFirstNameCount = getSameFirstNameCount(peopleMap);
        int sameLastNameCount = getSameLastNameCount(peopleMap);
        
        System.out.println("\nКоличество людей с одинаковыми именами: " + sameFirstNameCount);
        System.out.println("Количество людей с одинаковыми фамилиями: " + sameLastNameCount);
        
        System.out.println("\nДетальная статистика по именам:");
        Map<String, Integer> firstNameStats = new HashMap<>();
        for (String firstName : peopleMap.values()) {
            firstNameStats.put(firstName, firstNameStats.getOrDefault(firstName, 0) + 1);
        }
        
        for (Map.Entry<String, Integer> entry : firstNameStats.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Имя '" + entry.getKey() + "' встречается " + entry.getValue() + " раз(а)");
            }
        }
    }
}