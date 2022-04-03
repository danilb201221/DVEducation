package com.geekhub;

import com.geekhub.course.CourseImpl;
import com.geekhub.person.PersonImpl;
import com.geekhub.person.PersonService;

public class PersonConsole {

    ScannerHelper scannerHelper = new ScannerHelper();
    PersonService personService = new PersonService();

    public PersonImpl getLecturer(CourseImpl courseImpl, int numLecturer) {
        return personService.getLecturer(courseImpl, numLecturer);
    }

    public void displayStudentsList(CourseImpl courseImpl) {
        System.out.println(personService.getStudentsList(courseImpl));

    }

    public StringBuffer getLecturersList(CourseImpl courseImpl) {
        StringBuffer result = new StringBuffer();

        return result;
    }

    public void displayLecturersList(CourseImpl courseImpl) {
        System.out.println(personService.getLecturersList(courseImpl));
    }

    public void addNewStudent(CourseImpl courseImpl) {
        System.out.println("Add first name");
        String firstName = scannerHelper.getString();
        System.out.println("Add last name");
        String lastName = scannerHelper.getString();
        System.out.println("Add contacts");
        String contacts = scannerHelper.getString();
        System.out.println("Add E-Mail");
        String email = scannerHelper.getString();
        personService.addNewStudent(courseImpl, firstName, lastName, contacts, email);
    }

    public void addNewLecturer(CourseImpl courseImpl) {
        System.out.println("Add first name");
        String firstName = scannerHelper.getString();
        System.out.println("Add last name");
        String lastName = scannerHelper.getString();
        System.out.println("Add contacts");
        String contacts = scannerHelper.getString();
        System.out.println("Add E-Mail");
        String email = scannerHelper.getString();
        personService.addNewLecturer(courseImpl, firstName, lastName, contacts, email);
    }

    public void deleteStudent(CourseImpl courseImpl) {
        System.out.println("Enter first name");
        String firstName = scannerHelper.getString();
        System.out.println("Enter last name");
        String lastName = scannerHelper.getString();
        personService.deleteStudent(courseImpl, firstName, lastName);
    }

    public void deleteLecturer(CourseImpl courseImpl) {
        System.out.println("Enter first name");
        String firstName = scannerHelper.getString();
        System.out.println("Enter last name");
        String lastName = scannerHelper.getString();
        personService.deleteLecturer(courseImpl, firstName, lastName);
    }
}
