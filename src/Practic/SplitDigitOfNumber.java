package Practic;

import java.util.Scanner;

public class SplitDigitOfNumber {
    public static void main(String[] args) {
        Scanner scanNumber = new Scanner(System.in);
        System.out.println("Enter Number from 10 to 99 please");
        int number = scanNumber.nextInt();
        splitDigit(number);
//        System.out.printf("%d %d\n", number/10, number%10);
    }

    public static void splitDigit (int num) {
        String intToString = Integer.toString(num);
        for (int i = 0; i < intToString.length(); i++) {
            System.out.print(intToString.charAt(i) + " ");
        }
    }
}
