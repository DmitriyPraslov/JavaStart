package Alhorytm_Practic;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) {
        int[][] arr = {{2,5,3,8,7,10,4},
                       {2,4,10,23,-2,3,9},
                       {-1,4,7,0,5,11,5},
                       {1,2,3,4,5,6,7}};

        int[][] arr2 = {{1,2,8},
                        {4,3,2},
                        {7,5,-9}};
        MaxSum try1 = new MaxSum();
        try1.findMaxSumSquare(arr2);
    }
}
class MaxSum{
    Integer[][] findMaxSumSquare(int[][] arr){
        Integer[][] result = new Integer[0][0];
        List<Integer[][]> combination = buildCombination(arr);

        int squareSumElement = 0;
        for (Integer[][] temp : combination){
            if (sumElement(temp)>=squareSumElement){
                squareSumElement = sumElement(temp);
                result = temp;
            }
        }
        for (Integer[] out : result){
            System.out.println(Arrays.toString(out));
        }
        System.out.println(squareSumElement);
        return result;
    }

    int sumElement(Integer[][] arr){
        int result = 0;
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                result += arr[i][j];
            }
        }
        return result;
    }

    List<Integer[][]> buildCombination(int[][] arr){
        List<Integer[][]> result = new LinkedList<>();
        int squareStep = 2;
        int maxCountIteration = arr.length>arr[0].length?arr[0].length:arr.length;
        for (int iter=2;iter<maxCountIteration;iter++) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length - 1; j++) {
                    if (i + squareStep <= arr.length && j + squareStep <= arr[i].length) {
                        result.add(findCombination(arr, i, j, squareStep));
                    }
                }
            }
            squareStep++;
        }
        return result;
    }

    Integer[][] findCombination(int[][] arr, int rowIndex, int columnIndex, int step){
        Integer[][] result = new Integer[step][step];
        int resultRowStep=0;
        int resultColumnStep;
        for (int a=rowIndex;a<rowIndex+step;a++){
            resultColumnStep=0;
            for (int i=columnIndex;i<columnIndex+step;i++){
                result[resultRowStep][resultColumnStep] = arr[a][i];
                resultColumnStep++;
            }
            resultRowStep++;
        }
        return result;
    }
}