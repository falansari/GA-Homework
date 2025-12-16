package com.ga.school;

public class Student extends Person {
    private double gpa;
    private Class classroom;

    /**
     * Initialize new student object.
     * @param firstName
     * @param lastName
     * @param gpa
     */
    public Student(String firstName, String lastName, double gpa) {
        super.setFirstName(firstName);
        super.setLastName(lastName);
        this.gpa = gpa;
    }

    /**
     * Initialize new student object with associated classroom.
     * @param firstName
     * @param lastName
     * @param gpa
     * @param classroom
     */
    public Student(String firstName, String lastName, double gpa, Class classroom) {
        super.setFirstName(firstName);
        super.setLastName(lastName);
        this.gpa = gpa;
        this.classroom = classroom;
    }

    public double getGpa() {
        return gpa;
    }

    /**
     * Set the student's grade average.
     * @param gpa
     */
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public Class getClassroom() {
        return classroom;
    }

    public void setClassroom(Class classroom) {
        this.classroom = classroom;
    }
}
