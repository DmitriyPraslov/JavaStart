package Alhorytm_Practic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArraysWithMaxAverageLength {
    public static void main(String[] args) {
        String[] arr1 = {"fg","fq","d","p","www"};
        String[] arr2 = {"fg2","fql","d","p","ww"};
        String[] arr3 = {"fgw","f","d","p3","www"};
        findArraysWithMaxAverageLength(arr1,arr2,arr3);
    }
    static List<String[]> findArraysWithMaxAverageLength(String[]... arrayList){
        double maxAverageLength = getAverageLength(arrayList[0]);
        List<String[]> result = new LinkedList<>();
        for (String[] temp : arrayList){
            if (getAverageLength(temp)>=maxAverageLength){
                maxAverageLength=getAverageLength(temp);
                result.add(temp);
            }
        }
        for (String[] temp : arrayList){
            if (getAverageLength(temp)==maxAverageLength){
                System.out.println(Arrays.toString(temp));
                result.add(temp);
            }
        }
        return result;
    }

    static double getAverageLength(String[] arr){
        double result = 0;
        for (int i=0;i<arr.length;i++){
            result+=arr[i].length();
        }
        return result/arr.length;
    }
}
