package Practic;

import java.util.Arrays;

public class NinthPractic {
    public static void main(String[] args) {
        int[][] mas1 = {{1,2,5,8,2,34,5,89,21},{32,7,3,23,14,56,17,12},{11,10}};
        int[][] mas2 = {{7,4,8,2,1},{16,76,89,34,23,45,67,98,45}};
        System.out.println("Элементы которые не пересекаются: "+Arrays.toString(uniqueArraysElement(mas1, mas2)));
    }


    public static int[] uniqueArraysElement(int[][] arr1, int[][] arr2){ // на мій погляд з флагами намудріли
        int[] sameElementArray = sameElementCheck(arr1, arr2);
        System.out.println("Элементы которые совпадают: "+Arrays.toString(sameElementArray));
        int[] sumBothArrays = sumArrays(arr1, arr2);
        System.out.println("Сумма элементов двух массивов: "+Arrays.toString(sumBothArrays));
        int resultArrayLength=0;
        for (int i=0;i<sumBothArrays.length;i++){//пошук кількості неспівпадаючих елементів ускладнили на мій погляд.
            boolean indicator=false;
            for (int j=0;j<sameElementArray.length;j++){
                if (sumBothArrays[i]==sameElementArray[j]){
                    indicator = true;
                    break;
                }
            }
            if (indicator==false){
                resultArrayLength++;
            }
        }

        int step=0;
        int[] result = new int[resultArrayLength];

        for (int i=0;i<sumBothArrays.length;i++){
            boolean indicator=false;
            for (int j=0;j<sameElementArray.length;j++){
                if (sumBothArrays[i]==sameElementArray[j]){
                    indicator = true;
                    break;
                }
            }
            if (indicator==false){
                result[step]=sumBothArrays[i];
                step++;
            }
        }
        return result;
    }

    public static int[] sumArrays(int[][] mas1, int[][] mas2){ // good for you
        int[] result = new int[countElement(mas1)+countElement(mas2)];
        int iter = 0;
        for (int i=0;i<mas1.length;i++){
            for (int j=0;j<mas1[i].length;j++){
                result[iter] = mas1[i][j];
                iter++;
            }
        }
        for (int i=0;i<mas2.length;i++){
            for (int j=0;j<mas2[i].length;j++){
                result[iter] = mas2[i][j];
                iter++;
            }
        }
        return result;
    }

    public static int countElement(int[][] array){
        int result=0;
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array[i].length;j++){
                result++;
            }
        }
        return result;
    }

    public static int[] sameElementCheck(int[][] mas1, int[][] mas2){// нема перевірок на дублі
        int n=0;
        for (int i=0;i<mas1.length;i++){
            for (int j=0;j<mas1[i].length;j++){
                for (int g=0;g<mas2.length;g++){
                    for (int y=0;y<mas2[g].length;y++){
                        if (mas1[i][j]==mas2[g][y]){
                            n++;
                        }
                    }
                }
            }
        }
        int count=0;
        int[] result = new int[n];
        if (n>0) {                                                       // good for you :)
            for (int i = 0; i < mas1.length; i++) {
                for (int j = 0; j < mas1[i].length; j++) {
                    for (int g = 0; g < mas2.length; g++) {
                        for (int y = 0; y < mas2[g].length; y++) {
                            if (mas1[i][j] == mas2[g][y]) {
                                result[count] = mas1[i][j];
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
