package Practic;

import java.util.Arrays;

public class SumDigitOfElemenArray {
    public static void main(String[] args) {
    int[] someArray = {1,2,11};
    int[][] doubleArray = {{1,2,4},{2,3}};
    sumDigit(someArray);
    sumDigit(doubleArray);
    }

    public static void sumDigit(int[] arr){
        String intToString = convertIntArrayToString(arr);
        int temp = sum(intToString);
        System.out.println(temp);
    }

    public static void sumDigit(int[][] arr){
        StringBuffer intToString = new StringBuffer();
        for (int i=0;i<arr.length;i++){
            intToString.append(convertIntArrayToString(arr[i]));
        }
        int temp = sum(intToString.toString());
        System.out.println(temp);
    }

    public static int sum (String str){
        int result = 0;
        for (int i=0;i<str.length();i++){
            result = result+Integer.parseInt(Character.toString(str.charAt(i)));
        }
        return result;
    }

    public static String convertIntArrayToString(int[] intArray){
        StringBuffer result = new StringBuffer();
        for (int i=0;i<intArray.length;i++){
            result.append(intArray[i]);
        }
        return result.toString();
    }
}
