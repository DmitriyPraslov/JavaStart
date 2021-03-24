package Alhorytm_Practic;

public class Ex6 {
    public static void main(String[] args) {
        MultipleDigit m1 = new MultipleDigit();
        int[] arr = {2,4,8};
        System.out.println(m1.findMin(arr));
    }
}
class MultipleDigit{
    int findMin (int[] arr){// не розумію ваші наміри
        int result = 0;
        boolean findResultStatus = false;
        while (!findResultStatus){
            result++;
            for (int temp : arr){
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
}
