package E_Olimp;

import java.util.Scanner;

public class StaticSumOfDigit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число от 0 до 9:");
        findStaticSumOfDigit(scan.nextInt());
    }
    public static void findStaticSumOfDigit(int number){
        int temp = 0;
        int coutn = 0;
        for (int i=10;i<100;i++){
            temp = i*number;
            if (sumDigitOfNumber(i)==sumDigitOfNumber(temp)){
                System.out.print(i + " ");
                coutn++;
            }
        }
        System.out.println();
        System.out.println(coutn);
    }

    public static int sumDigitOfNumber(int number){
        int result = 0;
        String convertInt = Integer.toString(number);
        for (int i=0;i<convertInt.length();i++){
            result=result+Integer.parseInt(Character.toString(convertInt.charAt(i)));
        }
        return result;
    }
}
