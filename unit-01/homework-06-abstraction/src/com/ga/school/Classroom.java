package com.ga.school;

import java.util.ArrayList;

public abstract class Classroom implements IClassroom {
    private String name;
    private ArrayList<Student> studentList;
    private Teacher teacher;

    public Classroom(String name, ArrayList<Student> studentList, Teacher teacher) {
        this.name = name;
        this.studentList = studentList;
        this.teacher = teacher;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public String setName(String name) {
        return this.name = name;
    }

    @Override
    public ArrayList<Student> getStudentList() {
        return this.studentList;
    }

    public ArrayList<Student> setStudentList(ArrayList<Student> studentList) {
        return this.studentList = studentList;
    }

    @Override
    public Teacher getTeacher() {
        return this.teacher;
    }

    public Teacher setTeacher(Teacher teacher) {
        return this.teacher = teacher;
    }
}
