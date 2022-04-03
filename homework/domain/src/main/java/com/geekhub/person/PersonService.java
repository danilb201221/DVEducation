package com.geekhub.person;

import com.geekhub.course.CourseImpl;

public class PersonService {

    StudentsRepository studentsRepository = new StudentsRepository();
    LecturersRepository lecturersRepository = new LecturersRepository();

    private PersonImpl personImpl;

    public PersonService() {
        this.personImpl = new PersonImpl();
    }

    public String toString() {
        String toString = personImpl.getFirstName() + " " + personImpl.getLastName();
        return toString;
    }

    public StringBuilder getStudentsList(CourseImpl courseImpl) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < courseImpl.getIdStudents().size() - 1; i++) {
            Integer hash = courseImpl.getIdStudents().get(i);
            result.append(studentsRepository.toString(hash));
        }
        return result;
    }

    public StringBuilder getLecturersList(CourseImpl courseImpl) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < courseImpl.getIdLecturers().size() - 1; i++) {
            Integer hash = courseImpl.getIdLecturers().get(i);
            result.append(lecturersRepository.toString(hash));
        }
        return result;
    }

    public void addNewStudent(CourseImpl courseImpl, String firstName, String lastName, String contacts, String email) {
        PersonImpl student = new PersonImpl(firstName, lastName, email, Role.STUDENT);
        studentsRepository.addStudent(courseImpl, student);
    }

    public void addNewLecturer(CourseImpl courseImpl, String firstName, String lastName, String contacts, String email) {
        PersonImpl lecturer = new PersonImpl(firstName, lastName, email, Role.TEACHER);
        lecturersRepository.addLecturer(courseImpl, lecturer);
    }

    public void deleteStudent(CourseImpl courseImpl, String firstName, String lastName) {
        for (int i = 0; i < courseImpl.getIdStudents().size(); i++) {
            Integer hash = courseImpl.getIdStudents().get(i);
            if (studentsRepository.getStudents().get(hash).getFirstName().equals(firstName)) {
                if (studentsRepository.getStudents().get(hash).getLastName().equals(lastName)) {
                    courseImpl.getIdStudents().remove(hash);
                }
            }
        }
    }

    public PersonImpl getLecturer(CourseImpl courseImpl, int numLecturer) {
        Integer i = courseImpl.getIdLecturers().get(numLecturer);
        return lecturersRepository.getLecturers().get(i);
    }

    public void deleteLecturer(CourseImpl courseImpl, String firstName, String lastName) {
        for (int i = 0; i < courseImpl.getIdLecturers().size(); i++) {
            Integer hash = courseImpl.getIdLecturers().get(i);
            if (lecturersRepository.getLecturers().get(hash).getFirstName().equals(firstName)) {
                if (lecturersRepository.getLecturers().get(hash).getLastName().equals(lastName)) {
                    courseImpl.getIdLessons().remove(hash);
                }
            }
        }
    }

}