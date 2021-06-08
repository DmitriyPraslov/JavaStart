package RadioStation;

public class Reclame extends Activities{
    String productName;

    Reclame (String productName, int price, int time){
        this.productName = productName;
        this.price = price;
        this.time = time;
        this.isPaymentActivities = true;
    }

    @Override
    public String toString() {
        return "Reclame{" +
                "productName='" + productName + '\'' +
                '}';
    }
}
