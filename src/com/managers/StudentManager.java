package com.managers;

import com.entities.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    private static List<Student> list;

    private static List<Student> loadStudent(){
        list = new ArrayList<>();
        list.add(new Student(1,"Alex","Dupont"));
        list.add(new Student(2,"Lauri","Fregant"));
        list.add(new Student(3,"Nabil","Valou"));
        list.add(new Student(4,"Kamelia","Hammouche"));
        list.add(new Student(5,"Aziza","Lachheb"));
        list.add(new Student(6,"Denise","Delaville"));
        list.add(new Student(7,"Annouar","Lado"));
        list.add(new Student(8,"Monique","Gentilly"));
        list.add(new Student(9,"Alex","Dupont"));
        list.add(new Student(10,"Daniela","Allari"));
        return list;
    }

    public static List<Student> getStudents(){
        return loadStudent();
    }
}
