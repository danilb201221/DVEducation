package person;

import MainConsole;

public class PersonServiceImpl implements PersonService {

    MainConsole console = new MainConsole();

    private Person person;

    public PersonServiceImpl() {
        this.person = new Person();
    }

    public String toString() {
        String toString = person.getFirstName() + " " + person.getLastName();
        return toString;
    }

    @Override
    public Person addNewStudent() {
        System.out.println("Add first name");
        String firstName = console.getString();

        System.out.println("Add last name");
        String lastName = console.getString();

        System.out.println("Add contacts");
        String contacts = console.getString();

        System.out.println("Add E-Mail");
        String email = console.getString();

        Person student = new Person(Role.STUDENT, firstName, lastName, contacts, email);
        return student;
    }

    @Override
    public Person addNewLecturer() {
        System.out.println("Add first name");
        String firstName = console.getString();

        System.out.println("Add last name");
        String lastName = console.getString();

        System.out.println("Add contacts");
        String contacts = console.getString();

        System.out.println("Add E-Mail");
        String email = console.getString();

        Person lecturer = new Person(Role.TEACHER, firstName, lastName, contacts, email);
        return lecturer;
    }

    public void printInfoStudent(Person person) {
        System.out.printf("Student %s %s\n"
            + "E-Mail: %s\n"
            + "Contacts: %s\n", person.getFirstName(), person.getLastName(), person.getEmail(), person.getContacts());
    }

    public void printInfoLecturer(Person person) {
        System.out.printf("Lecturer %s %s\n"
            + "E-Mail: %s\n"
            + "Contacts: %s\n", person.getFirstName(), person.getLastName(), person.getEmail(), person.getContacts());
    }
}
