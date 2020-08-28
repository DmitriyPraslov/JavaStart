package Practic;

public class FourthPractic {
    public static void main(String[] args){
        FourthPractic firstCheck = new FourthPractic();
        int[][] mas1 = {{1,2,5,8,2,34,5,89,21},{32,7,3,23,14,56,17,12},{11,10}};
        int[][] mas2 = {{7,4,8,2,1},{16,76,89,34,23,45,67,98,45}};
        int[][] mas3 = {{4,1,5},{2},{10,3}};
        int[][] mas4 = {{7},{0,2},{9,8}};
//        firstCheck.arrayCheck(mas1,mas2);
        firstCheck.arrayCheck(mas3,mas4);
    }
    public int[][] arrayCheck(int[][] arr1, int[][] arr2){
        int i,j,k,l;
        int n=0;
        for (i=0;i< arr2.length;i++){
            for(j=0;j<arr2[i].length;j++){
                for (k=0;k< arr1.length;k++){
                    for (l=0;l<arr1[k].length;l++){
                        if (arr1[k][l]== arr2[i][j]){
                            System.out.print(arr1[k][l]+" ");
                            n++;
                        }
                    }
                }
            }
        }
        if (n==0){
            System.out.println("Пересечений нет!");
        }
        return arr1;
    }
}
