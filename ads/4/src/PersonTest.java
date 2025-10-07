public class PersonTest {
    public static void main(String[] args) throws Exception {
        Person person_with_args = new Person("Максон", 19);
        Person person_no_args = new Person();

        person_no_args.move(); person_no_args.talk();
        person_with_args.move(); person_with_args.talk();

    }
}
