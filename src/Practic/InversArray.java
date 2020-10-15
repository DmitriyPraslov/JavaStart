package Practic;

import java.util.Arrays;

public class InversArray {
    public static void main(String[] args) {
        int[] someArray = {1,5,7,4,2};
        invers1(someArray);

    }
    public static int[] invers(int[] arr){
        int[] result = new int[arr.length];
        int step = 0;
        for (int i=arr.length-1;i>=0;i--){
            result[step]=arr[i];
            step++;
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void invers1 (int[] arr){
        int temp = 0;
        int iter = arr.length/2;
        int step = arr.length-1;
        for (int i=0;i<iter;i++){
            temp = arr[i];
            arr[i] = arr[step];
            arr[step]=temp;
            step--;
        }
        System.out.println(Arrays.toString(arr));
    }
}
