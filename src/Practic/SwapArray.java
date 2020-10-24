package Practic;

import java.util.Arrays;

public class SwapArray {
    public static void main(String[] args) {
        int[] arr1 = {2,5,8,3,1,7};
        int[] arr2 = {9,2,6,5,7};
        swap(arr1, arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static void swap (int[] firstArray, int[] secondArray){//все добре
        int stepCount = firstArray.length>=secondArray.length? secondArray.length : firstArray.length;
        int temp;
        for (int i=0;i<stepCount;i++){
            temp = firstArray[i];
            firstArray[i] = secondArray[i];
            secondArray[i] = temp;
        }
    }
}
