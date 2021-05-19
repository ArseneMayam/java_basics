package com.pluralsight.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Challenges {

    public static void main(String[] args){
        // Challenge 3
        String res = everySecondCharFunc.apply("1234567890");
        // challenge 5
        String res2 = everySecondCharacter(everySecondCharFunc,"123456789");
        // challenge 6
        Supplier<String> iLoveJava = () -> "I love Java!";
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);
    }
    // Challenge 1
    public static Runnable challenge1(){
        return () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split("");
            for(String part: parts){
                System.out.println(part);
            }
        };
    }

    // challenge 2
    public static String everySecondChar(String source){
        StringBuilder returnVal = new StringBuilder();
        for(int i =0; i< source.length(); i++){
            if(i%2 ==1){
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }

    static Function<String, String> everySecondCharFunc = s -> {
        StringBuilder returnVal = new StringBuilder();
        for(int i =0; i< s.length(); i++){
            if(i%2 ==1){
                returnVal.append(s.charAt(i));
            }
        }
        return returnVal.toString();
    };

    // challenge 4
    public static String everySecondCharacter(Function<String, String> func, String arg){
        return func.apply(arg);
    }

    // challenge 9
    public static List<String> names(){
        return Arrays.asList(
                 "amelia",
                 "olivia",
                 "emily",
                 "Isla",
                 "ava",
                 "Olivier",
                 "jack",
                 "Charlie",
                 "harry"
         );
    }

    public static void sortedNames(){
        List<String> sorted = new ArrayList<>();
        names().forEach(name -> sorted.add(name.substring(0,1).toUpperCase() + name.substring(1)) );
        //sorted.sort((s1,s2)-> s1.compareTo(s2));
        sorted.sort(String::compareTo);
        sorted.forEach(System.out::println);

    }
    public static void sortedNamesStream(){
        List<String> sorted = new ArrayList<>();
        names().stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .sorted(String::compareTo)
                .forEach(System.out::println);

        // number of names beginning with A
        long namesBeginningWithA = names().stream()
                                        .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                                        .peek(System.out::println)
                                        .filter(name -> name.startsWith("A"))
                                        .count();
    }




}
