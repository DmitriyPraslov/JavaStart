package Practic;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] intArray = {6,2,8,9,2,5};
        int[] someArray = {1,2};
        bubbleSort(intArray);
        System.out.println(Arrays.toString(intArray));
//        System.out.println(Arrays.binarySearch(someArray, 7));  // Уже готовый метод класса Arrays
//        System.out.println(binarySearch(intArray, 0, 0, intArray.length-1)); // рекурсивный поиск
        System.out.println(binarySearch(intArray, 2)); // через цикл
    }

    public static void bubbleSort(int[] arr){
        boolean checker = false;
        while (!checker==true){
            checker=true;
            for (int i=0;i<arr.length-1;i++){
                if (arr[i]>arr[i+1]){
                    swapElement(arr, i, i+1);
                    checker=false;
                }
            }
        }
    }
    public static void swapElement(int[] arr, int firstElement, int secondElement){
        int temp = arr[firstElement];
        arr[firstElement]=arr[secondElement];
        arr[secondElement]=temp;
    }

    public static int binarySearch(int[] arr, int key, int startIndex, int endIndex){
        int result = -1;
        if (arr.length<2||key>arr[arr.length-1]||key<arr[0]){
            return result;
        }
        int middleIndex = startIndex + (endIndex-startIndex)/2;
        if (arr[middleIndex] == key){
            result = middleIndex;
            return result;
        } else if (arr[middleIndex]<key&&key>=arr[middleIndex+1]) {
            return binarySearch(arr, key, middleIndex+1, endIndex);

        } else if (arr[middleIndex]>key&&key<=arr[middleIndex-1]){
            return binarySearch(arr, key, startIndex,middleIndex-1);
        } else {
            result = -1;
        }
        return result;
    }

    public static int binarySearch (int[] arr, int key){
        int result = -1;
        if (key>arr[arr.length-1]||key<arr[0]){    // Проверка на выход искомого числа из диапазона отсортированого массива, а также проверка на длину массива
            return result;
        } else if (arr.length==1){
            return 0;
        }
        int startIndex = 0;
        int endIndex = arr.length-1;
        int mid = findMiddleIndex(startIndex, endIndex);
        while (true){
            if (key==arr[mid]){
                result=mid;
                break;
            } else if (key>arr[mid]&&key>=arr[mid+1]){
                startIndex = mid+1;
                mid = findMiddleIndex(startIndex, endIndex);
                endIndex = mid;
            } else if (key<arr[mid]&&key<=arr[mid-1]){
                endIndex = mid-1;
                mid = findMiddleIndex(startIndex, endIndex);
                startIndex = mid;
            } else {
                result = -1;     // случай когда искомое число может быть в середине массива но его там нет после выполнения всех итераций
                break;
            }
        }
        return result;
    }

    public static int findMiddleIndex (int startIndex, int endIndex){
        int middleIndex = startIndex;
            if (endIndex-startIndex==1){
                return middleIndex;
            } else {
                middleIndex = startIndex+(endIndex-startIndex)/2;
            }
        return middleIndex;
    }
}

