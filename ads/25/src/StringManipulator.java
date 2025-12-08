import java.util.Scanner;
import java.util.regex.*;
import java.util.StringTokenizer;

public class StringManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== МЕНЮ РАБОТЫ СО СТРОКАМИ ===");
            System.out.println("1. Проверить строку на соответствие шаблону");
            System.out.println("2. Найти все соответствия шаблону в строке");
            System.out.println("3. Разбить строку по разделителю");
            System.out.println("4. Заменить подстроки по шаблону");
            System.out.println("5. Использовать StringTokenizer");
            System.out.println("6. Выйти");
            System.out.print("Выберите действие: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    checkPatternMatch(scanner);
                    break;
                case 2:
                    findAllMatches(scanner);
                    break;
                case 3:
                    splitString(scanner);
                    break;
                case 4:
                    replaceMatches(scanner);
                    break;
                case 5:
                    useStringTokenizer(scanner);
                    break;
                case 6:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }
    
    private static void checkPatternMatch(Scanner scanner) {
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        System.out.print("Введите регулярное выражение: ");
        String regex = scanner.nextLine();
        
        boolean matches = Pattern.matches(regex, input);
        System.out.println("Строка соответствует шаблону: " + matches);
    }
    
    private static void findAllMatches(Scanner scanner) {
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        System.out.print("Введите регулярное выражение: ");
        String regex = scanner.nextLine();
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        
        System.out.println("Найденные соответствия:");
        int count = 0;
        while (matcher.find()) {
            System.out.println("  " + matcher.group());
            count++;
        }
        System.out.println("Всего найдено: " + count);
    }
    
    private static void splitString(Scanner scanner) {
        System.out.print("Введите строку для разбиения: ");
        String input = scanner.nextLine();
        System.out.print("Введите регулярное выражение-разделитель: ");
        String regex = scanner.nextLine();
        
        Pattern pattern = Pattern.compile(regex);
        String[] parts = pattern.split(input);
        
        System.out.println("Результат разбиения:");
        for (int i = 0; i < parts.length; i++) {
            System.out.println("  Часть " + (i + 1) + ": " + parts[i]);
        }
    }
    
    private static void replaceMatches(Scanner scanner) {
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        System.out.print("Введите регулярное выражение для поиска: ");
        String regex = scanner.nextLine();
        System.out.print("Введите строку для замены: ");
        String replacement = scanner.nextLine();
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        String result = matcher.replaceAll(replacement);
        
        System.out.println("Результат замены: " + result);
    }
    
    private static void useStringTokenizer(Scanner scanner) {
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        System.out.print("Введите разделитель (Enter для пробела): ");
        String delimiter = scanner.nextLine();
        
        StringTokenizer tokenizer;
        if (delimiter.isEmpty()) {
            tokenizer = new StringTokenizer(input);
        } else {
            tokenizer = new StringTokenizer(input, delimiter);
        }
        
        System.out.println("Токены:");
        int count = 0;
        while (tokenizer.hasMoreTokens()) {
            System.out.println("  Токен " + (++count) + ": " + tokenizer.nextToken());
        }
        System.out.println("Всего токенов: " + count);
    }
}