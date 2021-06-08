package RadioStation;

public abstract class Activities {
    int time;
    boolean isPaymentActivities;
    double price;

    double takeProfit (){
        double result = 0;
        result = time * price;
        return result;
    }


}