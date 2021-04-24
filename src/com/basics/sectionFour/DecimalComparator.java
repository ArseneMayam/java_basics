package com.basics.sectionFour;

public class DecimalComparator {

    public static void main(String[] args){
        System.out.println(areEqualByThreeDecimalPlaces(3.1756,3.175));
    }

    public static boolean areEqualByThreeDecimalPlaces(double number, double secondNumber){
        boolean value = false;
        number = number *1000;
        secondNumber = secondNumber *1000;
        int a = (int) number;
        int b = (int) secondNumber;

        if(a == b)
            value = true;

        return value;
    }

}
