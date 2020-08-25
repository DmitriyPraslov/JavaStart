package Lesson14_08;

import java.util.Random;
import java.util.Scanner;

public class myFirstGame {
    public static void main(String[] args) {
        String work = random();
        makeStar(work);
        Scanner scan = new Scanner(System.in);
        int counter = 0;
        while (counter <= 10) {
            System.out.println("Введите пожалуйста букву: ");
            String letter = scan.next();
            if (letter.length() > 1) {
                System.out.println("Вы ввели больше 1 буквы!");
                counter++;
            }
            if (Character.isDigit(letter.charAt(0))){ // проверка 0-го элемента на цифру
                System.out.println("Вы ввели цифру");
                counter++;
            }
        }
    }

    private static void makeStar(String work) {
        char[] letters = work.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            letters[i] = '*';
        }
        System.out.println(letters);
    }

    private static String random() {
        String[] wordMass = {"чашка", "вилка", "автобус", "молоток", "экран", "буква"};
        Random randomayzer = new Random();
        int var1 = randomayzer.nextInt(wordMass.length - 1);
        String word = wordMass[var1];
        System.out.println(word);
        return word;
    }
}


