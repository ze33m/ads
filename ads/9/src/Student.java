public class Student implements Comparable<Student>{
    private String name;
    private int IDNumber;

     public Student(String name, int IDNumber) {
        this.name = name;
        this.IDNumber = IDNumber;
    }

    public String getName() {
        return name;
    }

    public int getiDNumber() {
        return IDNumber;
    }

    @Override
    public int compareTo(Student other)
    {
        return Integer.compare(this.IDNumber, other.IDNumber);
    }

    @Override
    public String toString() {
        return name + " (ID: " + IDNumber + ")";
    }

}