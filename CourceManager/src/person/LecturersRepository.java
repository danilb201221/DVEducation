package person;

import person.Person;

public interface LecturersRepository {
    void printAllLecturers();

    Person addLecturerFromList();
}
