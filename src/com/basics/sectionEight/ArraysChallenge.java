package com.basics.sectionEight;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysChallenge {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] toBeSorted = getIntegers(5);
        int[] sorted = sortIntegers(toBeSorted);
        printArray(sorted);
    }

    public static int[] getIntegers(int capacity) {
        int[] array = new int[capacity];
        System.out.println("Enter " + capacity + " integer values: \r");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void printArray(int[] data) {
        if (data.length > 0) {
            for (int datum : data) {
                System.out.println(datum);
            }
            // how to get element index while using foreach
        }
    }

    // Descending order
    public static int[] sortIntegers(int[] data) {
        /* int[] sortedArray = new int[data.length];

       for(int i = 0; i < data.length; i++){
                sortedArray[i] = data[i];
        }*/
        int[] sortedArray = Arrays.copyOf(data, data.length);

        boolean flag = true;
        int temp;
        while (flag) {
            flag = false;
            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i] < sortedArray[i + 1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArray;
    }


}
