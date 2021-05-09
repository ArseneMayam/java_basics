package com.pluralsight.lambdas2;

import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T> {
    public int compare(T t1, T t2);

    // Below static methods are the ones we add -> REWRITE A LEGACY INTERFACE, BUILD A NEW API
//    public static Comparator<Person> comparing(Function<Person, Integer> f){
//        return (p1,p2) -> f.apply(p1) - f.apply(p2);
//    }

    // would return both INT and String because both types are comparable

//    public static Comparator<Person> comparing(Function<Person, Comparable> f){
//        return (p1,p2) -> f.apply(p1).compareTo(f.apply(p2));
//    }

    public static <U> Comparator<U> comparing(Function<U, Comparable> f){
        return (p1,p2) -> f.apply(p1).compareTo(f.apply(p2));
    }

    public default Comparator<T> thenComparing(Comparator<T> cmp){
        return (p1,p2) -> compare(p1,p2) == 0 ? cmp.compare(p1,p2) : compare(p1,p2);
    }

    public default Comparator<T> thenComparing(Function<T, Comparable> f){
        return thenComparing(comparing(f));
    }


}
