package com.pluralsight.lambdas;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class FirstLambdas {

    public static void main(String[] args){

        // Supplier
        // its abstract method has a return type
        // creates an instance of the Supplier functional interface and implements its abstract method with a lambda expression
        // Supplier<String> supplier = () -> "Hello!"; // this returns the string
        Supplier<String> supplier = () -> {
          return  "Hello from supplier using code block!";
        };
        // Invoking the lambda
        String string = supplier.get();
        System.out.println("String = "+ string);

        // Consumer
        // its abstract method return is void
        // Creates an instance of the Consumer functional interface and implements its abstract method
        // Consumer<String> consumer2 = System.out::println;
        // Consumer<String> consumer = (String s) -> System.out.println(s);
        Consumer<String> consumer = (String s) -> {
            System.out.println(s);
            System.out.println("using the code block");
        };
        // Invoking the consumer
        consumer.accept("Hello from consumer");


    }

}
