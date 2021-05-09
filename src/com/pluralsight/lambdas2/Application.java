package com.pluralsight.lambdas2;

import java.util.function.Function;

public class Application {

    public static void main(String[] args){
        // people will be ordered according to their age using this comparator
        Comparator<Person> cmpAge =(p1,p2) -> p2.getAge() - p1.getAge();
        // compare according to firstname
        Comparator<Person> cmpFirstName =(p1,p2) -> p1.getFirstName().compareTo(p2.getFirstName());
        // compare according to lastname
        Comparator<Person> cmpLastName =(p1,p2) -> p1.getLastName().compareTo(p2.getLastName());

        //use of functions
        Function<Person,Integer> f1 = Person::getAge;
        Function<Person,String> f2 = Person::getFirstName;
        Function<Person,String> f3 = Person::getLastName;

        // Implement a comparator static method which we create and takes a function
        // Comparator<Person> cmpPerson = Comparator.comparing(f1);
        // Comparator<Person> cmpPerson = Comparator.comparing(p -> p.getAge());
        Comparator<Person> cmpPersonAge = Comparator.comparing(Person::getAge);

        Comparator<Person> cmpPersonLastName = Comparator.comparing(Person::getLastName);

        Comparator<Person> cmp = cmpPersonAge.thenComparing(cmpPersonLastName);

        Comparator<Person> cmpX = Comparator.comparing(Person::getLastName)
                                            .thenComparing(Person::getFirstName)
                                            .thenComparing(Person::getAge);






    }
}
