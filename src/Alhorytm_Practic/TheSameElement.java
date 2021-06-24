package Alhorytm_Practic;


import java.util.HashSet;
import java.util.Set;

public class TheSameElement {
    public static void main(String[] args) {
        int[] arr1 = {2, 6, 9, 3, 6, 1};
        int[] arr2 = {-2, 3, 4, 9, 7, 8};
        int[] arr3 = {6, 4, 9, 2, 3, -10};
        System.out.println(findTheSameElement(arr1, arr2));
    }

    static Set<Integer> findTheSameElement(int[]... arrayList) {
        Set<Integer> sameElementList = new HashSet<>();
        for (int i = 0; i < arrayList.length; i++) {
            for (int j = 0; j < arrayList[i].length; j++) {
                int flag = 0;
                for (int k = 0; k < arrayList.length; k++) {
                    for (int l = 0; l < arrayList[k].length; l++) {
                        if (arrayList[i][j] == arrayList[k][l]) {
                            flag++;
                            break;
                        }
                    }
                }
                if (flag == arrayList.length) {
                    sameElementList.add(arrayList[i][j]);
                }
            }
        }
        return sameElementList;
    }
}
