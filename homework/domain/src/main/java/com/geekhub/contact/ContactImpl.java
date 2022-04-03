package com.geekhub.contact;

public class ContactImpl implements Contact {
    private Long id;
    private String contact;
    private Long person_id;

    public ContactImpl(String contact, Long person_id) {
        this.contact = contact;
        this.person_id = person_id;
    }

    public ContactImpl(Long id, String contact, Long person_id) {
        this.id = id;
        this.contact = contact;
        this.person_id = person_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }
}
