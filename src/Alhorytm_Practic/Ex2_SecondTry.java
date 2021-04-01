package Alhorytm_Practic;

import java.util.*;

public class Ex2_SecondTry {
    public static void main(String[] args) {
        String[] arr1 = {"a","1","A","b","B"};
        String[] arr2 = {"a","b","10","B","b","10","Z"};
        BalanceString balanceString = new BalanceString();
        System.out.println(Arrays.toString(balanceString.MaxBalancedString(arr1)));
        System.out.println(Arrays.toString(balanceString.MaxBalancedString(arr2)));
    }
}
class BalanceString {
    String[] MaxBalancedString(String[] arr) {
        List<String[]> combination = builtCombination(arr);
        String[] maxLengthArray = {};
        for (String[] temp : combination) {
            if (isBalanced(temp)) {
                if (temp.length > maxLengthArray.length) {
                    maxLengthArray = temp;
                }
            }
        }
        return maxLengthArray;
    }

    List<String[]> builtCombination (String[] s){
        List<String[]> result = new LinkedList<>();
        for (int i=0;i<s.length;i++){
            for (int j=i+1;j<s.length;j++){// 
//                System.out.println(Arrays.toString(Arrays.copyOfRange(s,i,j+1)));
                result.add(Arrays.copyOfRange(s,i,j+1));// !!! 3 параметр у методі -це кількість елементів які будуть скопійовані починаючи з і 
                //тому j у циклі може змінюватися до j<s.length-(i+1) 
            }
        }
        return result;
    }

    boolean isBalanced(String[] arr){
        boolean result = false;
        Map<String,Integer> countUniqueLetter = findUniqueLetter(arr);// !!!!! ви тут скоріше рахуєте кількість для кожної букви питання до назви методу
//        System.out.println(uniqueLetter);
        int counterSuccessComparing = 0;
        for (String temp1 : countUniqueLetter.keySet()){
            if (checkByInteger(temp1,countUniqueLetter.get(temp1))){ // проверка на число и кратность 2 !!!!! ви перевіряєте на кратність і букви ?
                // можливо є сенс перевірити спочатку в мапі- буква чи цифра та потім викликати відповідний метод тоді другий фор непотрібний
                counterSuccessComparing++;
                continue;
            }
            for (String temp2 : countUniqueLetter.keySet()){
                if (checkByLetter(countUniqueLetter,temp1,temp2)){ // проверка на регистры !!!!!! багато зайвих параметрів
                    counterSuccessComparing++;
                }
            }
        }
        if (counterSuccessComparing==countUniqueLetter.size()){
            result=true;
        }
        return result;
    }

    Map<String,Integer> findUniqueLetter(String[] arr){
        Map<String,Integer> result = new HashMap<>();
        for (String temp : arr){
            Integer commonElementCount = findCommonElement(arr,temp);
            result.put(temp,commonElementCount);
        }
        return result;
    }
    Integer findCommonElement(String[] arr, String element){
        Integer result=0;
        for (String temp : arr){
            if (temp.equals(element)){
                result++;
            }
        }
        return result;
    }

    boolean checkByInteger(String value, int count){
        boolean result = false;
        if (value.matches("-?[0-9]+")){
            if (count%2==0){
                result = true;
            }
        }
        return result;
    }
    boolean checkByLetter(Map<String,Integer> countUniqueLetter, String firstElement, String secondElement){
        boolean result = false;
        if (countUniqueLetter.get(firstElement)==countUniqueLetter.get(secondElement)){
            if (Character.isLowerCase(firstElement.charAt(0)) && Character.isUpperCase(secondElement.charAt(0))){
                if (firstElement.charAt(0) == Character.toLowerCase(secondElement.charAt(0))){
                    result = true;
                }
            } else if (Character.isUpperCase(firstElement.charAt(0)) && Character.isLowerCase(secondElement.charAt(0))){
                if (firstElement.charAt(0) == Character.toUpperCase(secondElement.charAt(0))){
                    result = true;
                }
            }
        }
        return result;
    }
}
