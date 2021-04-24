package com.basics.sectionEight;

public class ArrayTests {

    public static void main(String[] args){
        int[] numbers = {3,2,4,5,10};
        forLoopArray(numbers);
    }

    public  static void forLoopArray(int[] data){
        for(int i = 0; i < data.length ;i++){
            System.out.println("Element "+data[i]+" at index "+ i);
        }
    }
}
