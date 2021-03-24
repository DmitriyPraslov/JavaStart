package Alhorytm_Practic;

public class Ex4 {
    public static void main(String[] args) {
        String[] arr = {"wrgkwo", "dq34fdsg", "24f", "kfjghq509"};
        System.out.println(findMaxSumOfElement(arr));
    }
    public static String findMaxSumOfElement(String[] arr){// все добре
        String result = "";
        int maxSum = sumElement(arr[0]);
        for (int i=0;i<arr.length;i++){
            if (sumElement(arr[i])>=maxSum){
                result = arr[i];
                maxSum = sumElement(arr[i]);
            }
        }
//        System.out.println(sumElement(result));
        return result;
    }

    public static int sumElement(String str){
        int result = 0;
        for (int i=0;i<str.length();i++){
            result += str.charAt(i);
        }
        return result;
    }
}
