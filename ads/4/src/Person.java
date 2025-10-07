public class Person {
    private String fullname;
    private Integer age;

    public Person(String fullname, int age)
    {
        this.fullname = fullname;
        this.age = age;
    }
    
    public Person()
    {
        this.fullname = "Какой-то человек";
        this.age = 0;
    }

    public void talk()
    {
        System.out.println(this.fullname + " говорит");
    }

    public void move()
    {
        System.out.println(this.fullname + " двигается");
    }

}
