package Practic;


import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args){
        int[] arr = {13,7,1,2,3,20};
        System.out.println(Arrays.toString(sort(arr)));
        //qwerty 4565
    }
   //по перше метод сортує в зворотньому порядку, ваші наміри неявні 
    // виходячи з назви методу. Змінна темп зявляється і втих випадках
    //в яких непотрібна.в другому методі- те саме. Пропоную виділити сегмент який змінєю елементи місцями в окремий метод з відповідною назвою- уйти від дублювання.
    public static int[] sort(int[] mas){
        for (int j = 0; j < mas.length; j++) {
            for (int i=0; i< mas.length-1; i++){
                if (mas[i]>mas[i+1]){
                    swapElement(mas, i);
                }
            }
        }
        return mas;
    }

    public static int[] sort1(int[] mas){
       int counter = -1;
       while (counter!=0){
           counter = 0;
            for (int i = 0; i < mas.length - 1; i++) {
                if (mas[i] > mas[i + 1]) {
                    swapElement(mas, i);
                    counter++;
                }
            }
        }
        return mas;
    }

    private static void swapElement(int[] mas, int i) {
        int temp = mas[i];
        mas[i] = mas[i + 1];
        mas[i+1] = temp;
    }
}
