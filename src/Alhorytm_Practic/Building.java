package Alhorytm_Practic;

import java.util.Arrays;

public class Building {
    public static void main(String[] args) {
        System.out.println(findApartmentLevel(5,4, 20));
    }
    static int findApartmentLevel (int countLevel, int countApartmentPerLevel, int apartmentNumber){
        int result = 0;
        if (apartmentNumber>countLevel*countApartmentPerLevel||(apartmentNumber<0||(countLevel<0||countApartmentPerLevel<0))){
            return result;
        }
        int[][] building = buildBuilding(countLevel,countApartmentPerLevel);
        result = 1;
        for (int i=building.length-1;i>=0;i--){
            for (int j=0;j<building[i].length;j++){
                if (building[i][j]==apartmentNumber){
                    return result;
                }
            }
            result++;
        }
        return result;
    }

    static int[][] buildBuilding (int countLevel, int countApartmentPerLevel){
        int counter = 1;
        int[][] result = new int[countLevel][countApartmentPerLevel];
        for (int i=result.length-1;i>=0;i--){
            for (int j=0;j<result[i].length;j++){
                result[i][j] = counter;
                counter++;
            }
        }
        for (int i=0;i<result.length;i++) {
            System.out.println(Arrays.toString(result[i]));
        }
        return result;
    }
}
