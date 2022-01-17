package com.geekhub.person;

import java.util.Objects;

public class Person {

    private Role role;
    private String firstName;
    private String lastName;
    private String contacts;
    private String email;

    @Override
    public String toString() {
        String toString = getFirstName() + " " + getLastName();
        return toString;
    }

    public Person() {
    }

    public Person(Role role, String firstName, String lastName, String contacts, String email) {
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contacts = contacts;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return role == person.role && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(contacts, person.contacts) && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, firstName, lastName, contacts, email);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}
