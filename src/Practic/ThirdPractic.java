package Practic;


import java.util.Arrays;

public class ThirdPractic {
    public static void main(String[] args){
        checkRange(-10, 2, -5, 3);

    }
    static int [] checkRange(int d1, int d1_e, int d2, int d2_e){
        int[] mas1 = new int[(d1_e-d1)+1];
        System.out.println(mas1.length);
        int[] mas2 = new int[(d2_e-d2)+1];
        System.out.println(mas2.length);
        for (int i = 0; i< mas1.length; i++){
            mas1[i] = d1;
            System.out.print(mas1[i]+ " ");
            d1++;
        }
        System.out.println();
        int count = 0;
        for (int k = 0; k< mas2.length; k++){
            mas2[k] = d2;
            System.out.print(mas2[k]+ " ");
            d2++;
        }
        System.out.println();
        for (int temp1 : mas1){
            for (int temp2 : mas2){
                if (temp1==temp2){
                    count++;
                }
            }
        }
        int c = 0;
        int[] mas3 = new int[count];
        for (int temp1 : mas1){
            for (int temp2 : mas2){
                if (temp1==temp2){
                    mas3[c] = temp1;
                    c++;
                }
            }
        }
        return mas3;
    }
}
