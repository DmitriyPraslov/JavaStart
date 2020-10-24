package E_Olimp;

public class Discounts {
    public static void main(String[] args) {
        int[] product = {11,90,5,111,75};
        System.out.println(calculateCost(product));
    }
    public static int calculateCost(int[] prod){
        int temp;
        int result=0;
        for (int i=0;i<prod.length;i=i+2){
            temp=prod[i];
            if (i!= prod.length-1&&temp<prod[i+1]){
                temp=prod[i+1];
            }
            result = result+temp;
        }
        return result;
    }
}
