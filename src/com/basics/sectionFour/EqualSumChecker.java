package com.basics.sectionFour;

public class EqualSumChecker {
    public static void main(String[] args){
        System.out.println(hasEqualSum(2, 2, 8));
    }

    public static boolean hasEqualSum(int first, int second, int third){
        boolean value = false;
        int sum = first + second;
        if(sum == third)
            value = true;


        return value;
    }
}
