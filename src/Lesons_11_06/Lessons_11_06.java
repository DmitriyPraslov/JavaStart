package Lesons_11_06;

import java.util.*;

public class Lessons_11_06 {
    public static void main(String[] args) {
        int[] arr = {-5,2,-8,-1,5,3,-9,0,4,1};
        int[] arr1 = {2,5,1,3};
//        System.out.println(Arrays.toString(findSubArr(arr)));
        System.out.println(getResult(arr1,8));

    }

    static int getResult (int[] arr, int sum){
        int result = 0;
        List<int[]> combination = getChain1(arr);
        for (int[] temp : combination){
            if (getSumArr(temp)==sum){
                result++;
                System.out.println(Arrays.toString(temp));
            }
        }
        return result;
    }


    static List<int[]> getChain1 (int[] arr){
        List<int[]> result = new ArrayList<>();
        for (int i=0;i<arr.length-1;i++){
            for (int j=i+1;j<arr.length;j++) {
                for (int k=j;k<arr.length;k++){
                    result.add(addElementInArray(arr[i],Arrays.copyOfRange(arr,j,k+1)));
                }
            }
        }
        return result;
    }

    static int[] addElementInArray(int element, int[]arr){
        int[] result = new int[arr.length+1];
        result[0]= element;
        for (int i=1;i<result.length;i++){
            result[i]=arr[i-1];
        }
        return result;
    }


    static int[] findSubArr (int[] arr){
        int result;
        int[] resultArr;
        List<int[]> combination = getChain(arr);
        result = getSumArr1(combination.get(0));
        resultArr = combination.get(0);
        for (int[] temp : combination){
            int sum = getSumArr1(temp);
            if (sum>result) {
                result = sum;
                resultArr = temp;
            }
        }
        return resultArr;
    }


    static List<int[]> getChain (int[] arr) {
        List<int[]> result = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                result.add(Arrays.copyOfRange(arr, i, j + 1));
            }
        }
        return result;
    }

    static int getSumArr1 (int[] arr){
        int result = 0;
        result = Arrays.stream(arr).sum();
        return result;
    }


    static int getSumArr (int[] arr){
        int result = 0;
        for (int temp : arr){
            result+=temp;
        }
        return result;
    }
}
