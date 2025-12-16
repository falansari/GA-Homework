package com.ga.school;

import java.util.ArrayList;

public interface IClassroom {
    String getName();
    String setName();
    ArrayList<Student> getStudentList();
    ArrayList<Student> setStudentList();
    Teacher getTeacher();
    Teacher setTeacher();
}
