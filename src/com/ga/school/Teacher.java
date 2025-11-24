package com.ga.school;

public class Teacher extends Person{
    private String subject;

    public Teacher(String firstName, String lastName, String subject) {
        super.setFirstName(firstName);
        super.setLastName(lastName);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
