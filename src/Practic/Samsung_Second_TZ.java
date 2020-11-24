package Practic;

import java.io.IOException;
import java.util.*;

public class Samsung_Second_TZ {
    public static void main(String[] args) throws IOException {
        TestSamsung test = new TestSamsung();
        String s1 = new String("BazABaabzaAba");
        String s2 = new String("TacoCat");
        String s3 = new String("AcZCbaBz");
        String s4 = new String("abcdefghijklmnopqrstuvwxyz");
        System.out.println(test.solution(s4));
    }
}

class TestSamsung {
    public int solution(String s) throws IOException {
        if (s.matches("[A-Za-z]*") == false) {
            throw new IOException();
        }
        int result = 200;
        StringBuffer buffer = (checkWord(s));
        System.out.println(buffer);
        String[] resultCombination;
        resultCombination = buffer.toString().split("\\|");
        for (int i=0;i<resultCombination.length;i++){
            if((checkWord(resultCombination[i])).toString().equals(resultCombination[i])){
                if (result>resultCombination[i].length()) {
                    result = resultCombination[i].length();
                    System.out.println(resultCombination[i]);
                }
            }
        }
        return result==200?-1:result;
    }

    StringBuffer checkWord (String s){
        StringBuffer buffer = new StringBuffer("");
        int bufferSizeCheck;
        for (int i=0;i<s.length();i++){
            bufferSizeCheck = buffer.length();
            for (int j=0;j<s.length();j++){
                if (Character.isUpperCase(s.charAt(i))&&Character.isLowerCase(s.charAt(j))){
                    if (s.charAt(i)==Character.toUpperCase(s.charAt(j))){
                        buffer.append(s.charAt(i));
                        break;
                    }
                } else if (Character.isLowerCase(s.charAt(i))&&Character.isUpperCase(s.charAt(j))){
                    if (s.charAt(i)==Character.toLowerCase(s.charAt(j))){
                        buffer.append(s.charAt(i));
                        break;
                    }
                }
            }
            if (bufferSizeCheck==buffer.length()){
                buffer.append("|");
            }
        }
        return buffer;
    }
}






// Пал смертью храбрых((   Запутался в собственном коде, тратил много времени на его понимание и не смог продвинуться дальше в реализации задания

//class Test {
//    public int solution (String s) throws IOException {
//        if (s.matches("[A-Za-z]*")==false){
//            throw new IOException();
//        }
//        StringBuffer result = new StringBuffer("");
//        int resultLength = 0;
//        Set<Character> balancedCharacter = new TreeSet<>();
//        int logic = 0;
//            findBalancedCharecter(s, balancedCharacter);
//            for (int i=0;i<s.length();i++){
//                logic = 0;
//                System.out.print(s.charAt(i));    /////////////////////////
//                for (Character temp : balancedCharacter){
//                    System.out.print(" " +temp+ " ");   ///////////////////
//                    if (s.charAt(i)==temp) {
//                        logic++;
//                    }
//                }
//                if (logic>0) {
//                    result.append(s.charAt(i));
//                    System.out.print(" "+result+" ");    /////////////////
//                } else {
//                    result = new StringBuffer("");
//                }
//                if (result.length()>1){
//                    resultLength=result.length();
//                }
//                System.out.println();     ////////////////////////////
//            }
//        return resultLength;
//    }
//
//    void findBalancedCharecter (String s, Set<Character> balancedCharacter){
//        balancedCharacter.clear();
//        char[] sChar = s.toCharArray();
//        for (int i=0;i<sChar.length-1;i++){
//            for (int j=0;j<sChar.length-1;j++){
//                if (Character.isUpperCase(sChar[i])&&Character.isLowerCase(sChar[j])){
//                    if (sChar[i]==Character.toUpperCase(sChar[j])){
//                        balancedCharacter.add(sChar[i]);
//                        break;
//                    }
//                } else if (Character.isLowerCase(sChar[i])&&Character.isUpperCase(sChar[j])){
//                    if (sChar[i]==Character.toLowerCase(sChar[j])){
//                        balancedCharacter.add(sChar[i]);
//                        break;
//                    }
//                }
//            }
//        }
//    }
//}