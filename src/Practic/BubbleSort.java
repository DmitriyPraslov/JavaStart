package Practic;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] intArray = {6,2,8,9,2,5,3,4,9};
        bubbleSort(intArray);
        System.out.println(Arrays.toString(intArray));
    }

    public static void bubbleSort(int[] arr){
        boolean checker = false;
        while (!checker==true){
            checker=true;
            for (int i=0;i<arr.length-1;i++){
                if (arr[i]>arr[i+1]){
                    swapElement(arr, i, i+1);
                    checker=false;
                }
            }
        }
    }
    public static void swapElement(int[] arr, int firstElement, int secondElement){
        int temp = arr[firstElement];
        arr[firstElement]=arr[secondElement];
        arr[secondElement]=temp;
    }
}

