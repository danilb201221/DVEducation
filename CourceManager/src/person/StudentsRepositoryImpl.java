package person;

import MainConsole;

public class StudentsRepositoryImpl implements StudentsRepository {

    private Person[] students;
    MainConsole console = new MainConsole();
    PersonService student = new PersonServiceImpl();

    public StudentsRepositoryImpl () {
        this.students = new Person[100];
    }

    @Override
    public void getAllStudents() {
        for (int i = 0; i < students.length; i++) {
            if ((students[i] != null)) {
                System.out.println(students[i].toString());
            } else {
                continue;
            }
        }
    }

    @Override
    public void addNewStudent() {
        for (int i = 0; i < students.length; i++) {
            if ((students[i] == null)) {
                students[i] = student.addNewStudent();
            }
        }
    }
}
