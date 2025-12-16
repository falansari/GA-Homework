package com.ga.school;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // STUDENTS
        Student studentAliAhmed = new Student("Ali", "Ahmed", 88.3);
        Student studentAbdullaFathi = new Student("Abdulla", "Fathi", 95.05);
        Student studentFatimaAbdulla = new Student("Fatima", "Abdulla", 86.5);

        ArrayList<Student> classA1studentList = new ArrayList<>();
        classA1studentList.add(studentAliAhmed);
        classA1studentList.add(studentAbdullaFathi);
        classA1studentList.add(studentFatimaAbdulla);

        ArrayList<Student> classA2studentList = new ArrayList<>();
        classA2studentList.add(new Student("Mohammed", "Abdulla", 72.7));
        classA2studentList.add(new Student("Ali", "Akbar", 82.1));
        classA2studentList.add(new Student("Sarah", "Ahmed", 68.4));
        classA2studentList.add(new Student("Sayed", "Ali", 88.8));

        // TEACHERS
        Teacher teacherMonaAli = new Teacher("Mona", "Ali", "Arabic");
        Teacher teacherMohammedMirza = new Teacher("Mohammed", "Mirza", "English");
        Teacher teacherZainabAbdulla = new Teacher("Zainab", "Abdulla", "Math");

        // CLASSES
        Class classA1 = new Class("Class A Grade 1", classA1studentList, teacherMohammedMirza);
        Class classA2 = new Class("Class A Grade 2", classA2studentList, teacherMonaAli);

        ArrayList<Class> noorAcademyClasses = new ArrayList<>();
        noorAcademyClasses.add(classA1);
        noorAcademyClasses.add(classA2);

        ArrayList<Teacher> noorAcademyTeachers = new ArrayList<>();
        noorAcademyTeachers.add(teacherMohammedMirza);
        noorAcademyTeachers.add(teacherMonaAli);
        noorAcademyTeachers.add(teacherZainabAbdulla);

        School noorAcademy = new School("Noor Academy", noorAcademyClasses, noorAcademyTeachers);

        printSchoolInformation(noorAcademy);
    }

    protected static void printSchoolInformation(School school) {
        System.out.println("School Info:");
        System.out.println("School name: " + school.getName());
        System.out.println(" ");

        System.out.println("Teachers employed: ");
        ArrayList<Teacher> teachers = school.getTeachers();
        for (Teacher teacher : teachers) {
            System.out.print(teacher.getFirstName() + " " + teacher.getLastName() + " " + teacher.getSubject() + " teacher, ");
        }

        System.out.println(" ");
        System.out.println(" ");

        ArrayList<Class> classes = school.getClasses();
        System.out.println("Classrooms available: ");
        for (Class classroom : classes) {
            System.out.println("Class Name: " + classroom.getName());
            System.out.println("Class's Homeroom Teacher's name is " + Arrays.toString(classroom.getTeacher().getFullName()));
            System.out.println("Students of the class: ");
            for (Student student : classroom.getStudentList()) {
                System.out.printf("Student's Name: %s %s. GPA: %f", student.getFirstName(), student.getLastName(), student.getGpa());
                System.out.println(" ");
            }
            System.out.println(" ");
        }
    }
}
