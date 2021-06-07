package RadioStation;

import java.util.LinkedList;
import java.util.List;

public class Translation {
    String name;
    int translationTime;
    List<Activities> translationActivities = new LinkedList<>();

    Translation(String name ,int time){
        this.name = name;
        this.translationTime = time;
    }

    void addActivities (Activities newActivities){
        int totalActivitiesTime = getTotalActivitiesTime();
        int totalPaymentTime = getTotalPaymentTime();

        if (totalActivitiesTime + newActivities.time<=translationTime) {
            if (newActivities.isPaymentActivities==true){
                if (totalPaymentTime+ newActivities.time<translationTime/2){
                    translationActivities.add(newActivities);
                } else{
                    System.out.println("You don't have enough time for this activities");
                }
            } else {
                translationActivities.add(newActivities);
            }
        } else {
            System.out.println("You don't have enough time for this activities");
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

    void showTranslationComponents (){
        System.out.println(translationActivities);
    }

    double showProfit (){
        double result = 0;
        for (Activities temp : translationActivities){
            if (temp.isPaymentActivities==true){
                result+= temp.takeProfit();
            }
        }
        return result;
    }
}
