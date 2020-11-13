package Practic;

import java.util.Arrays;

public class StringSort {
    public static void main(String[] args) {
        String str = "Мама мыла раму";
        str = sort(str);
        System.out.println(str);
    }

    public static String sort(String string){
        char[] charArray = string.toCharArray();
        int counter = -1;
        while (counter!=0) {
            counter = 0;
            for (int i=0;i<charArray.length-1;i++) {
                if (charArray[i]>charArray[i+1]){
                    swapElement(charArray, i);
                    counter++;
                }
            }
        }
        string = String.copyValueOf(charArray);
        return string;
    }

    public static void swapElement(char[] chArr, int index){
        char temp = chArr[index+1];
        chArr[index+1] = chArr[index];
        chArr[index] = temp;
    }
}
