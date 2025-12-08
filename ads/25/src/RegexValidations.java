import java.util.regex.*;

public class RegexValidations {
    
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ РЕГУЛЯРНЫХ ВЫРАЖЕНИЙ ===");
        
        testTask2();
        testTask3();
        testTask4();
        testTask5();
        testTask6();
        testTask7();
    }
    
    // Задание 2: Проверка строки "abcdefghijklmnopqrstuv18340"
    public static boolean isExactString(String input) {
        return input.matches("abcdefghijklmnopqrstuv18340");
    }
    
    private static void testTask2() {
        System.out.println("\n1. Проверка строки 'abcdefghijklmnopqrstuv18340':");
        String[] testCases = {
            "abcdefghijklmnopqrstuv18340",
            "abcdefghijklmnoasdfasdpqrstuv18340",
            "abcdefghijklmnopqrstuv18341",
            ""
        };
        
        for (String test : testCases) {
            System.out.println("  '" + test + "' -> " + isExactString(test));
        }
    }
    
    // Задание 3: Извлечение цен в различных валютах
    public static void extractPrices(String text) {
        String regex = "\\b(\\d+(?:\\.\\d{1,2})?)\\s+(USD|RUB|EU)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("Найденные цены:");
        while (matcher.find()) {
            System.out.println("  " + matcher.group(1) + " " + matcher.group(2));
        }
    }
    
    private static void testTask3() {
        System.out.println("\n2. Извлечение цен из текста:");
        String text = "Цены товаров: 25.98 USD, 1500 RUB, 44.50 EU, " +
                     "44 ERR, 0.004 EU, 99.99 USD, 100 RUB";
        System.out.println("Текст: " + text);
        extractPrices(text);
    }
    
    // Задание 4: Проверка цифр без знака "+"
    public static boolean hasDigitsWithoutPlus(String text) {
        Pattern pattern = Pattern.compile("\\d[^+]");
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }
    
    private static void testTask4() {
        System.out.println("\n3. Проверка цифр без знака '+':");
        String[] testCases = {
            "(1 + 8) - 9 / 4",
            "6 / 5 - 2 * 9",
            "2+2",
            "3*4",
            "5 - 6"
        };
        
        for (String test : testCases) {
            System.out.println("  '" + test + "' -> " + hasDigitsWithoutPlus(test));
        }
    }
    
    // Задание 5: Проверка даты в формате dd/mm/yyyy (1900-9999)
    public static boolean isValidDate(String date) {
        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19[0-9]{2}|[2-9][0-9]{3})$";
        
        if (!date.matches(regex)) {
            return false;
        }
        
        String[] parts = date.split("/");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        
        if (month == 2) {
            boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            if (isLeapYear) {
                return day <= 29;
            } else {
                return day <= 28;
            }
        }
        
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return day <= 30;
        }
        
        return true;
    }
    
    private static void testTask5() {
        System.out.println("\n4. Проверка дат в формате dd/mm/yyyy:");
        String[] testCases = {
            "29/02/2000",
            "30/04/2003",
            "01/01/2003",
            "29/02/2001",
            "30-04-2003",
            "1/1/1899",
            "31/04/2000",
            "32/01/2020",
            "29/02/1900",
            "28/02/1900"
        };
        
        for (String test : testCases) {
            System.out.println("  '" + test + "' -> " + isValidDate(test));
        }
    }
    
    // Задание 6: Проверка email по RFC 2822
    public static boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(regex);
    }
    
    private static void testTask6() {
        System.out.println("\n5. Проверка email адресов:");
        String[] testCases = {
            "user@example.com",
            "root@localhost",
            "myhost@@@com.ru",
            "@my.ru",
            "Julia String",
            "test.user@domain.co.uk",
            "user.name+tag@domain.org"
        };
        
        for (String test : testCases) {
            System.out.println("  '" + test + "' -> " + isValidEmail(test));
        }
    }
    
    // Задание 7: Проверка надежности пароля
    public static boolean isStrongPassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d_]{8,}$";
        return password.matches(regex);
    }
    
    private static void testTask7() {
        System.out.println("\n6. Проверка надежности пароля:");
        String[] testCases = {
            "F032_Password",
            "TrySpy1",
            "smart_pass",
            "A007",
            "StrongPass123",
            "weak",
            "12345678",
            "ABCDEFGH",
            "abcdefgh",
            "Test_1234"
        };
        
        for (String test : testCases) {
            System.out.println("  '" + test + "' -> " + isStrongPassword(test));
        }
    }
}