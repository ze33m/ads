public class TestSorting {
    public static void main(String[] args) {
        Student[] students = {
            new Student("Максим", 42),
            new Student("Анна", 15),
            new Student("Олег", 73),
            new Student("Ирина", 4)
        };

        System.out.println("До сортировки:");
        for (Student s : students)
            System.out.println(s);

        Sorting.sort(students);

        System.out.println("\nПосле сортировки:");
        for (Student s : students)
            System.out.println(s);
    }
}