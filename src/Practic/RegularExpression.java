package Practic;

import java.util.Arrays;

public class RegularExpression {
    public static void main(String[] args) {
//        String someString = "iwsegjirgi:jgugigiu";
//        String test = "soafwuwqgpsafoihqi fsajgfiwqhug. Hfoewgi!";
//        String test1 = "0512-67-28-43";
        /*
            [abc] - a,b,c
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
            []* - от 0 до ...
            []+ - от 1 до ...
         */
//        System.out.println(test.matches("[A-Za-z \\.\\!]*"));
//        System.out.println(test1.matches("0512-[0-9]{2}-[0-9]{2}-[0-9]{2}"));
//        System.out.println(someString.indexOf("w"));
//        System.out.println(Arrays.toString(someString.split(":")));
        String[] eMail = new String[5];
        eMail[0] = "dimkin.08@gmail.com";
        eMail[1] = "qmaggsolit@nieciaco.ml";
        eMail[2] = "mwaelhachmi2@stiesy.com";
        eMail[3] = "4ashemasalahs@ramurop.tk";
        eMail[4] = "jsivaprasadmadas8@brandly.tech";
        String[] date = new String[10];
        date[0] = "02.20.2020";
        date[1] = "00.20.2020";
        date[2] = "02.00.2020";
        date[3] = "02.31.20";
        date[4] = "13.32.99";
        date[5] = "3.2.99";
        date[6] = "3.2.9";
        date[7] = "3.2.999";
        date[8] = "3.2.2356";
        date[9] = "03.02.1001";
        for (String temp : date){
            System.out.println(temp.matches("(((0*[13-9])|1[0-2])[/\\-.]((((0*[1-9])|1[0-9])|2[0-9])|3[0-1])|((0*2)[/\\-.]((((0*[1-9])|1[0-9])|2[0-9]))))[/\\-.](([\\d]{2})|(1[\\d]{3})|(20[\\d]{2})|(2100))")); // соответствие месяцев
        }
        for (String temp : eMail) {
            System.out.println(temp.matches("[a-z0-9][\\w.]*@[\\w.]+\\.\\w+"));
        }
    }
}
