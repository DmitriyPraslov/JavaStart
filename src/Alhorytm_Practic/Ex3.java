package Alhorytm_Practic;

import java.util.ArrayList;
import java.util.List;

public class Ex3 {
    public static void main(String[] args) {
        int[] arr1 = {5,-1,7,3,-6};
        int[] arr2 = {-7,13,5,-9,2};
        int[] arr3 = {8,0,10,0,4};
        FindMin f = new FindMin();
        System.out.println(f.findMin(arr1,2));
        System.out.println(f.findMin(arr2,1));
        System.out.println(f.findMin(arr3,3));
    }
}
class FindMin{
    List<Integer> findMin(int[] arr, int count){// все добре але б я перевірив би що соинт не перевищує кількість елементів масиву
        List<Integer> result = new ArrayList<>();
        List<Integer> workList = new ArrayList<>();
        for (int temp : arr){
            workList.add(temp);
        }
        for (int i=0;i<count;i++){
            int minPosition = 0;
            for (int j=0;j<workList.size();j++){
                if (workList.get(j)<workList.get(minPosition)){
                    minPosition=j;
                }
            }
            result.add(workList.get(minPosition));
            workList.remove(minPosition);
        }
        return result;
    }
}
