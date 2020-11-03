package Practic;

import java.util.ArrayList;
import java.util.Scanner;

public class SumNumberOfCollection {
    public static void main(String[] args){
        Scanner scanInt = new Scanner(System.in);
        System.out.println("Заполните пожалуйста коллекцию:");
        Integer element;
        ArrayList<Integer> intCollection = new ArrayList<>();
        String temp = scanInt.nextLine();
        element = toInt(temp);
        intCollection.add(element);
        while (!temp.isEmpty()){
            temp = scanInt.nextLine();
            element = toInt(temp);
            if (!temp.isEmpty()){
                intCollection.add(element);
            }
        }
        System.out.println(sum(intCollection));
    }

    public static int toInt(String str){
        int result = 0;
        if (str.length()>0){
            result = Integer.parseInt(str);
        }
        return result;
    }

    public static int sum (ArrayList<Integer> intCol){
        int result = 0;
        for (Integer temp : intCol){
            result = result + temp;
        }
        return result;
    }
}
