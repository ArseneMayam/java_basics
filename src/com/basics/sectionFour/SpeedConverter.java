package com.basics.sectionFour;

public class SpeedConverter {
    private static double kilometersPerHour;

    public static long toMilesPerHour(double kilometersPerHour){
        if(kilometersPerHour < 0){
         return  -1;
        }
        return Math.round(kilometersPerHour/1.609);
    }

    public static void printConversion(double kilometersPerHour){
        if(kilometersPerHour < 0){
            System.out.printf("Invalid Value");
        }else{
            System.out.println(kilometersPerHour +" km/h = " + toMilesPerHour(kilometersPerHour) + " mi/h");
        }

    }



    public static void main(String[] args){
        printConversion(75.114);
    }
}
