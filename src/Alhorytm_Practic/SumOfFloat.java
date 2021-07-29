package Alhorytm_Practic;

public class SumOfFloat {
    public static void main(String[] args) {
        float[] arr = {1.12f, 2.124f, -3.015f, 8.13f, 7.26f};
        System.out.println(findMaxSumOfFloat(arr));
    }
    public static float findMaxSumOfFloat (float[] arr){
        float result = 0;
        int maxSum = getSum(arr[0]);
        for (int i=1;i<arr.length;i++){
            if (getSum(arr[i])>maxSum){
                result = arr[i];
            }
        }
        return result;
    }

    public static int getSum (float element){
        int result = 0;
        StringBuffer temp = new StringBuffer("");
        String stringDigitWOPoint = (deletePoint(element));
        for (int i=0;i<stringDigitWOPoint.length();i++){
            if (stringDigitWOPoint.charAt(i)=='-'){
                temp.append(stringDigitWOPoint.charAt(i));
            } else {
                temp.append(stringDigitWOPoint.charAt(i));
                result+=Integer.parseInt(temp.toString());
                temp.setLength(0);
            }
        }
        System.out.println(result);
        return result;
    }

    public static String deletePoint (float digit){
        String stringOfDigit = Float.toString(digit);
        StringBuffer result = new StringBuffer("");
        for (int i=0;i<stringOfDigit.length();i++){
            if (stringOfDigit.charAt(i)=='.'){
                continue;
            } else {
                result.append(stringOfDigit.charAt(i));
            }
        }
        return result.toString();
    }
}
