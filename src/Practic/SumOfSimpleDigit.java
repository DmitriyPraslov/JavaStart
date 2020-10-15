package Practic;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfSimpleDigit {
    public static void main(String[] args) {
        Scanner scanNaturalArraySize = new Scanner(System.in);
        System.out.println("Enter your array size:");
        NaturalArray ourNatArray = new NaturalArray(scanNaturalArraySize.nextInt());
        ourNatArray.createElementsInArray();
        ourNatArray.findSumOfSimpleDigit();
//        int[] newNatArr = {2,5,8,4,6,8,9,0};
//        ourNatArray.findSumOfSimpleDigit(newNatArr);
    }
}

class NaturalArray{
    private int[] naturalArray;
    public NaturalArray(int size){
        naturalArray = new int[size];
    }

    public int getNaturalArrayLength(){
        return naturalArray.length;
    }

    public void createElementsInArray(){
        for (int i=0;i<naturalArray.length;i++){
            naturalArray[i] = i+1;
        }
    }

    public void findSumOfSimpleDigit (){               // делегирование
        findSumOfSimpleDigit(naturalArray);
    } // Делегтрование

    public void findSumOfSimpleDigit (int[] someNatArr){
        int result = 0;
        int test;
        int maxElement = findMaxElement(someNatArr);
        for (int i=0;i<someNatArr.length;i++){
            test=0;
            for (int j=1;j<=maxElement;j++){
                if (someNatArr[i]>1&&someNatArr[i]%j==0){
                    test++;
                }
            }
            if (test==2){
                result=result+someNatArr[i];
            }
        }
        System.out.println(result);
    }


    public int findMaxElement(int[] arr){
        int result=arr[0];
        for (int i=0;i<arr.length;i++){
            if (arr[i]>result){
                result = arr[i];
            }
        }
        return result;
    }
}
