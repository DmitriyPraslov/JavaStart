package Practic;

import java.util.Arrays;

public class SecondTestExercise {
    public static void main(String[] args) {
        int[] testArray = {1,8,6,2,5,4,8,3,7};
        int[] testArray1 = {1,5,3,2};
        Test2 second = new Test2();
        second.test(testArray);
    }
}
class Test2{
    public int test(int[] height){
        int[][] resultArray = new int[arrayLength(height)][3];//виклик зайвого методу, пропоную взагалі відмовитись від цього масиву Це спростить код. Спробуйте.
        int resultArrayStep = 0;
        int minWallHeight = 0;
        for (int i=0;i<height.length-1;i++){
            int stepLength = 1;// зайва змінна , можемо використовувати j
            for (int j=i+1;j<height.length;j++){
                minWallHeight = minSide(height[i], height[j]);
                resultArray[resultArrayStep][0]=minWallHeight*stepLength;
                resultArray[resultArrayStep][1]=height[i];
                resultArray[resultArrayStep][2]=height[j];
                System.out.println(Arrays.toString(resultArray[resultArrayStep]));
                stepLength++;
                resultArrayStep++;
            }
        }
        int result = maxCapacity(resultArray);
        return result;
    }

    public int arrayLength(int[] arr){// у нас є arr.length Для чього цей метод? для 1-вимірного масиву це зайве на мій погляд.
        int result = 0;
        for (int i=arr.length-1;i>0;i--){
            for (int j=0;j<i;j++){
                result++;
            }
        }
        return result;
    }

    public int minSide(int firstSide, int secondSide){
        int result =0;
        if (firstSide>secondSide){
            result = secondSide;
        } else{
            result = firstSide;
        }
        return result;
    }
    public int maxCapacity(int[][] arr){
        int result = 0;
        int[] temp = new int[2];
        for (int i=0;i<arr.length;i++){
            if (arr[i][0]>=result){
                result=arr[i][0];
                temp[0]=arr[i][1];
                temp[1]=arr[i][2];
            }
        }
        System.out.println("Максимальное к-во жидкости составляет: "+result);
        System.out.println("Стороны: "+temp[0]+" и "+temp[1]);
        return result;
    }
}
