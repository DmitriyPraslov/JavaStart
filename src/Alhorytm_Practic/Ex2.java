package Alhorytm_Practic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Ex2 {
    public static void main(String[] args) {
        String[] arr1 = {"a","1","A","b","B"};
        String[] arr2 = {"a","b","1","B","b","1","Z"};
        FindBalance f = new FindBalance();
        System.out.println(Arrays.toString(f.findMaxBalancedString(arr1)));
        System.out.println(Arrays.toString(f.findMaxBalancedString(arr2)));
    }
}

class FindBalance{
    String[] findMaxBalancedString(String[] arr){
        List<String[]> combination = builtCombination(arr); // тут ваші наміри зрозумілі
//        for (String[] temp : combination){
//            System.out.println(Arrays.toString(temp));
//        }
        String[] maxLengthArray = {};
        for (String[] temp : combination){
            if (checkArray(temp)){// тут ваші наміри зрозумілі
                if (temp.length>maxLengthArray.length){
                    maxLengthArray = temp;
                }
            }
        }
        return maxLengthArray;
    }

    List<String[]> builtCombination (String[] s){// тут з намірами все добре, я вас розумію
        List<String[]> result = new LinkedList<>();
        for (int i=0;i<s.length;i++){
            for (int j=i+1;j<s.length;j++){
                result.add(Arrays.copyOfRange(s,i,j+1));
            }
        }
        return result;
    }

    boolean checkArray(String[] arr){// а тут я вас зовсім не розумію, вашу реалізацію
        boolean result = false;
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {// для чого цикл з лічильником який повністю співпадає з зовнішнім циклом
                if (checkIntegerInArray(arr,arr[i],arr[j])){// тут достатньо 2-х параметрів масив та індекс чи я чогось упустив
                    // код читається дуже тяжко, треба рефакторити
                    counter++;
                    break;
                } else if (Character.isUpperCase(arr[i].charAt(0)) && Character.isLowerCase(arr[j].charAt(0))) {
                    if (arr[i].charAt(0) == Character.toUpperCase(arr[j].charAt(0)) && countElement(arr,arr[i])==countElement(arr,arr[j])) {
                        counter++;
                        break;
                    }
                } else if (Character.isLowerCase(arr[i].charAt(0)) && Character.isUpperCase(arr[j].charAt(0))) {
                    if (arr[i].charAt(0) == Character.toLowerCase(arr[j].charAt(0)) && countElement(arr,arr[i])==countElement(arr,arr[j])) {
                        counter++;
                        break;
                    }
                }
            }
        }
        if (arr.length==counter){
            result = true;
        }
        return result;
    }

    boolean checkIntegerInArray(String[] arr, String firstElement, String secondElement){// а тут я вас зовсім не розумію, вашу реалізацію
        boolean result = false;
        int countInteger = 0;
        if (firstElement.matches("-?[0-9]+") && secondElement.matches("-?[0-9]+")){
            for (int i=0;i<arr.length;i++){
                if (arr[i].matches("-?[0-9]+") && Integer.parseInt(arr[i])==Integer.parseInt(firstElement)){
                    countInteger++;
                }
            }
            if (Integer.parseInt(firstElement)==Integer.parseInt(secondElement) && countInteger%2==0){
                result=true;
                return result;
            }
        }
        return result;
    }

    int countElement(String[] arr, String element){
        int result = 0;
        for (int a=0;a<arr.length;a++){
            if (arr[a]==element){
                result++;
            }
        }
        return result;
    }
}
