package com.ga.school;

public class Person {
    private String firstName;
    private String lastName;

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

    /**
     * Get person's first name and last name as array of strings.
     * @return String[firstName, lastName]
     */
    public String[] getFullName() {
        return new String[]{firstName, lastName};
    }
}
