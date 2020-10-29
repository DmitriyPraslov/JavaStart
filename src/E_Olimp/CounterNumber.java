package E_Olimp;

import java.io.IOException;
import java.util.Scanner;

public class CounterNumber {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your number:");
            int num = scan.nextInt();
        System.out.println(counter(num));
        System.out.println(unevenCounter(counter(num)));
    }

    public static int counter (int number){
        StringBuffer result = new StringBuffer("");
        for (int i=0;i<number;i++){
            result.append(9);
        }
        return Integer.parseInt(result.toString());
    }

    public static int unevenCounter(int number){
        int result=0;
        for (int i=0;i<=number;i++){
            if (i%2!=0) {
                result++;
            }
        }
        return result;
    }
}
