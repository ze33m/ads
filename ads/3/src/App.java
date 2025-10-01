public class App {
    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("Иванов Иван Иванович", 50000.0),
            new Employee("Петров Пётр Петрович", 62000.5),
            new Employee("Сидоров Сидор Сидорович", 45800.75),
            new Employee("Смирнова Анна Павловна", 73000.2)
        };
        Report.generateReport(employees);
    }
}