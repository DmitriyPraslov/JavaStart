package Practic;

import java.util.Arrays;

public class SixthPractic {
    public static void main(String[] args) {
        SixthPractic six = new SixthPractic();
        int[][] mas1 = {{1,2},
                        {3,7,6},
                        {8,3,7,6},
                        {2,8}};
        int[][] mas2 = {{7,4,8},
                        {1,4,9},
                        {3,7,6}};
        multiplicationArrays(mas1, mas2);

    }


    public static int[][] multiplicationArrays(int[][] arr1, int[][] arr2){
        int[] minMaxLength = minMax(arr1, arr2);
        int minLength = minMaxLength[0];
        int maxLength = minMaxLength[1];
        int largeArray = minMaxLength[2];

        int[][] result = new int[maxLength][];
        for (int i=0; i<minLength; i++){
            int caunter=1;
            result[i] = new int[maxRowLength(arr1[i],arr2[i])];
            for (int j=0; j<result[i].length; j++){
                if(caunter<=minRowLength(arr1[i],arr2[i])) {
                    result[i][j] = arr1[i][j] * arr2[i][j];
                    caunter++;
                }else {
                    if (arr1[i].length>arr2[i].length){
                        result[i][j] = arr1[i][j];
                    } else {
                        result[i][j] = arr2[i][j];
                    }
                }
            }
        }
        if (largeArray==1) {
            for (int i=minLength+1; i<=maxLength;i++){
                result[i-1] = arr1[i-1];
            }
        } else if (largeArray==2) {
            for (int i=minLength+1; i<=maxLength;i++){
                result[i-1] = arr2[i-1];
            }
        }
        for (int n=0;n<result.length;n++){
            for (int t=0;t<result[n].length;t++){
                System.out.print(result[n][t]+" ");
            }
            System.out.println();
        }
        return result;
    }

    public static int maxRowLength(int[] arr1, int[] arr2){
        int result = 0;
        if (arr1.length> arr2.length){
            result = arr1.length;
        } else {
            result = arr2.length;
        }
        return result;
    }

    public static int minRowLength(int[] arr1, int[] arr2){
        int result =0;
        if (arr1.length> arr2.length) {
            result = arr2.length;
        } else {
            result = arr1.length;
        }
        return result;
    }


    public static int[] minMax(int[][] arr1, int[][] arr2){
        int[] result=new int[3];
        if (arr1.length> arr2.length){
            result[0] = arr2.length;
            result[1] = arr1.length;
            result[2] = 1;
        } else if(arr1.length< arr2.length) {
            result[0] = arr1.length;
            result[1] = arr2.length;
            result[2] = 2;
        } else {
            result[0] = arr1.length;
            result[1] = arr2.length;
            result[2] = 0;
        }
        return result;
    }
}
