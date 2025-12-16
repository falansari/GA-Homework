package com.ga.school;

import java.util.ArrayList;

public class Class extends Classroom {
    private String name;
    private ArrayList<Student> studentList;
    private Teacher teacher;

    public Class(String name, ArrayList<Student> studentList, Teacher teacher) {
        super(name, studentList, teacher);
    }

    @Override
    public String setName() {
        return name;
    }

    @Override
    public ArrayList<Student> setStudentList() {
        return studentList;
    }

    @Override
    public Teacher setTeacher() {
        return teacher;
    }
}
