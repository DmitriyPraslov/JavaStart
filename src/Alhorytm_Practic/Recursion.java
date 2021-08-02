package Alhorytm_Practic;

import java.util.Arrays;

public class Recursion {
    public static void main(String[] args) {
//        System.out.println(findLetter("Pronounced", 'o'));
        System.out.println(findMedian1(new int[] {1,4,7,9,2,0}));
        System.out.println(findMedian2(new int[] {2,5,1,4,3}));
        System.out.println(findMedian2(new int[] {2,4,1,5}));
        System.out.println(findCountSquares(3,4));
        System.out.println(findCountSquares(2,3));
        System.out.println(findCountSquares(7,23));
    }

//    public static int findLetter (String str, char letter){
//        int result = 0;
//        if (str.matches("^[^"+letter+"]+$")){
//            return result;
//        } else {
//            result = (result+1) + findLetter(str.substring(1,str.length()),letter);
//        }
//        return result;
//    }

    public static int findMedian1 (int[] arr){  // медиана без сортировки
        int result = arr[0];
        if (arr.length<=2){
            return result;
        } else {
            result = findMedian1(Arrays.copyOfRange(arr,1,arr.length-1));
        }
        return result;
    }

    public static int findMedian2 (int[] arr){    // медиана с сортировкой
        Arrays.sort(arr);
        int result = arr[0];
        if (arr.length==1){
            return result;
        } else if(arr.length==2){
            result = (arr[0]+arr[arr.length-1])/2;
            return result;
        } else {
            result = findMedian2(Arrays.copyOfRange(arr,1,arr.length-1));
        }
        return result;
    }

    public static int findCountSquares(int a, int b){  // к-во квадратов в прямоугольнике
        int height = a<b?a:b;
        int length = b>a?b:a;
        int result;
        if (length%height == 0){
            result = length/height;
            return result;
        } else {
            result = length/height + findCountSquares(length-((length/height)*height),(length-(length/height)*height)*height);
        }
        return result;
    }
}
