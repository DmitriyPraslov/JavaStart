package Practic;

public class FirstTestExercise {
    public static void main(String[] args){
        Test1 firstTry = new Test1();
        System.out.println(firstTry.test(6));
    }
}

class Test1 {// в цілому гарне рішення, тіки б подумав би над зменшенням кількості змінних та їх іменами
    public int test(int n) {
        int count = n;
        int result = 0;
        int temp = n;
        for (int i=0;i<n;i++){
            count=count-(i+1);
            if (count>=0){
                result++;
                printStar(result);
                temp = temp-result;
            } else {
                break;
            }
        }
        printStar(temp);
    return result;
    }

    public void printStar(int count){
        for (int i=0;i<count;i++){
            System.out.print("*");
        }
        System.out.println();
    }
}

