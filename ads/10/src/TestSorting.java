public class TestSorting {
    public static void main(String[] args) {

    Student[] students1 = {
        new Student("Максим", 42),
        new Student("Анна", 15),
        new Student("Олег", 73),
        new Student("Ирина", 4)
    };

    Student[] students2 = {
        new Student("Дмитрий", 11),
        new Student("София", 89),
        new Student("Екатерина", 23),
        new Student("Алексей", 56),
        new Student("Мария", 34)
    };
    Student[] students = new Student[students1.length + students2.length];

    System.arraycopy(students1, 0, students, 0, students1.length);

    System.arraycopy(students2, 0, students, students1.length, students2.length);

    System.out.println("До сортировки:");
    for (Student s : students)
        System.out.println(s);

    Sorting.sort(students);

    System.out.println("\nПосле сортировки:");

    for (Student s : students)
        System.out.println(s);
    }
}