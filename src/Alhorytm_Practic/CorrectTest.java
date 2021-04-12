package Alhorytm_Practic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CorrectTest {
    public static void main(String[] args) {

        CorrectTest cr = new CorrectTest();
        Integer[] arr = {1,2,3};
        Integer[] arr1 = {5,2,8,1};
        cr.insertElement(arr,1,5);
        cr.deleteElement(arr,1);
        cr.sort33(arr1);
        cr.commonElements(arr,arr1);
    }

    <T> T[] insertElement(T[] arr, int position, T newElement) {
        T[] result = Arrays.copyOf(arr, arr.length + 1);
        for (int i = 0; i < result.length; i++) {
            if (i < position) {
                result[i] = arr[i];
            } else if (i > position) {
                result[i] = arr[i - 1];
            }

        }
        result[position] = newElement;
        System.out.println(Arrays.toString(result));
        return result;
    }

    <T> T[] deleteElement(T[] arr, int position) {
        T[] result = Arrays.copyOf(arr, arr.length - 1);
        for (int i = 0; i < result.length; i++) {
            if (i < position) {
                result[i] = arr[i];
            }else {
                result[i] = arr[i + 1];
            }
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    <T extends Comparable<T>> void sort33(T[] array) {

            int counter = 0;
            do {
                counter = 0;
                for (int i = 0; i < array.length - 1; i++) {
                    if (array[i].compareTo(array[i + 1]) > 0) {
                        T temp = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = temp;
                        counter++;
                    }
                }
            } while (counter != 0) ;
        System.out.println(Arrays.toString(array));
    }


    <T extends Comparable<T>> List<T> commonElements(T[]... arrays) {
        List<T> result = new ArrayList<>();
        boolean isCommon = true;
        for (T temp : arrays[0]) {
            for (T[] arr_temp : arrays) {
                if (!isFound(arr_temp, temp)) {
                    isCommon = false;
                    break;
                }
            }
            if (isCommon && !result.contains(temp)) {
                result.add(temp);
            }
        }
        System.out.println(result);
        return result;
    }

    private <T extends Comparable<T>> boolean isFound(T[] arr_temp, T element) {
        boolean result = false;
        for (T temp : arr_temp) {
            if (temp.compareTo(element) == 0) {
                result = true;
            }
        }
        return result;
    }
}
