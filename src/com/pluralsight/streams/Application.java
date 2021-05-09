package com.pluralsight.streams;

import com.entities.Student;
import com.managers.StudentManager;

import java.util.List;

public class Application {

    public static void main(String[] args){

        List<Student> students = StudentManager.getStudents();
       // System.out.println(students.get(0).getFirstName());
        students.forEach(System.out::println);
    }
}
