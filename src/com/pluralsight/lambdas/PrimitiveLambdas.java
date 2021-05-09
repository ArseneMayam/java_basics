package com.pluralsight.lambdas;

import java.util.function.DoubleToIntFunction;
import java.util.function.IntSupplier;

public class PrimitiveLambdas {

    public static void main(String[] args){

        IntSupplier supplier = () -> 10;
        int i = supplier.getAsInt();
        System.out.println("i = "+ i);

        // takes a double and returns an int
        DoubleToIntFunction function = value -> (int) Math.floor(value);
        int b = function.applyAsInt(Math.PI);
        System.out.println("b = "+ b);
    }
}
