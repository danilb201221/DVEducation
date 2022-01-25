package com.geekhub;

import com.geekhub.course.Course;
import com.geekhub.person.Person;
import com.geekhub.person.PersonService;

public class PersonConsole {

    private final ScannerHelper scannerHelper;
    private final PersonService personService;

    public PersonConsole(ScannerHelper scannerHelper, PersonService personService) {
        this.scannerHelper = scannerHelper;
        this.personService = personService;
    }

    public Person getLecturer(Course course, int numLecturer) {
        return personService.getLecturer(course, numLecturer);
    }

    public void displayStudentsList(Course course) {
        System.out.println(personService.getStudentsList(course));

    }

    public StringBuffer getLecturersList(Course course) {
        StringBuffer result = new StringBuffer();

        return result;
    }

    public void displayLecturersList(Course course) {
        System.out.println(personService.getLecturersList(course));
    }

    public void addNewStudent(Course course) {
        System.out.println("Add first name");
        String firstName = scannerHelper.getString();
        System.out.println("Add last name");
        String lastName = scannerHelper.getString();
        System.out.println("Add contacts");
        String contacts = scannerHelper.getString();
        System.out.println("Add E-Mail");
        String email = scannerHelper.getString();
        personService.addNewStudent(course, firstName, lastName, contacts, email);
    }

    public void addNewLecturer(Course course) {
        System.out.println("Add first name");
        String firstName = scannerHelper.getString();
        System.out.println("Add last name");
        String lastName = scannerHelper.getString();
        System.out.println("Add contacts");
        String contacts = scannerHelper.getString();
        System.out.println("Add E-Mail");
        String email = scannerHelper.getString();
        personService.addNewLecturer(course, firstName, lastName, contacts, email);
    }

    public void deleteStudent(Course course) {
        System.out.println("Enter first name");
        String firstName = scannerHelper.getString();
        System.out.println("Enter last name");
        String lastName = scannerHelper.getString();
        personService.delStudent(course, firstName, lastName);
    }

    public void deleteLecturer(Course course) {
        System.out.println("Enter first name");
        String firstName = scannerHelper.getString();
        System.out.println("Enter last name");
        String lastName = scannerHelper.getString();
        personService.delLecturer(course, firstName, lastName);
    }
}
