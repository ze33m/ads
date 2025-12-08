import java.util.Scanner;
import java.util.Stack;

public class RPSCalculator {
    private Stack<Double> stack;
    
    public RPSCalculator() {
        stack = new Stack<>();
    }
    
    public void processInput(String input) {
        if (input.trim().isEmpty()) {
            System.out.println("Ошибка: пустой ввод");
            return;
        }
        
        String[] tokens = input.trim().split("\\s+");
        
        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                if (stack.size() < 2) {
                    System.out.println("Ошибка: недостаточно операндов для операции '" + token + "'");
                    stack.clear();
                    return;
                }
                double b = stack.pop();
                double a = stack.pop();
                double result = performOperation(a, b, token);
                if (Double.isNaN(result)) {
                    stack.clear();
                    return;
                }
                stack.push(result);
            } else {
                System.out.println("Ошибка: неверный токен '" + token + "'");
                stack.clear();
                return;
            }
        }
        
        if (stack.size() == 1) {
            System.out.println("Результат: " + stack.pop());
        } else if (stack.size() > 1) {
            System.out.println("Ошибка: в стеке остались лишние числа");
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
               token.equals("*") || token.equals("/") || 
               token.equals("^");
    }
    
    private double performOperation(double a, double b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    System.out.println("Ошибка: деление на ноль");
                    return Double.NaN;
                }
                return a / b;
            case "^":
                return Math.pow(a, b);
            default:
                return Double.NaN;
        }
    }
    
    public static void main(String[] args) {
        RPSCalculator calculator = new RPSCalculator();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("RPN Калькулятор");
        System.out.println("Пример ввода: 2 3 + 4 *");
        System.out.println("Для выхода введите 'exit'");
        
        while (true) {
            System.out.print("Введите выражение: ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            
            calculator.processInput(input);
        }
        
        scanner.close();
    }
}