package com.pluralsight.lambdas;

import com.pluralsight.lambdas.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class SomeMapping {

    public static void main(String[] args){
        User james = new User("James");
        User kevin = new User("kevin");
        User dame = new User("dame");

        List<User> users = List.of(james,kevin,dame);
        List<String> names = new ArrayList<>();
        Function<User, String> toName = (User user) -> user.getName();

        for(User user : users){
            String name = toName.apply(user);
            names.add(name);
        }

        // create a consumer of user
        // Consumer<User> action = (User user) -> System.out.println(user);
        // users.forEach(action);
        users.forEach(user -> System.out.println(user));
        names.forEach(name -> System.out.println(name));

        //


    }
}

