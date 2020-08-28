package Practic;

public class FirstTestExercise {
    public static void main(String[] args){
        Test1 firstTry = new Test1();
        firstTry.test(3);
    }
}
class Test1 {
    public int test(int n) {
        String[] mas = new String[n];
        int i = 0;
        int result = 0;
        int step = 0;
        while (i<n){
            if(i==0) {
                mas[i] = "*";
                result=mas[i].length();
                System.out.println(mas[i]);
            }
            if (i>0) {
                mas[i]=mas[i-1]+"*";
                result = result+mas[i].length();
                System.out.println(mas[i]);
            }
            if(n-result>=mas[i].length()+1){
                System.out.println("like");
            }
            if (result>n){
                System.out.println(step);
                break;
            }
            i++;
        }
        return step;
    }
}
//        int counter = 0;
//        char[][] mas = new char [n][];
//        char k = '*';
//        for (int i=0; i<n; i++){
//            mas[i] = new char [i+1];
//            if (n-counter>=counter+1){
//                result++;
//            }
//            for (int j=0; j<i+1; j++){
//                if (counter<n) {
//                    mas[i][j] = k;
//                    System.out.print(mas[i][j]);
//                    counter++;
//                }
//            }
////            if (n<=counter){
////                result++;
////            }
//            System.out.println();
//        }
//        System.out.println(result);
//        return result;
//    }
//}
