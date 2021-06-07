package RadioStation;

public class Activities {
    double time;
    boolean isPaymentActivities;
    double price;

    double convertToSecond (double time){
        int result = 0;
        result = ((int) time * 60) + (((int) time*100)%100) * 60;
        return result;
    }

    double takeProfit (){
        double result = 0;
        result = time * price;
        return result;
    }


}