package com.basics.sectionEight;

import java.util.Scanner;

public class MinimumElementArray {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] numbers = readIntegers(5);
        System.out.println(findMin(numbers));
    }

    public static int[] readIntegers(int count) {
        int[] array = new int[count];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter number :");
            array[i] = scanner.nextInt();
            scanner.nextLine();
        }
        return array;
    }

    public static int findMin(int[] array) {
        int minimum = Integer.MAX_VALUE; // max number integer can hold

        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            if (value < minimum) {
                minimum = value;
            }
        }
        return minimum;
    }
}
