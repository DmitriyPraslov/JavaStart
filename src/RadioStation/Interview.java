package RadioStation;

public class Interview extends Activities{
    String nameWhoInterview;

    Interview (String nameWhoInterview, int price, int interviewTime){
        this.nameWhoInterview = nameWhoInterview;
        this.price = price;
        time = interviewTime * 60;
        this.isPaymentActivities = true;
    }

    double takeProfit (){
        double result = 0;
        result = (time/60) * price;
        return result;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "nameWhoInterview='" + nameWhoInterview + '\'' +
                '}';
    }
}
