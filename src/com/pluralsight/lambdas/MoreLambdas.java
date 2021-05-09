package com.pluralsight.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MoreLambdas {

    public static void main(String[] args){

        List<String> strings = new ArrayList<String>(List.of("one","two","Three","four","five"));

        Predicate<String> filter = (String string) -> string.startsWith("T");
        // Predicate<String> filter = string -> string.startsWith("T");
        // strings.removeIf(s -> s.equals("one"));
        // strings.removeIf(filter); // using the Predicate instance
        strings.removeIf(string -> string.startsWith("T")); // without instantiating the predicate

       // Consumer<String> consumer =  (String t) -> System.out.println(t);
        Consumer<String> consumer = System.out::println;
        //strings.forEach(consumer); // using the Consumer instance
        // strings.forEach(s -> System.out.println(s));
        strings.forEach(System.out::println);

    }
}
