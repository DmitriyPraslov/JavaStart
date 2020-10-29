package E_Olimp;

import java.util.Scanner;

public class PowNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter two number:");
        int firstNumber = scan.nextInt();
        int secondNumber = scan.nextInt();
        System.out.println(pow(firstNumber,secondNumber));
        System.out.println((int) Math.pow(firstNumber, secondNumber));
    }

    public static int pow (int number, int power){
        int result = 0;
        if (power>=1){
            result = number;
            for (int i=0;i<power-1;i++){
                result = result*number;
            }
        } else if (power==0) {
            result = 1;
        }
        return result;
    }
}
