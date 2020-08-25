package Practic;


import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args){
        int[] arr = {1,2,3,20};
        System.out.println(Arrays.toString(sort1(arr)));
    }
    public static int[] sort(int[] mas){
        for (int j = 0; j < mas.length; j++) {
            for (int i=0; i< mas.length-1; i++){
                int temp=mas[i];
                if (mas[i]<mas[i+1]){
                    mas[i]=mas[i+1];
                    mas[i+1]=temp;
                }
            }
        }
        return mas;
    }

    public static int[] sort1(int[] mas){
       int counter = -1;
       while (counter!=0){
           counter = 0;
            for (int i = 0; i < mas.length - 1; i++) {
                int temp = mas[i];
                if (mas[i] < mas[i + 1]) {
                    mas[i] = mas[i + 1];
                    mas[i + 1] = temp;
                    counter++;
                }
            }
        }
        return mas;
    }
}
