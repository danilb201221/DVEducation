package person;

import MainConsole;

public class LecturersRepositoryImpl implements LecturersRepository {

    AllLecturersRepository allLecturersRepository = new AllLecturersRepositoryImpl();
    MainConsole console = new MainConsole();

    private Person[] lecturers;

    public LecturersRepositoryImpl() {
        this.lecturers = new Person[20];
    }

    @Override
    public void printAllLecturers() {
        for (int i = 0; i < lecturers.length; i++) {
            if ((lecturers[i] != null)) {
                System.out.printf("%d. ", (i+1));
                lecturers[i].toString();
            }
        }
    }

    @Override
    public Person addLecturerFromList() {
        allLecturersRepository.toStringAllLecturers();
        System.out.println("Choose lecturer");
        int num = console.getInt();
        Person lecturer = allLecturersRepository.getAllLecturers()[num-1];
        return lecturer;
    }
}
