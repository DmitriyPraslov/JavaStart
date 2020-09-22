package Practic;

public class SeventhPractic {
        public static void main(String[] args) {
        int[][] mas1 = {{1,2},
                    {3,7,6},
                    {8,3,7,6},
                    {2,8}};
        multiplicationAndReplace2(mas1);
    }
    public static void multiplicationAndReplace1(int[][] arr){
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                if (arr[i][j] %2==0) {
                    arr[i][j] = arr[i][j] * 33;
                    System.out.print(arr[i][j]+" ");
                } else {
                    arr[i][j] = arr[i][j] * 51;
                    System.out.print(arr[i][j]+" ");
                }
            }
        }
        System.out.println();
    }
    public static int[][] multiplicationAndReplace2(int[][] arr){
        int[][] result = new int[arr.length][];
        for (int i=0;i<arr.length;i++){
            result[i]= new int[arr[i].length];
            for (int j=0;j<arr[i].length;j++){
                result[i][j] = (arr[i][j] %2==0) ? (arr[i][j] = arr[i][j] * 33) : (arr[i][j] = arr[i][j] * 51);
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        return result;
    }
}
