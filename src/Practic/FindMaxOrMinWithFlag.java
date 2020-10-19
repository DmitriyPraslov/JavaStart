package Practic;

import java.util.Scanner;

public class FindMaxOrMinWithFlag {
    public static void main(String[] args) {
        Scanner scanFlag = new Scanner(System.in);
        System.out.println("Введите флаг - (0 или 1)");
        int flag = scanFlag.nextInt();
        int[] newArray = {2,4,77,34,2,-1,-3,10};
        System.out.println(findMaxOrMin(newArray, flag));
    }

    public static int findMaxOrMin(int[] arr, int flag){
        int result = arr[0];
        for (int temp : arr){
            switch (flag){
                case 0 :
                    if (result>temp){
                        result = temp;
                    }
                    break;
                case 1 :
                    if (result<temp){
                        result = temp;
                    }
                    break;
            }
        }
        return result;
    }
}
