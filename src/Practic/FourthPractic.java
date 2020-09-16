package Practic;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class FourthPractic {
    public static void main(String[] args){
        FourthPractic firstCheck = new FourthPractic();
        int[][] mas1 = {{1,2,5,8,2,34,5,89,21},{32,7,3,23,14,56,17,12},{11,10}};
        int[][] mas2 = {{7,4,8,2,1},{16,76,89,34,23,45,67,98,45}};
        firstCheck.arrayCheck2(mas1, mas2);
        System.out.println(Arrays.toString(firstCheck.arrayCheck1(mas1,mas2)));

    }
    public int[] arrayCheck1(int[][] arr1, int[][] arr2){ // Пятая практическая
        int i,j,n;
        int[][] temp = new int[arrayLength(arr2)][2];
        int counterTemp = 0;
        for (i=0;i< arr2.length;i++){
            for(j=0;j<arr2[i].length;j++){
                n = findDigitInSecondArray(arr1, arr2[i][j]);
                if (n>0){
                    temp[counterTemp][0]= arr2[i][j];
                    temp[counterTemp][1] = n;
                    counterTemp++;
                }
            }
        }
        int value=0;
        for (int k=0;k<temp.length;k++){
            value=temp[k][0];
            for (int l=k+1;l<temp.length;l++){
                if (value==temp[l][0]){
                    temp[l][1]*=-1;
                }
            }
        }
        int t =0;
        for (int g=0;g<temp.length;g++){
            if (temp[g][1]>0){
                t++;
            }
        }
        int[] result = new int[t];
        for (int f=0; f<temp.length; f++){
            if (temp[f][1]>0){
                result[f] = temp[f][0];
            }
        }
        return result;
    }

    public int arrayLength(int[][] arr){
        int n=0;
        for (int i=0; i<arr.length;i++){
            for (int j =0;j<arr[i].length;j++){
                n++;
            }
        }
        return n;
    }

    private int findDigitInSecondArray(int[][] arr1, int element) {
        int result=0;
        for (int k=0; k< arr1.length; k++){
            for (int l=0; l< arr1[k].length; l++){
                if (arr1[k][l]== element){
                    result++;
                }
            }
        }
        return result;
    }

    public int[][] arrayCheck2(int[][] arr1, int[][] arr2) { // Четвертая практическая, моя реализация
        int n = 0;
        for (int[] temp1 : arr1){
            for (int temp2 : temp1){
                for (int[] temp3 : arr2) {
                    for (int temp4 : temp3) {
                        if (temp4 == temp2) {
                            System.out.print(temp4 + " ");
                            n++;
                        }
                    }
                }
            }
        }
        System.out.println();
        if (n==0){
            System.out.println("Пересечений нет!");
        }
    return arr1;
    }
    public int[][] arrayCheck3(int[][] arr1, int[][] arr2){ // Четвертая практическая 2-й способ (не мой)
        for (int[] temp1 : arr1){
            for (int[] temp2 : arr2){
                commonElements1(temp1,temp2);
            }
        }
        return arr1;
    }
    public int[][] arrayCheck4(int[][] arr1, int[][] arr2){ // Четвертая практическая 3-й способ (не мой)
        for (int[] temp1 : arr1){
            for (int[] temp2 : arr2){
                commonElements2(temp1,temp2);
            }
        }
        return arr1;
    }



    /*--------------------------------------------------------------------------------------------*/

    void commonElements1(int[] arr1,int[] arr2){
        Set<Integer> collection = new TreeSet<>();
        for (int temp:arr1 ) {
            collection.add(temp);
        }
        for (int temp: collection) {
            if(findElement(arr2,temp)){
                System.out.print(temp + " ");
            }
        }
    }
    private boolean findElement(int[] arr, int element) {
        boolean result=false;
        for (int temp:arr ) {
            if(element==temp){
                result=true;
                break;
            }
        }
        return result;
    }


    void commonElements2(int[] arr1,int[] arr2){
        Arrays.stream(arr1).distinct().forEach(w->{
            int counter=0;
            for (int temp :arr2 ) {
                if(w==temp){
                    counter++;
                }
            }
            if(counter>0){
                System.out.print(w + " ");
            }
        });
    }
}
