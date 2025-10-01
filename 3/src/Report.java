class Report {
    public static void generateReport(Employee[] employees) {
        for (Employee emp : employees) {
            System.out.printf(emp.fullname +" | " + emp.salary.toString() + "\n");
        }
    }
}