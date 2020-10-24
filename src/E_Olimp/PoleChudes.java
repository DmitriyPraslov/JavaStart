package E_Olimp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PoleChudes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter word:");
        System.out.println(findCountStep(scan.nextLine()));

    }


    public static int findCountStep(String word){
        int result = 0;
        int iter = word.length();
        String temp;
        String[] wordArray = convertWordToStringArray(word);
        for (int i=0;i<wordArray.length;i++) {
            temp = wordArray[i];
            if (temp!="*"){
                for (int j=i;j<wordArray.length;j++) {
                    if (temp==wordArray[j]){  // не работает (( - даже когда temp == wordArray[j]
                        wordArray[j]="*";
                        iter--;
                    }
                }
                if (iter>=0){
                    result++;
                }
            }
        }
        return result;
    }

    public static String[] convertWordToStringArray(String word){
        String[] result = new String[word.length()];
        for (int i=0;i<word.length();i++){
            result[i] = Character.toString(word.charAt(i));
        }
        return result;
    }

    public static int findCountStep1(String word){
        Set<Character> charcollection = new HashSet<>();
        for (int i=0;i<word.length();i++){
            charcollection.add(word.charAt(i));
        }
        return charcollection.size();
    }
}
