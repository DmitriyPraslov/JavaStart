package Practic;

import java.util.Arrays;

public class RegularExpression {
    public static void main(String[] args) {
//        String someString = "iwsegjirgi:jgugigiu";
//        String test = "soafwuwqgpsafoihqi fsajgfiwqhug. Hfoewgi!";
//        String test1 = "0512-67-28-43";
        /*  [abc] - a,b,c
            [a-c] - a,b,c
            [0-9] - 0,1,2,3....9
            [0-9]{3} - 113
            [0-9]{2,4} - от 2 до 4 символов
            [0-9]{2,} - от 2-х до бесконечности
            [0-9]{,4} - от бесконечности до 4
            [.] - любой 1 символ
            [..] - любых 2 символа
            ([a-z]) | ([A-Z]) - или 1 маленькая или 1 большая
            [A-z] - ?
            [a-z]* - rejhwogkw
            [a-z]+ - минимум 1 символ должен быть
            \s - 1 пробел
            \S - один не пробел
            \w - одна буква
         */
//        System.out.println(test.matches("[A-Za-z \\.\\!]*"));
//        System.out.println(test1.matches("0512-[0-9]{2}-[0-9]{2}-[0-9]{2}"));
//        System.out.println(someString.indexOf("w"));
//        System.out.println(Arrays.toString(someString.split(":")));
        String eMail = "dimkin.08@gmail.com";
        System.out.println(eMail.matches("[a-z_\\.0-9]*"));
    }
}
