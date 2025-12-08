import java.util.Stack;

public class StackCalculatorTest {
    
    public static class SafeStack<T> {
        private Object[] array;
        private int top;
        private int capacity;
        
        public SafeStack(int size) {
            array = new Object[size];
            capacity = size;
            top = -1;
        }
        
        public void push(T element) {
            if (isFull()) {
                System.out.println("Ошибка: стек переполнен");
                return;
            }
            array[++top] = element;
        }
        
        @SuppressWarnings("unchecked")
        public T pop() {
            if (isEmpty()) {
                System.out.println("Ошибка: невозможно выполнить POP для пустого стека");
                return null;
            }
            return (T) array[top--];
        }
        
        @SuppressWarnings("unchecked")
        public T peek() {
            if (isEmpty()) {
                return null;
            }
            return (T) array[top];
        }
        
        public boolean isEmpty() {
            return top == -1;
        }
        
        public boolean isFull() {
            return top == capacity - 1;
        }
        
        public int size() {
            return top + 1;
        }
        
        public void clear() {
            top = -1;
        }
    }
    
    public static class SafeRPSCalculator {
        private SafeStack<Double> stack;
        
        public SafeRPSCalculator() {
            stack = new SafeStack<>(100);
        }
        
        public void processExpression(String expression) {
            stack.clear();
            
            if (expression.trim().isEmpty()) {
                System.out.println("Тест не пройден: пустой ввод");
                return;
            }
            
            String[] tokens = expression.trim().split("\\s+");
            
            for (String token : tokens) {
                if (isNumber(token)) {
                    stack.push(Double.parseDouble(token));
                } else if (isOperator(token)) {
                    if (stack.size() < 2) {
                        System.out.println("Тест не пройден: недостаточно операндов для '" + token + "'");
                        stack.clear();
                        return;
                    }
                    Double b = stack.pop();
                    Double a = stack.pop();
                    
                    if (a == null || b == null) {
                        System.out.println("Тест не пройден: ошибка при извлечении операндов");
                        stack.clear();
                        return;
                    }
                    
                    Double result = performOperation(a, b, token);
                    if (result == null || Double.isNaN(result)) {
                        stack.clear();
                        return;
                    }
                    stack.push(result);
                } else {
                    System.out.println("Тест не пройден: неверный токен '" + token + "'");
                    stack.clear();
                    return;
                }
            }
            
            if (stack.size() == 1) {
                Double result = stack.pop();
                System.out.println("Тест пройден. Результат: " + result);
            } else if (stack.isEmpty()) {
                System.out.println("Тест не пройден: стек пуст");
            } else {
                System.out.println("Тест не пройден: в стеке осталось " + stack.size() + " элементов");
                stack.clear();
            }
        }
        
        private boolean isNumber(String token) {
            try {
                Double.parseDouble(token);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        
        private boolean isOperator(String token) {
            return token.equals("+") || token.equals("-") || 
                   token.equals("*") || token.equals("/");
        }
        
        private Double performOperation(double a, double b, String operator) {
            switch (operator) {
                case "+":
                    return a + b;
                case "-":
                    return a - b;
                case "*":
                    return a * b;
                case "/":
                    if (b == 0) {
                        System.out.println("Тест не пройден: деление на ноль");
                        return null;
                    }
                    return a / b;
                default:
                    return null;
            }
        }
    }
    
    public static void main(String[] args) {
        SafeRPSCalculator calculator = new SafeRPSCalculator();
        
        System.out.println("=== Тестирование RPN калькулятора ===\n");
        
        System.out.println("Тест 1: Простое сложение (2 3 +)");
        calculator.processExpression("2 3 +");
        
        System.out.println("\nТест 2: Комплексное выражение (2 3 * 4 5 * +)");
        calculator.processExpression("2 3 * 4 5 * +");
        
        System.out.println("\nТест 3: Выражение с делением (10 2 / 3 +)");
        calculator.processExpression("10 2 / 3 +");
        
        System.out.println("\nТест 4: Недостаточно операндов (1 +)");
        calculator.processExpression("1 +");
        
        System.out.println("\nТест 5: Пустой ввод");
        calculator.processExpression("");
        
        System.out.println("\nТест 6: Деление на ноль (5 0 /)");
        calculator.processExpression("5 0 /");
        
        System.out.println("\nТест 7: Лишние числа (1 2 3 +)");
        calculator.processExpression("1 2 3 +");
        
        System.out.println("\nТест 8: Неверный оператор (2 3 ?)");
        calculator.processExpression("2 3 ?");
        
        System.out.println("\nТест 9: Много операций подряд (+ + +)");
        calculator.processExpression("+ + +");
        
        System.out.println("\nТест 10: Корректное сложное выражение (15 7 1 1 + - / 3 * 2 1 1 + + -)");
        calculator.processExpression("15 7 1 1 + - / 3 * 2 1 1 + + -");
        
        System.out.println("\n=== Тестирование безопасного стека ===");
        
        SafeStack<Integer> testStack = new SafeStack<>(3);
        
        System.out.println("\nТест 11: Переполнение стека");
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);
        testStack.push(4);
        
        System.out.println("\nТест 12: Извлечение из пустого стека");
        SafeStack<Integer> emptyStack = new SafeStack<>(5);
        emptyStack.pop();
    }
}