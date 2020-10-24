package E_Olimp;

import java.util.Scanner;

public class SumProduct {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your number");
        int a,b,c;
        a = scan.nextInt();
        b = scan.nextInt();
        c = scan.nextInt();
        calc(a,b,c);
    }
    public static void calc (int grn, int kop, int count){
        int result = (grn*100+kop)*count;
        String intToString = Integer.toString(result);
        System.out.println(intToString.substring(0,intToString.length()-2)+" "+intToString.substring(intToString.length()-2,intToString.length()));
    }
}