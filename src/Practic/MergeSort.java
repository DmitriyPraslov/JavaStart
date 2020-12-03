package Practic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        Integer[] intArray1 = {8,9};
        Integer[] intArray2 = {1,2,6};
        Integer[] intArray3 = {1};
        Integer[] intArray4 = {3};
        Integer[] intArray5 = {1,4,3};
        Integer[] intArray6 = {2,3};
        Integer[] intArray7 = {1,3};
        Integer[] intArray8 = {3};

        int[] arr1 = {6,2,7,9,3,2};
        int[] arr2 = {6,4,2,7,9,3,2};
        int[] arr3 = {6,4,2,7,9};

        System.out.println(Arrays.toString(mergeSort(arr3)));
    }

    public static Integer[] mergeSort(int[] arr){
        List<Integer[]> tempArrayList = new LinkedList<>(convertArray(arr));
        while (tempArrayList.size()!=1){
            List<Integer[]> buffer = new LinkedList<>(tempArrayList);
            tempArrayList.clear();
            for (int i=0;i<buffer.size()-1;i=i+2){
                tempArrayList.add(merge(buffer.get(i), buffer.get(i+1)));
            }
            if (buffer.size()%2!=0){
                tempArrayList.add(buffer.get(buffer.size()-1));
            }
        }
        return tempArrayList.get(0);
    }

    public static List<Integer[]> convertArray (int[] arr){
        List<Integer[]> result = new LinkedList<>();
        Integer[][] buffer = new Integer[arr.length][1];
        for (int i=0;i<arr.length;i++){
            buffer[i][0]=arr[i];
        }
        for (int i=0;i<buffer.length;i++){
            result.add(buffer[i]);
        }
        return result;
    }

    public static Integer[] merge (Integer[] arr1, Integer[] arr2){
        Integer[] result = new Integer[arr1.length+arr2.length];
        int i = 0;
        int j = 0;
        boolean trigger = true;
        int min = 0;
        int max = 0;
        for (int k=0;k<result.length;k++){
            if (trigger){
                min = findMin(arr1[i],arr2[j]);
            } else {
                max = findMax(arr1[i], arr2[j]);
            }

            if ((trigger==true?min:max)==1){
                result[k]=arr1[i];
                i++;
            } else if((trigger==true?min:max)==2){
                result[k]=arr2[j];
                j++;
            } else if (min==3){
                result[k]=arr1[i];
                k++;
                result[k]=arr2[j];
                i++;
                j++;
            }

            if (i==arr1.length){
                trigger=false;
                i--;
            } else if (j==arr2.length){
                trigger=false;
                j--;
            }
        }
        return result;
    }

    public static int findMin (int element1, int element2){
        return element1==element2?3:(element1<element2?1:2);
    }
    public static int findMax (int element1, int element2){
        return element1>element2?1:2;
    }
}
