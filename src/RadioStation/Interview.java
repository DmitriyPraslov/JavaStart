package RadioStation;

public class Interview extends Activities{
    String nameWhoInterview;

    Interview (String nameWhoInterview, int price, double interviewTime){
        this.nameWhoInterview = nameWhoInterview;
        this.price = price;
        time = interviewTime;
        this.isPaymentActivities = true;
    }

    double takeProfit (){
        double result = 0;
        result = time * price;
        return result;
    }
}
