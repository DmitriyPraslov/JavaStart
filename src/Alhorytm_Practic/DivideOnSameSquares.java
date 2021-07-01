package Alhorytm_Practic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DivideOnSameSquares {
    public static void main(String[] args) {
        findCountSameSquares(2,4);
    }
    static int findCountSameSquares (int a, int b){
        int result = 0;
        if(a==b||(a<=0||b<=0)){
            return result;
        }
        int[][] rectangle = buildRectangle(a,b);
//        for (int[] temp : rectangle){
//            System.out.println(Arrays.toString(temp));
//        }
        List<Integer[][]> squaresList = new LinkedList<>();
        int rectangleSpace = a*b;  // площадь прямоугольника
        squaresList = buildSquares(rectangle); // генерация квадратов
        int countIteration = calculateCountTypeSquares(squaresList);  // подсчёт груп квадратов с разными сторонами
        for (int i=1;i<=countIteration;i++){
            int sumAllSquaresSpace = 0;
            result = 0;
            for (Integer[][] temp : squaresList){
                if (temp.length-1==i){
                    sumAllSquaresSpace += countSpace(temp);
                    result++;
                }
            }
            if (sumAllSquaresSpace==rectangleSpace){
                System.out.println("Число квадратов: "+result + " Со сторонами: "+ i);
            }
        }
//        for (Integer[][] temp : squaresList) {
//            for (Integer[] tem : temp){
//                System.out.println(Arrays.toString(tem));
//            }
//            System.out.println("-------------------");
//        }
        return result;
    }
    static int[][] buildRectangle (int a, int b){
        int counter = 0;
        int[][] result = new int[a+1][b+1];
        for (int i=0;i<result.length;i++){
            for (int j=0;j<result[i].length;j++){
                result[i][j] = counter;
                counter++;
            }
        }
        return result;
    }

    static int calculateCountTypeSquares (List<Integer[][]> list){
        int result = list.get(0).length-1;
        for (Integer[][] temp : list){
            if (temp.length-1>result){
                result++;
            }
        }
        return result;
    }

    static int countSpace (Integer[][] arr){
        int result = (arr.length-1) * (arr[0].length-1);
        return result;
    }

    static List<Integer[][]> buildSquares (int[][] rectangle){
        List<Integer[][]> listCombination = new LinkedList<>();
        int maxCountIteration = rectangle.length>rectangle[0].length?rectangle[0].length:rectangle.length;  // проверка какая из сторон исходного массива длинее, для установки верхней границы для цикла
        for (int iter=2;iter<=maxCountIteration;iter++) {  // итер начинается с 2 так как это минимальный кв
            for (int i = 0; i < rectangle.length; i++) {
                for (int j = 0; j < rectangle[i].length-1; j=j+iter-1) {
                    if (i + iter <= rectangle.length && j + iter <= rectangle[i].length) {  // если сторона кв не превышает исходный масив
                        listCombination.add(findCombination(rectangle, i, j, iter));  // отбираем комбинацию и добавляем в резалт (i,j - координаты левого верхнего "угла" массива)
                    }
                }
            }
        }
        return listCombination;
    }

    static Integer[][] findCombination(int[][] arr, int rowIndex, int columnIndex, int step){
        Integer[][] result = new Integer[step][step];  // создаются кв-ты, с каждым увелечением step они будут больше
        int resultRowStep=0;
        int resultColumnStep;
        for (int a=rowIndex;a<rowIndex+step;a++){ // левый верхний угол + степ - лимит на к-во строк
            resultColumnStep=0;
            for (int i=columnIndex;i<columnIndex+step;i++){ // лимит на к-во елементов в строке
                result[resultRowStep][resultColumnStep] = arr[a][i];
                resultColumnStep++;
            }
            resultRowStep++;
        }
        return result;
    }
}
