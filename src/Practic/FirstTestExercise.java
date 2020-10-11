package Practic;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FirstTestExercise {
    public static void main(String[] args){
        Test1 firstTry = new Test1();
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println(firstTry.test(-6));
        } catch (NoPositiveException e) {
            System.out.println("Значение меньше или равно нулю!");
            int x = -1;
            while (x<=0) {
                System.out.println("Введите положительное число");
                try {
                    x = scan.nextInt();
                } catch (InputMismatchException e2){
                    System.out.println("Вы ввели букву, введите пожалуйста число");

                }
                try{
                    firstTry.test(x);
                } catch (Exception e1){

                }
            }
        }
    }
}

class Test1 {// в цілому гарне рішення, тіки б подумав би над зменшенням кількості змінних та їх іменами
    public int test(int n) throws NoPositiveException, InputMismatchException {
        if (n<=0){
            throw new NoPositiveException("Значение меньше или равно нулю",n);
        }
        int count = n;
        int result = 0;
        int temp = n;
        for (int i=0;i<n;i++){
            count=count-(i+1);
            if (count>=0){
                result++;
                printStar(result);
                temp = temp-result;
            } else {
                break;
            }
        }
        printStar(temp);
    return result;
    }

    public void printStar(int count){
        for (int i=0;i<count;i++){
            System.out.print("*");
        }
        System.out.println();
    }
}
class NoPositiveException extends RuntimeException{
    int problemParametr;

    public NoPositiveException(String message, int problemParametr) {
        super(message);
        this.problemParametr = problemParametr;
    }
}

