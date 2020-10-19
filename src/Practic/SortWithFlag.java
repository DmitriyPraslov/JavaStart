package Practic;

import java.util.Arrays;
import java.util.Scanner;

public class SortWithFlag {
    public static void main(String[] args) {
        Scanner scanFlag = new Scanner(System.in);
        System.out.println("Введите флаг - (0 или 1)");
        int flag = scanFlag.nextInt();
        int[][] newArray = {{2,5,7,1,2},{7,9},{4,3,6,1}};
        sortArrayWithFlag(newArray, flag);
    }

    public static void sortArrayWithFlag (int[][] arr, int flag){
        for (int i=0;i<arr.length;i++){
            sort(arr[i], flag);
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static int[] sort(int[] mas, int flag){
        int counter = -1;
        while (counter!=0){
            counter = 0;
            for (int i = 0; i < mas.length - 1; i++) {
                switch (flag){
                    case 0 :
                    if (mas[i] > mas[i + 1]) {
                        swapElement(mas, i);
                        counter++;
                    }
                    break;
                    case 1 :
                        if (mas[i] < mas[i + 1]) {
                            swapElement(mas, i);
                            counter++;
                        }
                    break;
                }

            }
        }
        return mas;
    }

    private static void swapElement(int[] mas, int i) {
        int temp = mas[i];
        mas[i] = mas[i + 1];
        mas[i+1] = temp;
    }
}
