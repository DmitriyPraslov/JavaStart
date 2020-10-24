package Practic;

public class FindMinMaxAndMaxMin {
    public static void main(String[] args) {
        int[][] array = {{1,3,7},{34,78,54},{201,405,789,23}};
        System.out.println(minMax(array));
        System.out.println(maxMin(array));
    }
    public static int minMax (int[][] arr){// добре
        int[] temp = new int[arr.length];
        for (int i=0;i<arr.length;i++){
            temp[i] = findMaxElement(arr[i]);
        }
        int result = 0;// це зайве
        return result = findMinElement(temp);
    }

    public static int maxMin (int[][] arr){
        int[] temp = new int[arr.length];
        for (int i=0;i<arr.length;i++){
            temp[i] = findMinElement(arr[i]);
        }
        int result = 0;
        return result = findMaxElement(temp);
    }

    public static int findMaxElement (int[] mas){
        int result = mas[0];
        for (int i=0;i<mas.length;i++){
            if (result<mas[i]){
                result=mas[i];
            }
        }
        return result;
    }

    public static int findMinElement (int[] mas){
        int result = mas[0];
        for (int i=0;i<mas.length;i++){
            if (result>mas[i]){
                result=mas[i];
            }
        }
        return result;
    }
}
