package Alhorytm_Practic;

public class CleanTheRoom {
    public static void main(String[] args) {
        int brotherTime = 3;
        int sisterTime = 2;
        calculateCleaningRoomTime(brotherTime,sisterTime);
    }

    static void calculateCleaningRoomTime(int brotherTime, int sisterTime){
        int minutes;
        double brotherEffectivity = findEffectivityPerHour(brotherTime);
        double sisterEffectivity = findEffectivityPerHour(sisterTime);
        minutes = (int) (60/(brotherEffectivity+sisterEffectivity));
        System.out.println(minutes+" Minutes");
    }
    static double findEffectivityPerHour (int time){
        double result = 0;
        if (time<=0){
            return result;
        }
        result = 1/(double)time;
        return result;
    }
}
