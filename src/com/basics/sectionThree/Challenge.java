package com.basics.sectionThree;

public class Challenge {

    public static void isThereRemainder(double firstVar, double secondVar) {
        double multiVars = (firstVar + secondVar) * 100;
        System.out.println("Multiplication results : " + multiVars);
        double isNoRemainder = multiVars % 40.00;
        System.out.println(" Remainder : " + isNoRemainder);

        boolean myBool = (isNoRemainder == 0) ? true : false;
        System.out.println("There is no remainder : " + myBool);

        if (!myBool) {
            System.out.println("Got some remainder");
        } else {
            System.out.println("There is no remainder");
        }
    }
}
