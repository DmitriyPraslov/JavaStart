package RadioStation;

import java.util.LinkedList;
import java.util.List;

public class Translation {
    private String name;
    private int translationTime;
    private RadioHost radioHost;
    private List<Activities> translationActivities = new LinkedList<>();

    Translation(String name ,double time, RadioHost radioHost){
        this.name = name;
        translationTime = convertToSecond(convertToSecond(time));
        this.radioHost = radioHost;
    }

    int convertToSecond (double time){
        int result;
        result = ((int) time * 60) + ((int) time*100)%100;
        return result;
    }

    public int getTranslationTime() {
        return translationTime;
    }

    boolean addActivities (Activities newActivities){
        int totalActivitiesTime = getTotalActivitiesTime();
        int totalPaymentTime = getTotalPaymentTime();

        if (totalActivitiesTime + newActivities.time<=translationTime) {
            if (newActivities.isPaymentActivities==true){
                if (totalPaymentTime+ newActivities.time<translationTime/2){
                    translationActivities.add(newActivities);
                    return true;
                } else{
                    System.out.println("You don't have enough time for this activities");
                    return false;
                }
            } else {
                translationActivities.add(newActivities);
                return true;
            }
        } else {
            System.out.println("You don't have enough time for this activities");
            return false;
        }
    }

    int getTotalActivitiesTime(){
        int result = 0;
        for (Activities temp : translationActivities){
            result+=temp.time;
        }
        return result;
    }

    int getTotalPaymentTime(){
        int result = 0;
        for (Activities temp : translationActivities){
            if (temp.isPaymentActivities==true){
                result+=temp.time;
            }
        }
        return result;
    }

    void startTranslation (){
        for (Activities temp : translationActivities){
            System.out.println(temp);
        }
        radioHost.addTranslation(this);
    }

    void showProfit (){
        double result = 0;
        for (Activities temp : translationActivities){
            if (temp.isPaymentActivities==true){
                result+= temp.takeProfit();
            }
        }
        System.out.println(this.name+" profit "+result);
    }
}
