package com.geekhub.person;

import com.geekhub.course.Course;

public class PersonService {

    StudentsRepository studentsRepository = new StudentsRepository();
    LecturersRepository lecturersRepository = new LecturersRepository();

    private Person person;

    public PersonService() {
        this.person = new Person();
    }

    public String toString() {
        String toString = person.getFirstName() + " " + person.getLastName();
        return toString;
    }

    public StringBuilder getStudentsList(Course course) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < course.getIdStudents().size() - 1; i++) {
            Integer hash = course.getIdStudents().get(i);
            result.append(studentsRepository.toString(hash));
        }
        return result;
    }

    public StringBuilder getLecturersList(Course course) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < course.getIdLecturers().size() - 1; i++) {
            Integer hash = course.getIdLecturers().get(i);
            result.append(lecturersRepository.toString(hash));
        }
        return result;
    }

    public void addNewStudent(Course course, String firstName, String lastName, String contacts, String email) {
        Person student = new Person(Role.STUDENT, firstName, lastName, contacts, email);
        studentsRepository.addStudent(course, student);
    }

    public void addNewLecturer(Course course, String firstName, String lastName, String contacts, String email) {
        Person lecturer = new Person(Role.TEACHER, firstName, lastName, contacts, email);
        lecturersRepository.addLecturer(course, lecturer);
    }

    public void delStudent(Course course, String firstName, String lastName) {
        for (int i = 0; i < course.getIdStudents().size(); i++) {
            Integer hash = course.getIdStudents().get(i);
            if (studentsRepository.getStudents().get(hash).getFirstName().equals(firstName)) {
                if (studentsRepository.getStudents().get(hash).getLastName().equals(lastName)) {
                    course.getIdStudents().remove(hash);
                }
            }

        }
    }

    public Person getLecturer(Course course, int numLecturer) {
        Integer i = course.getIdLecturers().get(numLecturer);
        return lecturersRepository.getLecturers().get(i);
    }

    public void delLecturer(Course course, String firstName, String lastName) {
        for (int i = 0; i < course.getIdLecturers().size(); i++) {
            Integer hash = course.getIdLecturers().get(i);
            if (lecturersRepository.getLecturers().get(hash).getFirstName().equals(firstName)) {
                if (lecturersRepository.getLecturers().get(hash).getLastName().equals(lastName)) {
                    course.getIdLessons().remove(hash);
                }
            }
        }
    }

}