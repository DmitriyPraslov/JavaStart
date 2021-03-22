package Alhorytm_Practic;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Ex7 {
    public static void main(String[] args) {
        Integer[] arr = {2,5,7,4,9,8,21,36};
        Predicate<Integer> p1 = w->w>4;
        Predicate<Integer> p2 = w->w%2==0;
        Ex7 ex7 = new Ex7();
        ex7.filter(arr, p1,p2);
    }
    public <T> void filter(T[] arr, Predicate<T>... predicateList ){
        boolean trigger;
        for (T temp : arr){
            trigger = false;
            for (Predicate<T> pTemp : predicateList) {
                if (pTemp.test(temp)) {
                    trigger = true;
                } else {
                    trigger = false;
                    break;
                }
            }
            if (trigger){
                System.out.println(temp);
            }
        }
    }
}
