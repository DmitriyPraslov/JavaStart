package Practic;

import java.util.Arrays;

public class InversArray {
    public static void main(String[] args) {
        int[] someArray = {1,5,7,4,2};
        int[][] someDoubleArray = {{1,5,7,4,2},{2,3,6,9},{3,2,1}};
        invers(someArray);
        System.out.println(Arrays.toString(someArray));
        invers(someDoubleArray);

    }

    public static void invers (int[] arr){
        int temp = 0;
        int iter = arr.length/2;
        int step = arr.length-1;
        for (int i=0;i<iter;i++){
            temp = arr[i];
            arr[i] = arr[step];
            arr[step]=temp;
            step--;
        }
    }

    public static void invers (int[][] arr){
        for (int i=0;i< arr.length;i++){
            invers(arr[i]);
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
