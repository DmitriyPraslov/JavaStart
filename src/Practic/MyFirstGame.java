package Practic;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MyFirstGame {
    public static void main(String[] args) {
        char[] work = random().toCharArray();
        System.out.println(work);
        char[] star = new char[work.length];
        makeStar(star);
        System.out.println(star);
        char[] starBuffer = new char [work.length];
        makeStar(starBuffer);
        Scanner scan = new Scanner(System.in);
        int counter = 0;
        while (counter < 10) {
            System.out.println("Введите пожалуйста букву: ");
            String letter = scan.next();
            if (letter.length()>1){
                System.out.println("Вы ввели больше 1 буквы!");
                counter++;
            } else if (Character.isDigit(letter.charAt(0))){
                System.out.println("Вы ввели цифру");
                counter++;
            }
            char[] temp = letter.toCharArray();
                for (int i = 0; i < work.length; i++) {
                    if (temp[0] == work[i]) {
                        star[i] = work[i];
                    }
                }
            if (Arrays.equals(star, starBuffer)){
                counter++;
            }
            System.out.println(star);
            if (Arrays.equals(star, work)){
                System.out.println("Вы молодец!");
                break;
            } else if (counter==10){
                System.out.println("Вы проиграли супер-игру!");
            }
        }
    }

    private static char[] makeStar(char[] makestar) {
        for (int i = 0; i < makestar.length; i++) {
            makestar[i] = '*';
        }
        return makestar;
    }

    private static String random() {
        String[] wordMass = {"чашка", "вилка", "автобус", "молоток", "экран", "буква"};
        Random randomayzer = new Random();
        int var1 = randomayzer.nextInt(wordMass.length - 1); // генерация случайного индекса из массива wordMass
        String word = wordMass[var1];
        return word;
    }

}


