package RadioStation;

public class Reclame extends Activities{
    String productName;

    Reclame (String productName, int price, double time){
        this.productName = productName;
        this.price = price;
        this.time = time;
        this.isPaymentActivities = true;
    }

    double takeProfit (){
        double result = 0;
        result = convertToSecond(time) * price;
        return result;
    }
}
