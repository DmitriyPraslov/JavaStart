package Practic;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Polindrom {
    public static void main(String[] args){
        try {
            Scanner number = new Scanner(System.in);
            System.out.println("Введите число: ");
            int numberIn = number.nextInt();
//            System.out.println("Вы ввели число: " + numberIn);
            String str = Integer.toString(numberIn);
//            System.out.println("Его длина: " + str.length());
            int[] digitMas = Int_to_array(numberIn);
//            System.out.println("Длина массива: " + digitMas.length);
//            outMassiv(digitMas);
            polindromCheck(digitMas);
            boolean end;
            end = polindromCheck(digitMas);
            if (end==true){
                System.out.println("Число полиндром!");
            }else {
                System.out.println("Число не полиндром!");
            }

        }
        catch (InputMismatchException numberIn){
            System.out.println("Что-то пошло не так!");
        }

    }
    public static boolean polindromCheck(int[] checkArr){
        boolean result = false;
        for (int r = 0; r< checkArr.length; r++ ){
            result = checkArr[r] == checkArr[checkArr.length-r-1];
            if (result == false){
                break;
            }
        }
        return result;
        }


    static int[] Int_to_array(int n){
        int j = 0;
        int len = Integer.toString(n).length();
        int[] arr = new int[len];
        while(n!=0)
        {
            arr[len-j-1] = n%10;
            n=n/10;
            j++;
        }
        return arr;
    }

    public static void outMassiv(int[] t){
        for (int temp : t ){
            System.out.print(temp+ ", ");
        }
    }
}
