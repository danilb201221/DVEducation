package person;

import MainConsole;

public class AllLecturersRepositoryImpl implements AllLecturersRepository {

    private Person[] allLecturers;

    PersonService lecturer = new PersonServiceImpl();
    MainConsole console = new MainConsole();

    public AllLecturersRepositoryImpl() {
        this.allLecturers = new Person[100];
    }

    @Override
    public void addNewLecturer() {
        for (int i = 0; i < allLecturers.length; i++) {
            if (allLecturers[i] ==null) {
                allLecturers[i] = lecturer.addNewLecturer();
                break;
            }
        }
    }

    @Override
    public void toStringAllLecturers() {
        for (int i = 0; i < allLecturers.length; i++) {
            if ((allLecturers[i] != null)) {
                System.out.printf("%d. %s\n", (i+1), allLecturers[i].toString());
            }
        }
    }

    @Override
    public Person[] getAllLecturers() {
        return allLecturers;
    }
}
