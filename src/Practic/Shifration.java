package Practic;

import java.util.Scanner;

public class Shifration {
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        System.out.println("Write down the word:");
        String s = scan.nextLine();
        String yourShifrLine = yourShifrLine = shifr1(s);
        Scanner deScan  = new Scanner(System.in);
        System.out.println("Write down - Y - if you want to deshifration your line");
        String deS = deScan.nextLine();
        checkInputAnswer(deS, yourShifrLine);
    }

    public static String shifr(String in){   //  First try
        String result = "";
        String etalon = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm0123456789";
        String table =  "MNBVCXZLKJHGFDSAPOIUYTREWQmnbvcxzlkjhgfdsapoiuytrewq9876543210";
        for (int i=0;i<in.length();i++){
            result = result + table.charAt(charFind(in.charAt(i), etalon));
        }
        System.out.println(result);
        return result;
    }
    public static int charFind (char letter, String line){
        int result =0;
        char[] letterArray = line.toCharArray();
        for (int i=0;i<letterArray.length;i++){
            if (letterArray[i]==letter){
                result = i;
            }
        }
        return result;
    }

    public static String shifr1(String in){    // Second try
        String etalon = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm0123456789";
        String table =  "MNBVCXZLKJHGFDSAPOIUYTREWQmnbvcxzlkjhgfdsapoiuytrewq9876543210";
        StringBuilder temp = new StringBuilder("");  // что бы не накапливать не используемых ссылок на объекты
        for (int i=0;i<in.length();i++){
            for (int j=0;j<etalon.length();j++){
                if (in.charAt(i)==etalon.charAt(j)){
                    temp.append(table.charAt(j));
                }
            }
        }
        System.out.println(temp.toString());
        return temp.toString();
    }

    public static void checkInputAnswer(String checkLetter, String yourLine){
        if (checkLetter.charAt(0)=='Y'){
            shifr1(yourLine);
        } else {
            System.out.println("The End");
        }
    }
}
