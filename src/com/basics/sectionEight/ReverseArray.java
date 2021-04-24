package com.basics.sectionEight;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args){
        int[] numbers = {1,2,3,4,5};
        reverse(numbers); // returns a new array reference
        System.out.println("Before changing reference array : "+ Arrays.toString(numbers));
        reverseArray(numbers); // changes the reference
        System.out.println("After changing reference array : "+Arrays.toString(numbers));
    }
    public static void reverse(int[] array){
        System.out.println("Initial array : "+ Arrays.toString(array));
        int[] reversed = new int[array.length];
        int index = 0;
        for(int i=array.length -1 ;i >= 0;i--){
            reversed[index] = array[i];
            index++;
        }
        System.out.println("Reversed array : "+ Arrays.toString(reversed));
    }
    public static void reverseArray(int[] array){
        int maxIndex = array.length - 1;
        int halfLength = array.length / 2;
        for(int i=0; i< halfLength; i++){
            int temp = array[i];
            array[i] = array[maxIndex -i];
            array[maxIndex - i] = temp;
        }
    }
}
