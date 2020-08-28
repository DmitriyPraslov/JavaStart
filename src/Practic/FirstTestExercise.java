package Practic;

public class FirstTestExercise {
    public static void main(String[] args){
        Test1 firstTry = new Test1();
        firstTry.test(6);
    }
}
class Test1{
    public int test(int n){
        int result = 0;
        int counter = 0;
        char[][] mas = new char [n][];
        char k = '*';
        for (int i=0; i<n; i++){
            mas[i] = new char [i+1];
            if (n-counter>=counter+1){
                result++;
            }
            for (int j=0; j<i+1; j++){
                if (counter<n) {
                    mas[i][j] = k;
                    System.out.print(mas[i][j]);
                    counter++;
                }
            }
//            if (n<=counter){
//                result++;
//            }
            System.out.println();
        }
        System.out.println(result);
        return result;
    }
}
