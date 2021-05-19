package com.pluralsight.streams;

import com.entities.Student;
import com.managers.StudentManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {

        List<Student> students = StudentManager.getStudents();
        List<Integer> ints = Arrays.asList(0, 1, 2, 3, 4);

        // Patterns of creating Streams
        //
        Stream<Integer> stream1 = ints.stream();
        stream1.forEach(System.out::println);

        //
        Stream<Integer> stream2 = Stream.of(0, 1, 2, 3, 4);
        stream2.forEach(System.out::println);

        //
        Stream<String> streamOfStrings = Stream.generate(() -> "one");
        streamOfStrings.limit(5).forEach(System.out::println);

        // using unary operator
        Stream<String> streamOfStrings2 = Stream.iterate("+", s -> s + "+");
        streamOfStrings2.limit(5).forEach(System.out::println);

        // create streams of random numbers
        IntStream streamOfInt = ThreadLocalRandom.current().ints();
        streamOfInt.limit(5).forEach(System.out::println);


        // UDEMY Class
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36", "B12", "B6", "G53", "G49", "G60", "G50", "I26", "I17", "I29", "071"
        );
        List<String> gNumbers = new ArrayList<>();
/*
        someBingoNumbers.forEach(number ->{
            if(number.toUpperCase().startsWith("G")){
                gNumbers.add(number);
                System.out.println(number);
            }
        });

        gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
        gNumbers.forEach((String s) -> System.out.println(s));
*/
        someBingoNumbers
                .stream()
                .map(String::toUpperCase)  // method reference
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);

        // Intermediate and final operations
        //
        Stream<String> ioNumberStream = Stream.of("I26","I17","I29","071");
        Stream<String> inNumberStream = Stream.of("N40","N36","I26","I17","I29", "071");
        Stream<String> concatStream = Stream.concat(ioNumberStream,inNumberStream);
        System.out.println(concatStream.distinct().count());

        // FLATMAP and LAMBDA best practice
        Employee john = new Employee("John Doe",30);
        Employee jane = new Employee("John Doe",30);
        Employee jack = new Employee("John Doe",30);
        Employee snow = new Employee("John Doe",30);

        Department hr = new Department("Human Resources");
        hr.addEmployees(jane);
        hr.addEmployees(jack);
        hr.addEmployees(snow);
        Department accounting = new Department("Accounting");
        accounting.addEmployees(john);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        // use of flatmap
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        //
        List<String> sortedGNumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(Collectors.toList());

        //
        Map<Integer, List<Employee>> groupedByAge = departments.stream()
                                                                .flatMap(department -> department.getEmployees().stream())
                                                                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        // compares age of two employees and returns the younger employee
        departments.stream()
                    .flatMap(department -> department.getEmployees().stream())
                    .reduce((e1,e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                    .ifPresent(System.out::println);

        //
        Stream.of("ABC", "AC","BAA","CCCC","XY","ST")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 3;
                });
    }
}
