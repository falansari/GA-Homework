package com.ga.school;

import java.util.ArrayList;

public class School {
    private String name;
    private ArrayList<Class> classes;
    private ArrayList<Teacher> teachers;

    /**
     * Initialize new school object.
     * @param name
     * @param classes
     * @param teachers
     */
    public School(String name, ArrayList<Class> classes, ArrayList<Teacher> teachers) {
        this.name = name;
        this.classes = classes;
        this.teachers = teachers;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Class> getClasses() {
        return classes;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(ArrayList<Class> classes) {
        this.classes = classes;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }
}
