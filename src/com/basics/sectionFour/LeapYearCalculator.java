package com.basics.sectionFour;

public class LeapYearCalculator {

    public static void main (String[] args){
        System.out.println(isLeapYear(1924));
    }

    public static boolean isLeapYear(int year){
        if(year < 1 || year > 9999)
            return false;

        boolean divisibleByFour = year % 4 == 0;
        boolean divisibleByHundred = false;
        boolean divisibleByFourHundred = false;
        if(divisibleByFour){
            System.out.println("divisible by 4 "+ year % 100);
            divisibleByHundred = year % 100 == 0;
        }
        if(divisibleByHundred){
            System.out.println("divisible by 100");
            divisibleByFourHundred = year % 400 == 0;
        }
        else{
            return true;
        }
        if(divisibleByFourHundred){
            System.out.println("divisible by 400");
            return true;
        }

        return false;
    }
}
