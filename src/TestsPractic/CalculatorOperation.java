package TestsPractic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CalculatorOperation {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
//        int a = -4;
//        int b = -2;
//        System.out.println(calc.sum(a,b));
//        System.out.println(calc.subtraction1(a,b));
//        System.out.println(calc.multiplication(a,b));
//        try {
//            System.out.println(calc.division(a,b));
//        } catch (ArithmeticException e) {
//            System.out.println("Нельзя делить на ноль!");
//        }
        System.out.println(calc.chainResult(new int[]{-1,4,5,-7,21,0,1,-2}));
        System.out.println(calc.findMin(1,11));
    }
}

class Calculator {
    int sum(int a, int b) {
        int result;
        result = a + b;
        return result;
    }

    int subtraction(int a, int b) {
        int result;
        result = a + (-b);
        return result;
    }

    int subtraction1(int a, int b) {
        int result;
        int step = 0;
        while (true){
            if (((a<b?a:b)+step)==(a>b?a:b)){
                result = step;
                break;
            }
            step++;
        }
        return a<b?-result:result;
    }

    int multiplication(int a, int b) {
        int result = 0;
        for (int i = 1; i <= Math.abs(b); i++) {
            result += Math.abs(a);
        }
        return (a > 0 && b > 0) || (a < 0 && b < 0) ? result : -result;
    }

    int division(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        int result = 0;
        for (int i = Math.abs(b); i <= Math.abs(a); i += Math.abs(b)) {
            result++;
        }
        return (a > 0 && b > 0) || (a < 0 && b < 0) ? result : -result;
    }

    List<Integer> chainResult (int[] arr){
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> resultCombination = generateChain(arr);
        int maxSum = 0;
        for (List<Integer> temp : resultCombination){
            int sum = sumList(temp);
            if (sum>maxSum){
                maxSum = sum;
                result = temp;
            }
        }
        return result;
    }

    private List<List<Integer>> generateChain(int[] arr) {
        List<List<Integer>> result = new LinkedList<>();
        for (int i=0;i<arr.length;i++){
            List<Integer> temp;
            if (arr[i]<0){
                continue;
            }
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<0){
                    break;
                }
                temp = Arrays.asList(Arrays.stream(Arrays.copyOfRange(arr,i,j+1)).boxed().toArray(Integer[]::new));
                result.add(temp);
            }
        }
        return result;
    }

    private int sumList(List<Integer> list) {
        int result=0;
        for (Integer temp : list){
            result += temp;
        }
        return result;
    }

    int findMin (int start, int end){
        int result = 0;
        List<Integer> range = rangeForm(start,end);
        boolean findResultStatus = false;
        while (!findResultStatus){
            result++;
            for (Integer temp : range){
                if (result%temp==0){
                    findResultStatus = true;
                } else {
                    findResultStatus = false;
                    break;
                }
            }
        }
        return result;
    }

    private List<Integer> rangeForm(int start, int end) {
        List<Integer> result = new ArrayList<>();
        for (int i=start;i<=end;i++){
            result.add(i);
        }
        return result;
    }
}